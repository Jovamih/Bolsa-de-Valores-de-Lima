
package Modelo;
import Modelo.Components.Accion;
import Modelo.Components.Credenciales;
import Modelo.Components.DatosPersonales;
import java.util.ArrayList;
import java.io.Serializable;
import javax.swing.ImageIcon;
public class Inversionista implements Serializable{
    private static final long serialVersionUID=1L;
    private  DatosPersonales personal; //definido con 'final' porque solo seran asignados una sola vez
    private ImageIcon imagen;
    private  String RUT;
    private Credenciales cuenta;
    private double capital;
    private String SAB; //nombre del SAB
    private  ArrayList<Accion> acciones;
    private int totalOperaciones=0;
    private boolean primerInicio=false; //nos dice si ya inicio sesion por primera vez
    public Inversionista(DatosPersonales personal,Credenciales cuenta){
        this.personal=personal;
        this.cuenta=cuenta;
        acciones= new ArrayList<>();
        imagen= new ImageIcon();
    }
    public Inversionista(){
        //constructor vacio para inicializar por defecto
    }
   public void registrarSAB(String ID){
        this.SAB= ID;
   }
  public String getSAB(){
      return SAB;
  }
   public Credenciales getCredenciales(){
       return cuenta;
   }
   public void setCredenciales(Credenciales cuenta){
       this.cuenta=cuenta;
   }
   public void setCapital(double capital){
       this.capital= capital;
   }
   public double getCapital(){
       return capital;
   }
   public void setRUT(String RUT){
       this.RUT=RUT;
   }
   public String getRUT(){
       return RUT;
   }
   public String getTitular(){
       return personal.getNombre();
   }
   public void countOperacion(){
       totalOperaciones++;
   }
   public ArrayList<Accion> getAcciones(){
       return this.acciones;
   }
   public Accion getAccion(String empresa){
       for(Accion act : acciones){
           if(act.getEmpresa().equals(empresa)) return act;
       }
       return null;
   }
   public void guardarAccion(Accion accion){ //añade una actualizaion de acciones, si no existe los agrega
       int code= acciones.indexOf(accion);
       if(code!=-1){
           acciones.set(code,accion);
       }else acciones.add(accion); //si no existe lo añado
   }
   public void removerAccion(Accion accion){
       int code= acciones.indexOf(accion);
       if(code!=-1){
           acciones.remove(code);
       }
   }
   public boolean getNuevoInicio(){
       return primerInicio;
       
   }
   public void setNuevoInicio(boolean primerInicio){
       this.primerInicio= primerInicio;
   }
   public int getTotalOperaciones(){
       return this.totalOperaciones;
   }
   public void setImagen(ImageIcon imagen){
       this.imagen= imagen;
   }
   public ImageIcon getImagen(){
       return imagen;
   }
   @Override
   public boolean equals(Object obj){
       boolean eqls=false;
       if(obj instanceof Inversionista){
           Inversionista inv= (Inversionista)obj;
           Credenciales cred= inv.getCredenciales();
           if(cuenta.getCorreo().equals(cred.getCorreo()) && cuenta.getContraseña().equals(cred.getContraseña()) ){
               eqls=true;
           }
       }
       return eqls;
   }
}
