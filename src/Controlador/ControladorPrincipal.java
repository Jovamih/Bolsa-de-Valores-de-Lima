package Controlador;
import Modelo.Components.Accion;
import Modelo.Components.Constants;
import Modelo.Components.Credenciales;
import Modelo.Components.DatosPersonales;
import Modelo.Empresa;
import Modelo.Inversionista;
import Vista.InterfazVista;
import Modelo.ModeloBolsaPrincipal;
import Modelo.SAB;
import Vista.Administrador;
import Vista.Components.DialogoInicio;
import Vista.SesionVista;
import Vista.SoftwareVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class ControladorPrincipal implements ActionListener {
    private SesionVista sesion;
    private SoftwareVista software;
    private ModeloBolsaPrincipal modelo;
    public ControladorPrincipal(ModeloBolsaPrincipal modelo, SesionVista sesion, SoftwareVista software){
        this.sesion= sesion;
        this.software= software;
        this.modelo= modelo;
    }
    @Override
    public void actionPerformed(ActionEvent evt){
        Object objeto= evt.getSource();
        if(objeto instanceof JButton){
            JButton boton= (JButton)objeto;
            String ACCION=boton.getActionCommand();
            switch(ACCION){
                case "REGISTRAR_USUARIO":
                    registrarListener();
                    break;
                case "INICIAR_SESION":
                    sesionListener();
                    break;
                case "PRIMER_INICIO":
                    primerInicioListener();
                    break;
                case "INVERTIR":
                    invertirListener();
                    break;
                case "CERRAR_SESION":
                    cerrar_sesionListener();
                default:
                    break;
            }
         }
        }
    private void sesionListener(){
        String usuario= sesion.getPSesion().getUsuario();
        String contraseña = sesion.getPSesion().getPassword();
        if(usuario.equals("administrador") && contraseña.equals("administrador")){
            sesion.dispose();
            Administrador admin= new Administrador();
                          admin.run();
        }else
        if(usuario.isEmpty() || contraseña.isEmpty()){
            sesion.enviarMensaje("Datos incompletos","Error de Inicio",JOptionPane.WARNING_MESSAGE);
        }else{
            Credenciales cuenta= new Credenciales(usuario,contraseña);
        if(modelo.iniciarSesion(cuenta)){
            sesion.getPSesion().limpiar_datos();
            sesion.dispose();
            software.run();
            if((modelo.getInversionista().getNuevoInicio())==false){
                for(SAB sab :modelo.listaSAB()){ //llenamos la lista de SAB al dialogo inicial
                 software.getDialogoInicio().añadirSab(sab.getNombre());
                  }
                software.getDialogoInicio().run();
            }
            cargarDatos();
           
        }else
            sesion.enviarMensaje("Usuario no encontrado","Falló Autenticación",JOptionPane.ERROR_MESSAGE);
            
        }
        
    }
    private void registrarListener(){
        String nombre= sesion.getPRegistro().getNombre();
        String apellido= sesion.getPRegistro().getApellido();
        String DNI= sesion.getPRegistro().getDNI();
        String nacion= sesion.getPRegistro().getNacionalidad();
        String pais= sesion.getPRegistro().getPais();
        String correo= sesion.getPRegistro().getCorreo();
        ImageIcon foto= sesion.getPRegistro().getFoto();
        char[] password1= sesion.getPRegistro().getPassword1();
        char[] password2= sesion.getPRegistro().getPassword2();
        if(nombre.isEmpty() || apellido.isEmpty() || DNI.isEmpty()|| correo.isEmpty()||foto==null|| String.valueOf(password1).isEmpty()|| String.valueOf(password2).isEmpty()){
            sesion.enviarMensaje("Los datos de registro estan incompletos!","FAIL REGISTRY",JOptionPane.WARNING_MESSAGE);
        }else if(!Arrays.equals(password1, password2)){
            sesion.enviarMensaje("Las dos contraseñas deben coincidir!", "ERROR PASSWORD",JOptionPane.ERROR_MESSAGE);
        }else{
             DatosPersonales personal= new DatosPersonales(nombre, apellido,nacion, pais,0,Long.parseLong(DNI));
             Credenciales auth = new Credenciales(correo, String.valueOf(password1));
            Inversionista inver= new Inversionista(personal, auth);
                            inver.setImagen(foto);
            //verificamos s ya existe el usuario (por correo y contraseña
            if(modelo.registrarCliente(inver)!=false){
                sesion.enviarMensaje("Usuario registrado correctamente","REGISTRO EXITOSO", JOptionPane.INFORMATION_MESSAGE);
                sesion.getPRegistro().limpiar_datos();
            }else sesion.enviarMensaje("Al parecer el usuario ya existe!, cambie cambie sus credenciales!","FAIL REGISTRY",JOptionPane.ERROR_MESSAGE); 
        }
    }
    private void invertirListener(){
        
        if(software.getValores()<=0 || software.getValorAcciones()<=0.0){
            software.enviarMensaje("Valores ingresados no validos para la operacion","ERROR DE INVERSION",JOptionPane.ERROR_MESSAGE);
        }else if(software.getEmpresaSeleccionada()==null){
            software.enviarMensaje("No hay empresas disponibles en este momento","RECURSOS INSUFICIENTES", JOptionPane.WARNING_MESSAGE);
        }else{ 
               //recien procedemos con la operacion y realizamos una solicitud al SAB dentro del modelo
             
           int query= modelo.operacion(software.getOperacionSeleccionada(),software.getEmpresaSeleccionada(),software.getValores(),software.getValorAcciones());
               switch(query){
                   case Constants.NO_RECURSOS:
                       software.enviarMensaje("Usted no cuenta con Saldo suficiente para realizar dicha accion","SALDO INSUFICIENTE",JOptionPane.WARNING_MESSAGE);
                       break;
                   case Constants.NO_ACCIONES:
                       software.enviarMensaje("Usted no cuenta con la accion que desea vender","ERROR ACCION",JOptionPane.ERROR_MESSAGE);
                       break;
                   case Constants.ACCION_INSUFICIENTE:
                       software.enviarMensaje("Las acciones que desea comprar/vender no son suficientes para realizar dicha operacion","ACCION INSUFICIENTE",JOptionPane.INFORMATION_MESSAGE);
                       break;
                   case Constants.PROPUESTA_INVALIDA:
                       software.enviarMensaje("No puede comprar/vender a un precio mayor o menor al establecido","ERROR PROPUESTA",JOptionPane.WARNING_MESSAGE);
                       break;
                   case Constants.OPERACION_EXITOSA:
                       software.getDialogoPoliza().setMensaje(modelo.respuestaOperacion());
                       software.getDialogoPoliza().run();
                       break;
                   default: 
                       break;
               }
        }
        software.limpiarDatos();
        updateInformacion();
    }
    private void cargarDatos(){
        //seccion de negocios
        for(Empresa e: modelo.getEmpresaTablaInformacion()){
            software.añadirInformacionBolsa(e.getNombre(), e.getNemonico(),e.getSector(),e.getValorCompra(),e.getValorVenta(),e.getVariacion(),e.getAcciones());
            software.añadirComboCompra(e.getNombre());
        }
        //seccion de informacion personal
        Inversionista inv= modelo.getInversionista();
            software.setNombre(inv.getTitular());
            software.setSAB(inv.getSAB());
            software.setRUT(inv.getRUT());
            software.setCapital(inv.getCapital());
            software.setFoto(inv.getImagen());
   
            updateInformacion();
    }
    private void updateInformacion(){
        software.setCapital(modelo.getInversionista().getCapital());
        software.setUtilidad(modelo.getInversionista().getCapital());
        software.setTotalOperaciones(modelo.getInversionista().getTotalOperaciones());
        software.borrarInformacionAcciones();
        software.borrarComboVentas();
        for(Accion action : modelo.getAccionInversionista()){
            software.añadirMisAcciones(action.getEmpresa(),action.getAcciones());
            software.añadirComboVenta(action.getEmpresa());
        }
    }
    private void updateEntorno(){
        //para futuuras versiones
    }
    private void primerInicioListener(){
         if(software.getCInicial()>0 && software.getSAB()!=null){
          modelo.primerInicio(software.getCInicial(),software.getSAB());
          
          software.limpiarDatosDialogo();
          software.getDialogoInicio().dispose();
          software.validate();
         }
    }
    private void cerrar_sesionListener(){
        modelo.reiniciar();
        software.reiniciar();
        
        software.dispose();
        sesion.run();
    }
}
