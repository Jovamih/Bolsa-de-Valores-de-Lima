
package Modelo;
import java.util.Random;
public class BOT {
  private static final Random ram= new Random();
  public static String generarNombre(){
      String[] values={"a","b","c","o","n","i","u","d","r"};
      String name="";
      for(int i=0;i<7;i++){
          int index=0; //indice del arreglo
          index=0 +ram.nextInt(values.length);
          name= name+values[index];
      }
          return name;//el retorno de la funcion name no lo hace cualqui
  }
  public static String generarRUT(){
      String[] values={"6","A","9","B","8","C","2","O","7","N","5","I","3","U","D","R","8","6"};
      String RUT="";
      
      for(int i=0;i<7;i++){
          int index=0; //indice del arreglo
          index=0 +ram.nextInt(values.length);
          RUT= RUT+values[index];
      }
          return RUT;
  }
  public static String generarOperacion(){
      String[] op={"COMPRA","VENTA"};
      return op[0+ram.nextInt(op.length)];
  }
  public static int generarAcciones(int min, int max){
      return min+ram.nextInt(max-min+1);
  }
  public static double genValorAccion(double min, double max){
      return min+ (max-min)*ram.nextDouble();
  }
}
