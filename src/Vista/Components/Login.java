
package Vista.Components;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import java.awt.Cursor;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import Vista.Components.JPanelPRO;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;
import Controlador.ControladorPrincipal;
import Modelo.Components.Constants;
import Vista.SesionVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.*;
/**
 * <h1> Clase {@code Login}</h1>
 * Encargada de mostrar datos para el correspondiente inicio de sesion
 * <p>
 * Esta clase es un objeto {@code JPanel} hereda de la clase {@link JPanelPRO}
 * @see JPanelPRO
 * @inheritDoc 
 */
public class Login extends JPanelPRO{
    private JLabel SALIR;
    private  JLabel titulo;
    private JTextField text_usuario;
    private JPasswordField text_password;
    private JLabel label_usuario;
    private JLabel label_password;
    private JLabel informacion;
    private JButton iniciar;
    private JLabel registrarse;
    private JLabel copyright;
    private JCheckBox check;
    private SesionVista frame;
    private int X,Y;
    private Color blanco= new Color(255,255,255);
        public Login(String url) {
        super(url);
        initComponents();
        addEventsIndependientes();
    } 
   private void initComponents(){
       this.setLayout(null);
       titulo= new JLabel();
       label_usuario= new JLabel();
       label_password= new JLabel();
       informacion= new JLabel();
       text_usuario= new JTextField();
       text_password= new JPasswordField();
       registrarse= new JLabel();
       copyright= new JLabel();
       iniciar= new JButton();
       SALIR= new JLabel();
       check= new JCheckBox();

        titulo.setFont(new Font("Segoe UI Light", 0, 48)); // NOI18N
        titulo.setForeground(blanco);
        titulo.setText("Bolsa de Valores de Lima");
        titulo.setBounds(160, 30, 510, 50);
            this.add(titulo);
        label_usuario.setFont(new Font("Segoe UI Light", 1, 24)); // NOI18N
        label_usuario.setForeground(blanco);
        label_usuario.setText("Usuario");
        label_usuario.setBounds(170, 130, 90, 32);
            this.add(label_usuario);
        label_password.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        label_password.setForeground(blanco);
        label_password.setText("Contraseña");
        label_password.setBounds(170, 210, 130, 32);
            this.add(label_password);
        text_usuario.setFont(new Font("Segoe UI Light", 1, 20)); // NOI18N
        text_usuario.setHorizontalAlignment(JTextField.CENTER);
        text_usuario.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,blanco));
        text_usuario.setForeground(blanco);
        text_usuario.setOpaque(false);
         text_usuario.setBounds(240, 150, 360, 40);
            this.add(text_usuario);
        text_password.setFont(new Font("Segoe UI Light", 1, 20)); // NOI18N
         text_password.setHorizontalAlignment(JTextField.CENTER);
         text_password.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, blanco));
         text_password.setForeground(blanco);
         text_password.setOpaque(false);
         text_password.setBounds(250, 250, 350, 30);
            this.add( text_password);
        registrarse.setFont(new Font("Segoe UI Light", 0, 18)); // NOI18N
         registrarse.setText("No tiene una cuenta? Registrese");
         registrarse.setCursor(new Cursor(Cursor.HAND_CURSOR));
         registrarse.setBounds(500, 400, 260, 30);
         registrarse.setForeground(blanco);
            this.add(registrarse);
        check.setFont(new Font("Segoe UI Light", 0, 14)); // NOI18N
        check.setText("Mantener Sesion Iniciada");
        check.setForeground(blanco);
        check.setOpaque(false);
        check.setBounds(400, 290, 180, 23);
            this.add(check);
        copyright.setFont(new Font("Segoe UI Light", 1, 14)); // NOI18N
        copyright.setText("Copyright @2019");
        copyright.setForeground(blanco);
        copyright.setBounds(70, 410, 140, 20);
        copyright.setOpaque(false);
            this.add(copyright);
        iniciar.setBackground(blanco);
         iniciar.setFont(new Font("Segoe UI Light", 0, 18)); // NOI18N
         iniciar.setForeground(blanco);
         iniciar.setText("Iniciar Sesion");
          iniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));
         iniciar.setActionCommand("INICIAR_SESION");
         iniciar.setOpaque(false);
         iniciar.setBounds(300, 330, 230, 50);
            this.add( iniciar);
            
         informacion.setForeground(blanco);
         informacion.setFont(new Font("Segoe UI Light", 1, 24)); // NOI18N
         informacion.setHorizontalAlignment(SwingConstants.CENTER);
         informacion.setText("?");
         informacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
         informacion.setBounds(718, 0, 30, 30);
            this.add(informacion);
         SALIR.setForeground(blanco);
         SALIR.setFont(new Font("Segoe UI Light", 1, 24)); // NOI18N
         SALIR.setHorizontalAlignment(SwingConstants.CENTER);
         SALIR.setText("X");
         SALIR.setCursor(new Cursor(Cursor.HAND_CURSOR));
         SALIR.setBounds(750, 0, 30, 30);
         this.add( SALIR);
   }
   public void setControlFrame(SesionVista frame){
       this.frame=frame;
   }
   public String getUsuario(){
       return text_usuario.getText();
   }
   public String getPassword(){
       String contraseña= new String (text_password.getPassword());
       return contraseña;
   }
   public void setUsuario(String user){
       this.text_usuario.setText(user);
   }
   public void setPassword(String password){
       this.text_password.setText(password);
   }
   public void setController(ActionListener controller) {
        iniciar.addActionListener(controller);
    }
    private void addEventsIndependientes(){
        SALIR.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                System.exit(0);
            }
            @Override
            public void mouseEntered(MouseEvent evt){
                SALIR.setForeground(Color.RED);
            }
            @Override
            public void mouseExited(MouseEvent evt){
                SALIR.setForeground(Color.white);
            }
        });
        text_usuario.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                //text_usuario.setFocusable(false);
                text_password.setFocusable(true);
            }
        });
        this.addMouseMotionListener(new MouseMotionListener(){
            @Override
            public void mouseDragged(MouseEvent evt){
                int Xant=evt.getXOnScreen();
                int Yant= evt.getYOnScreen();
                frame.setLocation(Xant-X, Yant-Y);
            }
             @Override
            public void mouseMoved(MouseEvent e) {
                X= e.getX();
                Y= e.getY();
            }
        });
        registrarse.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                frame.changePanel("REGISTRY");
            }
        });
        informacion.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                Dialogo info= new Dialogo(frame,"/Recursos/ciudad.jpg");
                        info.setFondo("/Recursos/ciudad.jpg");
                        info.setTitulo("Acerca del Proyecto");
                        info.setMensaje(Constants.CREDITOS);
                        info.run();
            }
        });
        
    } 
    /**
     * Limpia los datos del Login correspondiente al usuario y constraseña
     */
    public void limpiar_datos(){
        text_usuario.setText("");
        text_password.setText("");
    }
}
