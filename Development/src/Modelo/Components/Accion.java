
package Modelo.Components;
import java.io.Serializable;
import java.util.Objects;
@SuppressWarnings("EqualsAndHashcode")
public class Accion implements Serializable{
    private final String titular;
    private final String empresa;
    private int acciones;
    public Accion(String titular, String empresa,int acciones){
        this.titular= titular.toUpperCase();
        this.empresa= empresa;
        this.acciones= acciones;
    }
    public void setAcciones(int acciones){
        this.acciones= acciones;
    }
    public String getTitular(){
        return titular;
    }
    public String getEmpresa(){
        return empresa;
    }
    public int getAcciones(){
        return acciones;
    }
    @Override
    public boolean equals(Object obj){
        boolean equls=false;
        if(obj instanceof Accion){
            Accion action=(Accion)obj;
            if(empresa.equals(action.getEmpresa())){
                equls=true;
            }
        }
        return equls;
    }
   
}
