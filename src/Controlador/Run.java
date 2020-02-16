package Controlador;

import Modelo.*;
import Vista.*;
/**
 * <h1> Bolsa de Valores de Lima </h1>
 * <p>
 * Programa para simular la bolsa de valores de Lima
 * @author Johan Valerio Mitma
 * @version 11.2
 * @since 2019
 */
public class Run { 
    /**
     *<h1> Funcion principal {@code main(String[] args)}</h1>
     * 
     */
  public static void main(String[] args){
       modoUsuario();
      // modoAdministrador();
    }
  /**
   *<h1>Funcion {@code modoUsuario()} </h1>
   * Esta funcion  contiene la logica principal
   * <p>
   * La funcion no acepta ni devuelve un valor, es esta se pueden apreciar los patrones de diseño
   * <h1> MVC (Modelo vista controlador) </h1>
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
      }catch(Exception e){
          System.out.println("Error en :"+e);
         // e.printStackTrace();
      }
    }
   
}
