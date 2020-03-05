package Controlador;

import Modelo.*;
import Vista.*;
import java.io.InvalidClassException;
/**
 *  Bolsa de Valores de Lima 
 * <p>
 * Programa para simular la bolsa de valores de Lima
 * @author Johan Valerio Mitma
 * @version 11.2
 * @since 2019
 */
public class Run { 
    /**
     * Funcion principal {@code main(String[] args)}
     * @param args: Argumentos de terminal
     */
  public static void main(String[] args){
       modoUsuario();
      // modoAdministrador();
    }
  /**
   *Funcion {@code modoUsuario()} 
   * Esta funcion  contiene la logica principal
   * <p>
   * La funcion no acepta ni devuelve un valor, es esta se pueden apreciar los patrones de diseño
   *  MVC (Modelo vista controlador) 
   */
    public static void modoUsuario(){
                try{
        ModeloBolsaPrincipal modelo= new ModeloBolsaPrincipal();
        SesionVista sesion= new SesionVista();
        SoftwareVista software= new SoftwareVista();
        ControladorPrincipal controller= new ControladorPrincipal(modelo, sesion, software);
          sesion.setController(controller);
          software.setController(controller);
           sesion.run();
      }catch(InvalidClassException e){
                    System.out.println("Ha cambiado de version de las clases\n"+e.getMessage());
         // e.printStackTrace();
      }catch(Exception e){
                    System.out.println(e.getMessage());
      }
    }
   
}
