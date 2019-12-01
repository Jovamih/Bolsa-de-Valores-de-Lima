package Controlador;

import Controlador.*;
import Modelo.*;
import Modelo.DataAccessObject.DataBase;
import Modelo.DataAccessObject.FactoryDataBase;
import Vista.*;
import java.util.Scanner;
public class Run {
  public static void main(String[] args){
       modoUsuario();
      // modoAdministrador();
    }
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
          e.printStackTrace();
      }
    }
   
}
