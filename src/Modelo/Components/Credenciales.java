//Los credenciales de accesos de un usuario (puede ser un natural , persona o cliente)
package Modelo.Components;
import java.io.Serializable;
public class Credenciales implements Serializable {
    private String correo;
    private String contraseña;
    public Credenciales(String correo, String contraseña){
        this.correo=correo;
        this.contraseña=contraseña;
    }
    public void setCorreo(String correo){
        this.correo=correo;
    }
    public void setContraseña(String contraseña){
        this.contraseña=contraseña;
    }
    public String getCorreo(){
        return this.correo;
    }
    public String getContraseña(){
        return this.contraseña;
    }
    @Override
    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(Object cred){
        if(cred==null) return false;
        Credenciales cred0=(Credenciales)cred;
        if(cred0.getCorreo().equals(getCorreo()) && cred0.getContraseña().equals(getContraseña()))
        return true;
        else return false;
    }
}
