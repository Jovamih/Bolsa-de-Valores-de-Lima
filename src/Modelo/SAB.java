/*El SAB es un intermediario entre el cliente y la bolsa de valores de Lima
tiene a su disposicion un lista de clientes "ArrayList<String> clientes" con el que gestiona sus operaciones
de compra y venta.
Es el unico que puede interactuar con la Bolsa De Valores.
Interactua tambien con el CAVALI para registrar un nuevo inversionista, 
ya que tampoco el mismo Inversionista puede registrase directamente.
*/
package Modelo;
import java.io.Serializable;
public class SAB implements Serializable{
    private  String nombre;
    private  double comision;
    private  String ID;            //ID unico del SAB
    public SAB(String nombre, double comision, String ID){
        this.nombre=nombre;
        this.comision=comision;
        this.ID=ID.toUpperCase();
    }
    public SAB(){
        //constructor vacio para inicializar las variables por defecto
    }
    public double getComision(){
        return comision;
    }
    public String getID(){
        return ID;
    }
   public String getNombre(){
        return nombre;
    }
   @Override
   public String toString(){
       return "\nSAB: "+this.getNombre()+ " | Comision: "+this.getComision()+"\n";
   }
}
