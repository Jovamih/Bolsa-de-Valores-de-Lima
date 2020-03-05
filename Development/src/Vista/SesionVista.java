package Vista;

import Controlador.ControladorPrincipal;
import Vista.Components.Login;
import Vista.Components.Registro;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.event.*;
/**
 * Clase {@code SesionVista}
 * Gestiona las vistas de Inicio de sesion y el registro de nuevos Usuarios
 * <p>
 * Hereda de la clase {@link javax.swing.JFrame}
 * Implementa la Interfaz {@link InterfazVista}
 * Administra los Paneles {@link Login} y {@link Registro}
 */
public class SesionVista extends JFrame implements InterfazVista{
    private Login iniciarSesion;
    private Registro registrarUsuario;
    private Container contenido= this.getContentPane();
    private CardLayout targeta= new CardLayout();
    
      public SesionVista() throws Exception{
          settings();
          initComponents();
      }
    private void settings() throws Exception{
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Bolsa de Valores de Lima");
        this.setSize(790,480);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setIconImage(new ImageIcon(getClass().getResource("/Recursos/icono.jpg")).getImage());
    }
   private void initComponents(){
       //inicializamos los componentes
       contenido.setLayout(targeta);
       iniciarSesion= new Login("/Recursos/puerto.jpg");
       registrarUsuario= new Registro("/Recursos/cartagena.jpg");
      // enlazo mis oaneles con el Frame principal 1
       iniciarSesion.setControlFrame(this);
       registrarUsuario.setControlFrame(this);
    
        contenido.add(iniciarSesion,"LOGIN");
        contenido.add(registrarUsuario,"REGISTRY");
   }
   public void changePanel(String card){
      if(card.equals("LOGIN")){
          //sliderPane.nextPanel(30,iniciarSesion,sliderPane,sliderPane.right);
          targeta.show(contenido,card);
      }else if(card.equals("REGISTRY")){
          //sliderPane.nextPanel(30,registrarUsuario,sliderPane, sliderPane.right);
          targeta.show(contenido,card);
      }
   }
   public void enviarMensaje(String contenido, String titulo, int type){
        JOptionPane.showMessageDialog(this,contenido, titulo, type);
    }
   public Login getPSesion(){
       return iniciarSesion;
   }
   public Registro getPRegistro(){
       return registrarUsuario;
   }
   /**
    * Muestra en inicia la vista
    */
    @Override
    public void run() {
       this.setLocationRelativeTo(null);
       this.setVisible(true);
    }
    /**
     * Gestiona el controlador que escuchara los eventos de los Paneles que posee
     * @param controller: Controlador que implementa la Interfaz {@link java.awt.event.ActionListener}
     * 
     */
    @Override
    public void setController(ActionListener controller) {
        registrarUsuario.setController(controller);
        iniciarSesion.setController(controller);
    }
}
