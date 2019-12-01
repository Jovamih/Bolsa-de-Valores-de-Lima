
package Vista.Components;
import javax.swing.*;
import java.awt.*;
import Controlador.ControladorPrincipal;
import Vista.Components.JPanelPRO;
import Vista.SesionVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Registro extends JPanelPRO implements MouseMotionListener{
    //private JButton panel= new JButton("here!!");
    private SesionVista frame;
    private JLabel label_registro, label_nombre,label_apellido,label_dni,
                    label_nacion, label_pais,
                    label_correo, label_contraseña, label_confirmar,
                    salir, label_icono,
                    label_indicacion,label_retroceder;
    private JTextField text_nombre, text_apellido, text_dni, text_correo;
    private JPasswordField text_contraseña,
                           text_contraseña2;
    private JButton boton_registrar,botonFoto;
    private JComboBox combo_pais, combo_nacion;
    private ImageIcon image;
    private int X,Y;
    public Registro(String url){
        super(url);
        //this.add(panel);
        initComponents();
        addEventsIndependientes();
    }
    private void initComponents(){
        label_registro = new JLabel("Registrarse en la Bolsa de Valores");
        label_nombre = new JLabel("Nombres");
        label_apellido = new JLabel("Apellidos");
        label_dni = new JLabel("DNI");
        combo_nacion = new JComboBox<>();
        label_nacion = new JLabel("Nacionalidad");
        label_pais = new JLabel("País");
        combo_pais = new JComboBox<>();
        text_nombre = new JTextField();
        text_apellido = new JTextField();
        text_dni = new JTextField();
        label_correo = new JLabel("Correo");
        text_correo = new JTextField();
        label_contraseña = new JLabel("Contraseña");
        label_confirmar = new JLabel("Confirmar Contraseña");
        text_contraseña = new JPasswordField();
        text_contraseña2 = new JPasswordField();
        salir = new JLabel("X");
        boton_registrar = new JButton("Registrar");
        label_icono = new JLabel();
        label_retroceder = new JLabel();
        label_indicacion = new JLabel(" Por favor rellene los datos ");
        Color blanco= new Color(255,255,255);
        Color negro= new Color(0,0,0);
        Color purpura= new Color(204,0,204);
        JSeparator vertical = new JSeparator();
        //jPanel1 = new javax.swing.JPanel();
           this.setLayout(null);

        label_registro.setFont(new Font("Segoe UI Light", 1, 24));
        label_registro.setForeground(negro);
        label_registro.setBounds(100, 10, 390, 30);
            this.add(label_registro);
         
            label_icono.setHorizontalAlignment(SwingConstants.CENTER);
            this.add(label_icono);
        label_icono.setBounds(550, 30, 110, 90);
        
        botonFoto = new JButton();
        botonFoto.setBackground(blanco);
        botonFoto.setFont(new Font("Segoe UI Light", 1, 16));
        botonFoto.setForeground(blanco);
        botonFoto.setOpaque(false);
        botonFoto.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonFoto.setText("Elejir Foto");
            this.add(botonFoto);
        botonFoto.setBounds(550, 130, 110, 30);
        label_nombre.setFont(new Font("Segoe UI Light", 1, 16));
        label_nombre.setForeground(blanco);
        label_nombre.setBounds(80, 110, 110, 30);
            this.add(label_nombre);
        label_apellido.setFont(new Font("Segoe UI Light", 1, 16));
        label_apellido.setBounds(80, 190, 90, 30);
        label_apellido.setForeground(blanco);
            this.add(label_apellido);
        label_dni.setFont(new Font("Segoe UI Light", 1, 16));
        label_dni.setForeground(blanco);
        label_dni.setBounds(70, 280, 50, 30);
            this.add(label_dni);
        combo_nacion.setFont(new Font("Segoe UI Light", 0, 18)); 
        combo_nacion.setModel(new DefaultComboBoxModel<>(new String[] { "Perú", "Chile", "Colombia", "Ecuador", "Argentina", "Venezuela" }));
        combo_nacion.setBounds(180, 340, 150, 30);
            this.add(combo_nacion);
        label_nacion.setFont(new Font("Segoe UI Light", 1, 16));
        label_nacion.setForeground(blanco);
        label_nacion.setBounds(40, 340, 120, 30);
            this.add(label_nacion);
        label_pais.setFont(new Font("Segoe UI Light", 1, 16));
        label_pais.setForeground(blanco);
        label_pais.setBounds(60, 390, 50, 40);
            this.add(label_pais);
        combo_pais.setFont(new Font("Segoe UI Light", 0, 18)); 
        combo_pais.setModel(new DefaultComboBoxModel<>(new String[] { "Perú", "Argentina", "Chile", "Colombia", "Bolivia", "Venelzuela" }));
        combo_pais.setBounds(180, 400, 150, 30);
            this.add(combo_pais);
        

        text_nombre.setFont(new Font("Segoe UI Light", 1, 20)); 
        text_nombre.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,blanco));
        text_nombre.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        text_nombre.setOpaque(false);
        text_nombre.setForeground(blanco);
        text_nombre.setBounds(60, 150, 270, 30);
            this.add(text_nombre);
        

        text_apellido.setFont(new Font("Segoe UI Light", 1, 20)); // NOI18N
        text_apellido.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,blanco));
        text_apellido.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        text_apellido.setOpaque(false);
        text_apellido.setForeground(blanco);
        text_apellido.setBounds(60, 230, 270, 28);
            this.add(text_apellido);
        
        text_dni.setFont(new Font("Segoe UI Light", 1, 20)); 
        text_dni.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,blanco));
        text_dni.setForeground(blanco);
        text_dni.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        text_dni.setBounds(150, 280, 180, 28);
        text_dni.setOpaque(false);
           this.add(text_dni);
        
        label_correo.setFont(new Font("Segoe UI Light", 1, 16));
        label_correo.setForeground(blanco);
        label_correo.setBounds(500, 160, 70, 30);
           this.add(label_correo);
       
        text_correo.setFont(new Font("Segoe UI Light", 1, 20)); // NOI18N
        text_correo.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,blanco));
        text_correo.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        text_correo.setOpaque(false);
        text_correo.setForeground(blanco);
        text_correo.setBounds(490, 190, 230, 30);
           this.add(text_correo);
        
        label_contraseña.setFont(new Font("Segoe UI Light", 1, 16));
        label_contraseña.setForeground(blanco);
        label_contraseña.setBounds(500, 230, 100, 30);
          this.add(label_contraseña);
        
        label_confirmar.setFont(new Font("Segoe UI Light", 1, 16));
        label_confirmar.setForeground(blanco);
        label_confirmar.setBounds(490, 310, 190, 20);
          this.add(label_confirmar);
        
        text_contraseña.setFont(new Font("Segoe UI Light", 0, 20)); 
        text_contraseña.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, blanco));
        text_contraseña.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        text_contraseña.setForeground(blanco);
        text_contraseña.setOpaque(false);
        text_contraseña.setBounds(490, 260, 230, 30);
          this.add(text_contraseña);
        

        text_contraseña2.setFont(new Font("Segoe UI Light", 0, 20)); // NOI18N
        text_contraseña2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, blanco));
        text_contraseña2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        text_contraseña2.setForeground(blanco);
        text_contraseña2.setOpaque(false);
        text_contraseña2.setBounds(490, 330, 230, 30);
          this.add(text_contraseña2);
        
        salir.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        salir.setHorizontalAlignment(SwingConstants.CENTER);
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        salir.setForeground(purpura);
        salir.setBounds(770, 0, 20, 20);
          this.add(salir);
        
        boton_registrar.setBackground(blanco);
        boton_registrar.setFont(new Font("Segoe UI Light", 1, 20)); 
        boton_registrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_registrar.setForeground(blanco);
        boton_registrar.setOpaque(false);
        boton_registrar.setActionCommand("REGISTRAR_USUARIO");
        boton_registrar.setBounds(530, 390, 180, 60);
          this.add(boton_registrar);
        

       label_retroceder.setIcon(new ImageIcon(getClass().getResource("/Recursos/derechapro.jpg"))); 
        label_retroceder.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label_retroceder.setBounds(0, 0, 60, 40);
          this.add(label_retroceder);
        

        label_indicacion.setFont(new Font("Segoe UI Light", 1, 20));
        label_indicacion.setForeground(negro);
        label_indicacion.setBounds(40, 60, 360, 30);
        this.add(label_indicacion);
        

        vertical.setOrientation(SwingConstants.VERTICAL);
        vertical.setBounds(410, 120, 10, 310);
        this.add(vertical);

    }
    public void setController(ControladorPrincipal controller) {
        boton_registrar.addActionListener(controller);
    }

    public void setControlFrame(SesionVista frame) {
        this.frame= frame;
    }
    private void addEventsIndependientes(){
        label_retroceder.addMouseListener(new MouseAdapter(){
            @Override
                    public void mouseClicked(MouseEvent e){
                        frame.changePanel("LOGIN");
                    }
        });
        salir.addMouseListener(new MouseAdapter(){
            @Override
                    public void mouseClicked(MouseEvent e){
                        System.exit(0);
                    }
        });
        botonFoto.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                seleccionarFoto();
            }
        });
        this.addMouseMotionListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int Xact= e.getXOnScreen();
        int Yact= e.getYOnScreen();
        frame.setLocation(Xact-X,Yact-Y);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        X= e.getX();
        Y=e.getY();
    }
    private void seleccionarFoto(){
        JFileChooser fs= new JFileChooser();
                    fs.setDialogTitle("Selecciona la foto para tu perfil");
        FileNameExtensionFilter fef= new FileNameExtensionFilter("Imagenes personalizadas","jpg","png","gif");
                   fs.setFileFilter(fef);
        if(fs.showOpenDialog(frame)==JFileChooser.APPROVE_OPTION){
            String ruta= fs.getSelectedFile().getAbsolutePath();
             image= new ImageIcon(ruta);
            label_icono.setIcon(new ImageIcon(image.getImage().getScaledInstance(label_icono.getWidth(),label_icono.getHeight(),Image.SCALE_SMOOTH)));
        }
    }
    public ImageIcon getFoto(){
        return image;
    }
    public String getNombre(){
        return text_nombre.getText();
    }
    public String getApellido(){
        return text_apellido.getText();
    }
    public String getDNI(){
        return text_dni.getText();
    }
    
    public String getNacionalidad(){
        return (String)combo_nacion.getSelectedItem();
    }
    public String getPais(){
        return (String)combo_pais.getSelectedItem();
    }
    public String getCorreo(){
        return text_correo.getText();
    }
    public  char[] getPassword1(){
        return text_contraseña.getPassword();
    }
    public char[] getPassword2(){
        return text_contraseña2.getPassword();
    }
    public void limpiar_datos(){
        text_nombre.setText("");
        text_apellido.setText("");
        text_dni.setText("");
        text_correo.setText("");
        text_contraseña.setText("");
        text_contraseña2.setText("");
    }
}
