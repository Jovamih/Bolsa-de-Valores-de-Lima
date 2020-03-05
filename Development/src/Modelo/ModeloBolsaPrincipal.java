
package Modelo;

import Modelo.Components.Accion;
import Modelo.Components.Constants;
import Modelo.Components.Credenciales;
import Modelo.Components.Solicitud;
import Modelo.DataAccessObject.DataBase;
import Modelo.DataAccessObject.FactoryDataBase;
import java.util.ArrayList;

public class ModeloBolsaPrincipal {
    private final BolsaDeValores bolsa; //es el nucleo de la Aplicacion
    private SAB sociedadBolsa;     //Intermediario entre la BVL y el cliente
    private Inversionista usuario; //usuario que opera atraves de su SAB y pertenece a la App
    private DataBase baseDatos;    //base de datos multiples (varia segun lo especifiquemos)
    public ModeloBolsaPrincipal(){
        bolsa= new BolsaDeValores();    //solo existe una BVL
        sociedadBolsa = new SAB();   //datos vacios para el SAB
        usuario= new Inversionista();  //datos vacios del inversionista
        baseDatos= FactoryDataBase.getBaseDeDatos(DataBase.OFFLINE);
    }
 
    public boolean iniciarSesion(Credenciales cuenta){
        if((usuario=baseDatos.getInversionista(cuenta))!=null){ //si retorna null no existe, de lo contrario sí
            //Obtengo la SAB en la que se encuentra afiliado el cliente, pero primero verifico si tiene uno!
            if(usuario.getNuevoInicio()==true){
                sociedadBolsa=baseDatos.getSAB(usuario.getSAB());
            } //configuro para que luego de inciar sesion, tenga que agrgar uno obligatoriamente
            return true;
        }
        return false;
    }
    /**
     * La funcion {@code registrarCliente}
     * retorna {@code TRUE} si el cliente/inversionista ya esta registrado,
     * de lo contrario {@code FALSE}
     * 
     */
    public boolean registrarCliente(Inversionista cliente){
        Credenciales cuenta= cliente.getCredenciales(); //extraemos los credenciales del Inversionista registrado en la APP
        if(baseDatos.getInversionista(cuenta)!=null){
            return false;// la cuenta ya existe!!! (usuario y contraseña)
        }else {
            //procedemos a registrar el usuario en la Base de Datos
            cliente.setNuevoInicio(false);
            baseDatos.addInversionista(cliente);
            //recordemos que cuando lo registramos aun no tiene un SAB y capital inicial, lo cual se lo pediremos
            //una vez que inicie sesion, pues muy diferente es estar registrado en la Aplicacion que en la Bolsa de Valores.
            return true;
        }
    }
    public void primerInicio(double capital, String SAB){
         usuario.registrarSAB(SAB);
         usuario.setCapital(capital);
         usuario.setRUT(BOT.generarRUT()); //generrar rut de 11 digitos
         sociedadBolsa=baseDatos.getSAB(SAB);
         if(sociedadBolsa!=null) usuario.setNuevoInicio(true);
       
         baseDatos.updateInversionista(usuario);
    }
    public int operacion(String razon, String empresa, int acciones, double precio){
        Solicitud orden= new Solicitud(razon,empresa,acciones,precio);
        
        switch(razon){
            case Constants.COMPRA:
                if(baseDatos.getEmpresa(empresa).getAcciones()<acciones)  //si la empresa tiene menos acciones de las que solicitamos
                    return Constants.ACCION_INSUFICIENTE; // retorno =codigo de acciones insuficientes
                else if(baseDatos.getEmpresa(empresa).getValorCompra()>precio ) //si nuestro precio que establecemos comprar es inferior al establecido
                    return Constants.PROPUESTA_INVALIDA;  //Retorno =codigo de propuesta invalida
                else if(acciones*precio>usuario.getCapital())           //si el monto con el que deseamos comprar es mayor al que disponemos
                    return Constants.NO_RECURSOS;       //Retorno =no tienes suficientescapital para comprar
                else{
                //recien opero en la bolsa, recordemos que cuando compramos obtenemos una determinada accion
                BolsaDeValores.ProcesaPropuestaCompra(sociedadBolsa.getComision(), orden, usuario);
                }
                break;
            case Constants.VENTA:
                if(usuario.getAccion(empresa)==null) //si el usuario no posee dichas acciones de la empresa
                    return Constants.NO_ACCIONES;
                else if(usuario.getAccion(empresa).getAcciones()<acciones) //si las acciones que deseo vender son mayores a las que dispongo de dicha empresa
                      return Constants.ACCION_INSUFICIENTE;  //Retorno= Codigo de acciones insuficientes
                else if(precio<baseDatos.getEmpresa(empresa).getValorVenta()) //si el precio al que deseo vender es
                      return Constants.PROPUESTA_INVALIDA;
                else {
                    //lo dejamos vacio para futuras implementaciones
                    BolsaDeValores.ProcesaPropuestaVenta(sociedadBolsa.getComision(), orden, usuario);
                      }
                break;
            default: //esto no tendria porque suceder 
                break;
              }
        
     orden=null;
     usuario.countOperacion();
     baseDatos.updateInversionista(usuario);
    return Constants.OPERACION_EXITOSA;
    }
    public String respuestaOperacion(){
         return BolsaDeValores.getRespuestaOperacion();
    }
    public ArrayList<Empresa> getEmpresaTablaInformacion(){
                 return baseDatos.getListaEmpresa();
    }
    public ArrayList<Accion> getAccionInversionista(){
                return usuario.getAcciones();
    }
    public ArrayList<SAB> listaSAB(){
        return baseDatos.getListaSAB();
    }
    public ArrayList<Empresa> listaEmpresas(){
        return baseDatos.getListaEmpresa();
    }
   
    public Inversionista getInversionista(){
        return this.usuario;
    }
    public void reiniciar(){
        usuario=null;
       // sociedadBolsa=null;
    }
}
