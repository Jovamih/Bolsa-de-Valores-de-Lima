
package Vista;
import Controlador.ControladorPrincipal;
import Modelo.BolsaDeValores;
import Modelo.Components.Constants;
import Vista.Components.DialogoInicio;
import Vista.Components.Dialogo;
import Vista.Components.JPanelPRO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
public class SoftwareVista extends JFrame  implements InterfazVista, ActionListener{
    Container contenido= this.getContentPane();
    private JPanelPRO fondo;
    private JPanel panelInferior, panelCentral, 
                   panelUsuario,panelOperaciones,
                   cardPanel, panelCompraVenta;
    private JPanelPRO  panelEstadisticas;
    private JPanelPRO panelInformacion;
    private JLabel infoUtilidad, infoOperaciones,
                    fotoUsuario, nombreUsuario,infoAcciones,
                    infoRUT, infoCapital, infoSAB, cerrar;
    private JTable tablaMyAcciones, tablaEmpresas;
    private JComboBox comboOperaciones, comboEmpresas;
    private JTextField textAcciones, textValor;
    private JButton botonInvertir, cerrar_sesion;
    private DefaultTableModel myAction, myInformacion;
    private CardLayout card= new CardLayout();
    private int X,Y;
    private DialogoInicio primerInicio;
    private Dialogo poliza;
    private ArrayList<String> empCompra= new ArrayList<>();
    private ArrayList<String> empVenta= new ArrayList<>();
    public SoftwareVista() throws Exception{
        settings();
        initComponents();
        addActionComponents();
    }
    private void  initComponents(){
        contenido.setLayout(new BorderLayout());
        //creamos los nuevos componentes
        fondo = new JPanelPRO("/Recursos/valores.jpg");
        
        //conjunto de JLabels o etiquetas de contenido
        Color blanco= new Color(255,255,255);
        JLabel labelUtilidad= new JLabel("Inversion");
        JLabel labelOperaciones= new JLabel("Total Operaciones");
        JLabel labelRUT= new JLabel("RUT :");
        JLabel labelSAB= new JLabel("SAB :");
        JLabel labelAbout= new JLabel("About Me");
        JLabel labelCapital = new JLabel("Capital :");
        JLabel labelTitulo = new JLabel("Bolsa de Valores de Lima");
        JLabel labelTypeOp= new JLabel("Operacion a realizar");
        JLabel labelEmpresa= new JLabel("");
        JLabel labelInvierte = new JLabel("Invierte ahora!");
        JLabel labelCantAcciones = new JLabel("Acciones");
        JLabel labelCantValor = new JLabel("Valor de Accion");
        JLabel nuevasFunciones = new JLabel("Nuevas funciones para tí");
        JLabel mensajeFunciones = new JLabel("Explora y simula al maximo, tus habilidades, que esperas!");
        JSeparator separatorV= new JSeparator();
        //variables usasdas en toda la clase SoftwareVista y declaradas como private
        primerInicio= new DialogoInicio(this);
        poliza= new Dialogo(this,"/Recursos/dialogo2.jpg");
        panelInferior = new JPanel();
        infoUtilidad = new JLabel();
        infoOperaciones = new JLabel();
        panelCentral = new JPanel();
        panelUsuario = new JPanel();
        fotoUsuario = new JLabel();
        nombreUsuario = new JLabel("UNKNOW");
        infoAcciones = new JLabel();
        infoRUT = new JLabel();
        infoSAB = new JLabel("NON_SAB"); //jLabel19
        infoCapital = new JLabel("NON_CAPITAL");
        cerrar_sesion = new JButton();
        JScrollPane scrollMyAccion = new JScrollPane();
        JScrollPane scrollEmpresas= new JScrollPane();
        tablaMyAcciones = new JTable();
        panelOperaciones = new JPanel();
        cerrar = new JLabel("X");
        tablaEmpresas = new JTable();
       
        comboOperaciones = new JComboBox<>();
        comboEmpresas = new JComboBox<>();
        cardPanel = new JPanel();
        panelCompraVenta = new JPanel();
        
        poliza.setFondo("/Recursos/dialogo2.jpg");
        poliza.setTitulo("OPERACION EXITOSA!!");
 
        textAcciones = new JTextField();
        textValor = new JTextField();
        botonInvertir = new JButton();
        panelEstadisticas = new JPanelPRO("/Recursos/estadistica.png");
        panelInformacion = new JPanelPRO("/Recursos/informacion.jpg");

        fondo.setBackground(blanco);
        fondo.setPreferredSize(new Dimension(1000, 575));
        fondo.setLayout(new BorderLayout());

        panelInferior.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, blanco));
      //  panelInferior.setForeground(new java.awt.Color(102, 0, 102));
        panelInferior.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        panelInferior.setOpaque(false);
        panelInferior.setPreferredSize(new Dimension(950, 80));
        panelInferior.setLayout(null);

        labelUtilidad.setFont(new Font("Segoe UI Semibold", 1, 24)); 
        labelUtilidad.setForeground(blanco);
        labelUtilidad.setHorizontalAlignment(SwingConstants.LEFT);
        panelInferior.add(labelUtilidad);
        labelUtilidad.setBounds(40, 0, 170, 32);

        infoUtilidad.setFont(new Font("Segoe UI Light", 1, 24)); 
        infoUtilidad.setForeground(blanco);
        infoUtilidad.setHorizontalAlignment(SwingConstants.CENTER);
        infoUtilidad.setText("0.00000");
        panelInferior.add(infoUtilidad);
        infoUtilidad.setBounds(150, 10, 310, 60);

        labelOperaciones.setFont(new Font("Segoe UI Light", 1, 24)); 
        labelOperaciones.setForeground(blanco);
        labelOperaciones.setHorizontalAlignment(SwingConstants.CENTER);
        labelOperaciones.setText("Total Operaciones");
        panelInferior.add(labelOperaciones);
        labelOperaciones.setBounds(550, 10, 230, 32);

        infoOperaciones.setFont(new Font("Segoe UI Light", 1, 24));
        infoOperaciones.setForeground(blanco);
        infoOperaciones.setHorizontalAlignment(SwingConstants.CENTER);
        infoOperaciones.setText("10000");
        panelInferior.add(infoOperaciones);
        infoOperaciones.setBounds(750, 10, 180, 60);

        fondo.add(panelInferior, BorderLayout.SOUTH);

        panelCentral.setOpaque(false);
        panelCentral.setLayout(new BorderLayout());


        panelUsuario.setForeground(new Color(102, 0, 102));
        panelUsuario.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        panelUsuario.setOpaque(false);
        panelUsuario.setPreferredSize(new Dimension(240, 470));
        panelUsuario.setLayout(null);
        panelUsuario.add(fotoUsuario);
        fotoUsuario.setBounds(80, 20, 90, 80);

        nombreUsuario.setFont(new Font("Segoe UI Semibold", 1, 18)); 
        nombreUsuario.setForeground(blanco);
        nombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        nombreUsuario.setText("Usuario");
        panelUsuario.add(nombreUsuario);
        nombreUsuario.setBounds(20, 115, 190, 25);

        labelRUT.setFont(new Font("Segoe UI Semibold", 1, 18)); // NOI18N
        labelRUT.setForeground(blanco);
        labelRUT.setText("RUT :");
        panelUsuario.add(labelRUT);
        labelRUT.setBounds(40, 150, 60, 20);

        labelSAB.setFont(new Font("Segoe UI Semibold", 1, 18)); // NOI18N
        labelSAB.setForeground(blanco);
        panelUsuario.add(labelSAB);
        labelSAB.setBounds(30, 210, 70, 20);

        infoAcciones.setFont(new Font("Segoe UI Light", 1, 15)); // NOI18N
        infoAcciones.setForeground(blanco);
        infoAcciones.setText("Mis acciones ");
        panelUsuario.add(infoAcciones);
        infoAcciones.setBounds(30, 260, 100, 20);

        labelAbout.setFont(new Font("Segoe UI Light", 1, 15)); // NOI18N
        labelAbout.setForeground(blanco);
        labelAbout.setText("About Me");
        panelUsuario.add(labelAbout);
        labelAbout.setBounds(80, 440, 90, 20);
        

        cerrar_sesion.setBackground(Color.white);
        cerrar_sesion.setOpaque(false);
        cerrar_sesion.setActionCommand("CERRAR_SESION");
        ImageIcon imagen=new ImageIcon(getClass().getResource("/Recursos/cerrar_sesion.jpg"));
        imagen = new ImageIcon(imagen.getImage().getScaledInstance(33,30,Image.SCALE_SMOOTH));
        cerrar_sesion.setIcon(imagen);
        panelOperaciones.add(cerrar_sesion);
        cerrar_sesion.setBounds(690, 0, 33, 30);

        infoRUT.setFont(new Font("Segoe UI Light", 1, 14)); // NOI18N
        infoRUT.setForeground(blanco);
        infoRUT.setText("00x00000");
        panelUsuario.add(infoRUT);
        infoRUT.setBounds(120, 150, 110, 20);

        infoCapital.setFont(new Font("Segoe UI Light", 1, 14)); // NOI18N
        infoCapital.setForeground(blanco);
        panelUsuario.add(infoCapital);
        infoCapital.setBounds(120, 210, 110, 20);
        
       labelCapital.setFont(new Font("Segoe UI Semibold", 1, 18)); // NOI18N
       labelCapital.setForeground(Color.white);
        panelUsuario.add(labelCapital);
        labelCapital.setBounds(30, 210, 70, 20);


        scrollMyAccion.setForeground(blanco);
        scrollMyAccion.setOpaque(false);
        
        Object[][] filas={};
        String [] columns={"Empresa","Acciones"};
        myAction = new DefaultTableModel(filas,columns);
        tablaMyAcciones.setFont(new Font("Segoe UI Light", 1, 18)); // NOI18N
        tablaMyAcciones.setModel(myAction);
       // tablaMyAcciones.setOpaque(false);
        tablaMyAcciones.setSelectionBackground(new Color(255, 204, 255));
        scrollMyAccion.setViewportView(tablaMyAcciones);

        panelUsuario.add(scrollMyAccion);
        scrollMyAccion.setBounds(30, 300, 180, 130);

        labelSAB.setFont(new Font("Segoe UI Semibold", 1, 18)); 
        labelSAB.setForeground(blanco);
        labelSAB.setText("SAB :");
        panelUsuario.add(labelSAB);
        labelSAB.setBounds(40, 180, 60, 20);

        infoSAB.setFont(new Font("Segoe UI Light", 1, 14)); 
        infoSAB.setForeground(blanco);
        infoSAB.setText("FFXFF00");
        panelUsuario.add(infoSAB);
        infoSAB.setBounds(110, 180, 110, 20);

        panelCentral.add(panelUsuario, BorderLayout.LINE_START);

        panelOperaciones.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        panelOperaciones.setOpaque(false);
        panelOperaciones.setLayout(null);

        cerrar.setFont(new Font("Segoe UI Semibold", 1, 24)); // NOI18N
        cerrar.setForeground(blanco);
        cerrar.setHorizontalAlignment(SwingConstants.CENTER);
        cerrar.setText("X");
        cerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cerrar.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent evt){
                System.exit(0);
            }
        });
        panelOperaciones.add(cerrar);
        cerrar.setBounds(730, 0, 40, 30);

        labelTitulo.setFont(new Font("Segoe UI Light", 1, 36)); 
        labelTitulo.setForeground(blanco);
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panelOperaciones.add(labelTitulo);
        labelTitulo.setBounds(90, 10, 580, 40);
         
        
        scrollEmpresas.setFont(new Font("Segoe UI Light", 1, 14));
        scrollEmpresas.setOpaque(false);
         
        Object[][] filas2={};
        String [] columns2={"Empresas", "Nemonico", "Sector", "Compra", "Venta", "Variación", "Acciones"};
        myInformacion= new DefaultTableModel(filas2,columns2);
        tablaEmpresas.setFont(new Font("Segoe UI Light", 1, 13)); // NOI18N
        tablaEmpresas.setForeground(Color.BLACK);
        tablaEmpresas.setModel(myInformacion);
        //tablaEmpresas.setOpaque(false);
        tablaEmpresas.setSelectionBackground(new Color(255, 204, 255));
        scrollEmpresas.setViewportView(tablaEmpresas);

        panelOperaciones.add(scrollEmpresas);
        scrollEmpresas.setBounds(60, 80, 650, 120);

        labelTypeOp.setFont(new Font("Segoe UI Semibold", 1, 18));
        labelTypeOp.setForeground(blanco);
        panelOperaciones.add(labelTypeOp);
        labelTypeOp.setBounds(70, 300, 170, 20);

        comboOperaciones.setFont(new Font("Segoe UI Light", 0, 14)); 
        comboOperaciones.setForeground(Color.black);
        String [] opciones={"Informacion", "Comprar Acciones", "Vender Acciones", "Mostrar Estadisticas"};
        DefaultComboBoxModel<String> myOpciones;
        myOpciones = new DefaultComboBoxModel<>(opciones);
        comboOperaciones.setModel(myOpciones);
       // comboOperaciones.setOpaque(false);
        panelOperaciones.add(comboOperaciones);
        comboOperaciones.setBounds(80, 350, 160, 26);

        cardPanel.setBackground(new Color(204, 204, 204));
        cardPanel.setOpaque(false);
        cardPanel.setLayout(card);

        panelCompraVenta.setBorder(BorderFactory.createTitledBorder(null, "Operación", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Segoe UI Light", 0, 14),blanco));
        panelCompraVenta.setOpaque(false);
        panelCompraVenta.setLayout(null);

        labelEmpresa.setFont(new Font("Segoe UI Semibold", 1, 18)); // NOI18N
        labelEmpresa.setForeground(blanco);
        labelEmpresa.setText("Empresa");
        panelCompraVenta.add(labelEmpresa);
        labelEmpresa.setBounds(50, 20, 90, 25);

        comboEmpresas.setFont(new Font("Segoe UI Light", 0, 14)); 
        comboEmpresas.setForeground(Color.BLACK);
        comboEmpresas.setOpaque(false);
        panelCompraVenta.add(comboEmpresas);
        comboEmpresas.setBounds(20, 50, 120, 30);

        labelCantAcciones.setFont(new Font("Segoe UI Semibold", 1, 18));
        labelCantAcciones.setForeground(blanco);
        panelCompraVenta.add(labelCantAcciones);
        labelCantAcciones.setBounds(270, 20, 80, 25);

        textAcciones.setFont(new java.awt.Font("Segoe UI Light", 1, 18));
        textAcciones.setForeground(blanco);
        textAcciones.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,blanco));
        textAcciones.setOpaque(false);
        panelCompraVenta.add(textAcciones);
        textAcciones.setBounds(250, 50, 110, 30);

        labelCantValor.setFont(new Font("Segoe UI Semibold", 1, 18));
        labelCantValor.setForeground(blanco);
        panelCompraVenta.add(labelCantValor);
        labelCantValor.setBounds(20, 110, 130, 25);

        textValor.setFont(new Font("Segoe UI Light", 1, 18)); // NOI18N
        textValor.setForeground(blanco);
        textValor.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,blanco));
        textValor.setOpaque(false);
        panelCompraVenta.add(textValor);
        textValor.setBounds(20, 140, 130, 30);

        botonInvertir.setBackground(blanco);
        botonInvertir.setFont(new Font("Segoe UI Light", 0, 18)); // NOI18N
        botonInvertir.setForeground(blanco);
        botonInvertir.setText("Invertir");
       // botonInvertir.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,blanco));
        botonInvertir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonInvertir.setOpaque(false);
        botonInvertir.setActionCommand("INVERTIR");

        panelCompraVenta.add(botonInvertir);
        botonInvertir.setBounds(220, 110, 160, 60);
        

        cardPanel.add(panelCompraVenta, "COMPRA_VENTA");

        panelEstadisticas.setOpaque(false);
        panelEstadisticas.setLayout(null);
        cardPanel.add(panelEstadisticas, "ESTADISTICAS");

        panelInformacion.setOpaque(false);
        panelInformacion.setLayout(null);

        mensajeFunciones.setFont(new Font("Segoe UI Light", 1, 14)); 
        mensajeFunciones.setForeground(Color.white);
        panelInformacion.add(mensajeFunciones);
        mensajeFunciones.setBounds(40, 50, 360, 20);

        nuevasFunciones.setFont(new Font("Segoe UI Light", 1, 18)); // NOI18N
        nuevasFunciones.setText("Nuevas funciones para ti");
        nuevasFunciones.setForeground(Color.white);
        panelInformacion.add(nuevasFunciones);
        nuevasFunciones.setBounds(140, 130, 200, 20);

        cardPanel.add(panelInformacion, "INFORMACION");

        panelOperaciones.add(cardPanel);
        cardPanel.setBounds(280, 250, 420, 200);

        labelInvierte.setFont(new Font("Segoe UI Semibold", 1, 18)); // NOI18N
        labelInvierte.setForeground(blanco);
        panelOperaciones.add(labelInvierte);
        labelInvierte.setBounds(340, 220, 120, 25);

        separatorV.setOrientation(SwingConstants.VERTICAL);
        panelOperaciones.add(separatorV);
        separatorV.setBounds(0, 40, 10, 450);
        card.show(cardPanel,"INFORMACION");
        panelCentral.add(panelOperaciones, BorderLayout.CENTER);

        fondo.add(panelCentral, BorderLayout.CENTER);

        contenido.add(fondo,BorderLayout.CENTER);

    }
    private void settings() throws Exception{
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000,575);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setIconImage(new ImageIcon(getClass().getResource("/Recursos/icono.jpg")).getImage());
    }
    private void addActionComponents(){
        //comboEmpresas.addActionListener(this);
        comboOperaciones.addActionListener(this);
        //eventos de la ventana
        this.addMouseMotionListener(new MouseMotionListener(){
            @Override
            public void mouseDragged(MouseEvent evt){
                int Xant=evt.getXOnScreen();
                int Yant= evt.getYOnScreen();
                setLocation(Xant-X, Yant-Y);
            }
             @Override
            public void mouseMoved(MouseEvent e) {
                X= e.getX();
                Y= e.getY();
            }
        });
    }
    
    public void setFoto(ImageIcon foto){
        if(foto!=null){
        foto= new ImageIcon(foto.getImage().getScaledInstance(fotoUsuario.getWidth(),fotoUsuario.getHeight(),Image.SCALE_SMOOTH));
        fotoUsuario.setIcon(foto);
        }
    }
    public void setNombre(String nombre){
        nombreUsuario.setText(nombre);
    }
    public void setRUT(String rut){
        infoRUT.setText(rut);
    }
    public void setSAB(String sab){
        infoSAB.setText(sab);
    }
    public void setCapital(double capital){
        infoCapital.setText(String.valueOf(capital));
    }
    public void añadirMisAcciones(String empresa, double acciones){
        myAction.addRow(new Object[]{empresa,acciones});
    }
    public void añadirInformacionBolsa(String empresa, String nemonico,String sector, double compra, double venta, double variacion, double acciones){
        myInformacion.addRow(new Object[]{empresa,nemonico,sector,compra,venta,variacion, acciones});
    }
    public void setUtilidad(double utilidad){
        infoUtilidad.setText(String.valueOf(utilidad));
    }
    public void setTotalOperaciones(int operaciones){
        infoOperaciones.setText(String.valueOf(operaciones));
    }
    public String getOperacionSeleccionada(){
        String operacion="";
        switch( (String)comboOperaciones.getSelectedItem()){
            case "Comprar Acciones":
                operacion=Constants.COMPRA; break;
            case "Vender Acciones":
                operacion=Constants.VENTA;
                break;
            default: break;
        }
        return operacion;
    }
    public String getEmpresaSeleccionada(){
        return (String)comboEmpresas.getSelectedItem();
    }
   public void añadirComboVenta(String empresa){
       empVenta.add(empresa);
   }
   public void añadirComboCompra(String empresa){
       empCompra.add(empresa);
   }
    public int getValores(){
        int acciones=0;
        try{
            acciones= Integer.parseInt(textAcciones.getText());
        }catch(Exception e){
            acciones=0;
        }
        return acciones;
    }
    public double getValorAcciones(){
        double valor=0.0;
        try{
            valor= Double.parseDouble(textValor.getText());
        }catch(Exception e){
            valor=0;
        }
        return valor;
    }
    public double getCInicial(){
        return primerInicio.getCapital();
    }
    public String getSAB(){
        return primerInicio.getSAB();
    }
    public void limpiarDatos(){
        textValor.setText("");
        textAcciones.setText("");
    }
    public void limpiarDatosDialogo(){
        primerInicio.limpiar();
    }
    public DialogoInicio getDialogoInicio(){
        return primerInicio;
    }
    public Dialogo getDialogoPoliza(){
        return poliza;
    }
    public void borrarInformacionAcciones(){
        myAction.setRowCount(0);
    }
    public void borrarComboVentas(){
        comboEmpresas.removeAllItems();
        empVenta.clear();
    }
    public void reiniciar(){
        empVenta.clear();
        empCompra.clear();
        infoUtilidad.setText(""); 
        infoOperaciones.setText("");
        fotoUsuario.setIcon(null); 
        nombreUsuario.setText("UNKNOW");
        infoAcciones.setText("0000");
        infoRUT.setText("0x000"); 
        infoCapital.setText("00000.0"); 
        infoSAB.setText("SAB000\"); \n" +
"        infoCapital.setText(\"00000.0\");.000");
        textAcciones.setText("");
        textValor.setText("");
        myInformacion.setRowCount(0);
        myAction.setRowCount(0);
        comboEmpresas.removeAllItems();
        limpiarDatos();
    }
    @Override
    public void setController(ControladorPrincipal controller) {
       botonInvertir.addActionListener(controller);
       cerrar_sesion.addActionListener(controller);
       primerInicio.setController(controller);
    }

    @Override
    public void run() {
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent evt){
        Object element= (Object)evt.getSource();
       if(element==comboOperaciones){
           int index=  comboOperaciones.getSelectedIndex();
           switch(index){
               case 0:
                   card.show(cardPanel,"INFORMACION");
                   break;
               case 1: 
                   card.show(cardPanel,"COMPRA_VENTA");
                   comboEmpresas.removeAllItems();
                   for(String emp: empCompra)comboEmpresas.addItem(emp);
                   botonInvertir.setText("Comprar");
                   break;

               case 2:
                   card.show(cardPanel,"COMPRA_VENTA");
                   comboEmpresas.removeAllItems();
                   for(String emp: empVenta) comboEmpresas.addItem(emp);
                   botonInvertir.setText("Vender");
                   break;
                   
               case 3:
                   card.show(cardPanel,"ESTADISTICAS");
                   break;
               default: 
                   break;
           }
       }
    }
    public void enviarMensaje(String contenido, String titulo, int type){
        JOptionPane.showMessageDialog(this,contenido,titulo,type);
    }
    
}
