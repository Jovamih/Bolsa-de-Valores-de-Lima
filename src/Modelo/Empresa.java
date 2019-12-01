/*
Las empresas son aquellas que ponen su acciones a un valor de venta y compra 
determinado segun su situacion financiera actual
*/
package Modelo;
import java.io.Serializable;
public class Empresa implements Serializable{
    private final String nombre;
    private String sector;
    private String nemonico;
    private int accionesDisponibles;
    private double valorCompra;
    private double valorVenta;
    private double variacion;
    public Empresa(String nombre, int acciones,double valorCompra, double valorVenta){
        this.nombre=nombre;
        this.accionesDisponibles=acciones;
        this.valorCompra=valorCompra;
        this.valorVenta=valorVenta;
    }
    public void setAcciones(int acciones){
        this.accionesDisponibles=acciones;
    }
    public int getAcciones(){
        return this.accionesDisponibles;
    }
    public void setValorVenta(double valorVenta){
        this.valorVenta=valorVenta;
    }
    public void setValorCompra(double valorCompra){
        this.valorCompra=valorCompra;
    }
    public double getValorVenta(){
        return valorVenta;
    }
    public double getValorCompra(){
        return valorCompra;
    }
    public String getNombre(){
        return nombre;
    }
   public void setSector(String sector){
       this.sector= sector.toUpperCase();
   }
   public void setNemonico(String nemonico){
       this.nemonico= nemonico;
   }
   public String getSector(){
       return sector;
   }
   public String getNemonico(){
       return nemonico;
   }
   public void setVariacion(double variacion){
       this.variacion= variacion;
   }
   public double getVariacion(){
       return variacion;
   }
   @Override
   public boolean equals(Object obj){
       boolean eqls=false;
       if(obj instanceof Empresa){
           Empresa emp= (Empresa)obj;
           if(emp.getNombre().equals(this.nombre)){
               eqls=true;
           }
       }
       return eqls;
   }
}
