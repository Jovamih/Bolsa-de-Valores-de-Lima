package Modelo.Components;
import java.io.Serializable;
public class DatosPersonales  implements Serializable{
    private String nombre;
    private String apellidos;
    private String nacionalidad;
    private String pais;
    private int edad;
    private long dni;
    public DatosPersonales(String nombre,String apellidos,String nacionalidad,String pais, int edad, long dni){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.nacionalidad=nacionalidad;
        this.pais=pais;
        this.edad=edad;
        this.dni=dni;
        
    }
    public void setNombres(String nombre, String apellidos){ //asigna,os el nombre a la persona
        this.nombre=nombre;
        this.apellidos=apellidos;
    }
    public void setEdad(int edad){
        this.edad=edad;
    }
    public void setDNI(long dni){
        this.dni=dni;
    }
    public void setUbicacion(String nacionalidad, String pais){
        this.nacionalidad=nacionalidad;
        this.pais=pais;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getApellidos(){
        return this.apellidos;
    }
    public String getNacionalidad(){
        return this.nacionalidad;
    }
    public String getPais(){
        return this.pais;
    }
    public int getEdad(){
        return this.edad;
    }
    public long getDNI(){
        return this.dni;
    }
}
