
package Vista;
import Modelo.BOT;
import Modelo.DataAccessObject.DataBase;
import Modelo.DataAccessObject.FactoryDataBase;
import Modelo.Empresa;
import Modelo.SAB;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Administrador extends JFrame implements ActionListener{
    Container content=this.getContentPane();
    JButton registrarSAB, registrarEmpresa;
    JTextField textoNombreEmpresa, textoSector,textoNemonico, textoAcciones, textoCompra, textoVenta;
    JTextField textoNombreSAB, textoComision, textoID;
    DataBase baseDatos;
    public Administrador(){
         baseDatos = FactoryDataBase.getBaseDeDatos(DataBase.OFFLINE);
        settings();
        initComponents();
    }
    private void settings(){
       this.setSize(800,480);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.setResizable(false);
    }
    private void initComponents(){
        content.setLayout(new BorderLayout());
        JPanel jPanel1 = new JPanel();
        JPanel panelSAB = new JPanel();
        JLabel nombreSAB = new JLabel();
        JLabel comision = new JLabel();
        JLabel idSAB = new JLabel();
        textoNombreSAB = new JTextField();
        textoComision = new JTextField();
        textoID = new JTextField();
        registrarSAB = new JButton();
        JLabel jLabel10 = new JLabel();
        JPanel panelEmpresa = new JPanel();
        JLabel nombreEmpresa = new JLabel();
        JLabel nemonico = new JLabel();
        JLabel sector = new JLabel();
        JLabel acciones = new JLabel();
        JLabel labelCompra = new JLabel();
        JLabel labelVenta = new JLabel();
        textoNombreEmpresa = new JTextField();
        textoNemonico = new JTextField();
        textoSector = new JTextField();
        textoAcciones = new JTextField();
        textoCompra = new JTextField();
        textoVenta = new JTextField();
        registrarEmpresa = new JButton();
        JLabel jLabel11 = new JLabel();
        JLabel titulo = new JLabel();

        jPanel1.setLayout(null);

        panelSAB.setLayout(null);

        nombreSAB.setText("Nombre:");
        panelSAB.add(nombreSAB);
        nombreSAB.setBounds(60, 70, 50, 14);

        comision.setText("Comision");
        panelSAB.add(comision);
        comision.setBounds(60, 120, 60, 20);

        idSAB.setText("ID");
        panelSAB.add(idSAB);
        idSAB.setBounds(70, 180, 40, 20);
        panelSAB.add(textoNombreSAB);
        textoNombreSAB.setBounds(160, 70, 120, 30);
        panelSAB.add(textoComision);
        textoComision.setBounds(160, 120, 120, 30);
        panelSAB.add(textoID);
        textoID.setBounds(160, 180, 90, 30);

        registrarSAB.setText("Registrar SAB");
        panelSAB.add(registrarSAB);
        registrarSAB.setBounds(110, 360, 120, 40);

        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 1, 18));
        jLabel10.setText("SAB");
        panelSAB.add(jLabel10);
        jLabel10.setBounds(150, 20, 33, 25);

        jPanel1.add(panelSAB);
        panelSAB.setBounds(0, 50, 350, 430);

        panelEmpresa.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, new Color(0, 0, 0)));
        panelEmpresa.setLayout(null);

        nombreEmpresa.setText("Nombre");
        panelEmpresa.add(nombreEmpresa);
        nombreEmpresa.setBounds(70, 60, 50, 14);

        nemonico.setText("Nemonico:");
        panelEmpresa.add(nemonico);
        nemonico.setBounds(70, 110, 52, 14);

        sector.setText("Sector:");
        panelEmpresa.add(sector);
        sector.setBounds(70, 160, 35, 14);

        acciones.setText("Acciones:");
        panelEmpresa.add(acciones);
        acciones.setBounds(70, 210, 47, 14);

        labelCompra.setText("Valor de Compra:");
        panelEmpresa.add(labelCompra);
        labelCompra.setBounds(50, 260, 86, 14);

        labelVenta.setText("Valor de Venta:");
        panelEmpresa.add(labelVenta);
        labelVenta.setBounds(210, 260, 77, 14);
        panelEmpresa.add(textoNombreEmpresa);
        textoNombreEmpresa.setBounds(160, 60, 140, 30);
        panelEmpresa.add(textoNemonico);
        textoNemonico.setBounds(160, 110, 140, 30);
        panelEmpresa.add(textoSector);
        textoSector.setBounds(160, 160, 140, 30);
        panelEmpresa.add(textoAcciones);
        textoAcciones.setBounds(160, 210, 100, 30);
        panelEmpresa.add(textoCompra);
        textoCompra.setBounds(70, 290, 70, 30);
        panelEmpresa.add(textoVenta);
        textoVenta.setBounds(210, 290, 80, 30);

        registrarEmpresa.setText("Registrar Empresa");
        panelEmpresa.add(registrarEmpresa);
        registrarEmpresa.setBounds(120, 360, 150, 40);

        jLabel11.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); 
        jLabel11.setText("EMPRESA");
        panelEmpresa.add(jLabel11);
        jLabel11.setBounds(130, 20, 80, 25);

        jPanel1.add(panelEmpresa);
        panelEmpresa.setBounds(350, 50, 350, 430);

        titulo.setFont(new Font("Segoe UI Light", 1, 24)); 
        titulo.setText("MODO ADMINISTRADOR");
        jPanel1.add(titulo);
        titulo.setBounds(200, 10, 273, 32);
       registrarSAB.addActionListener(this);
       registrarEmpresa.addActionListener(this);
       content.add(jPanel1,BorderLayout.CENTER);
    }
    @Override
    public void actionPerformed(ActionEvent evt){
        Object boton= (Object)evt.getSource();
        if(boton== registrarEmpresa){
            registrarEmpresa();
        }else if(boton== registrarSAB){
            
            registrarSAB();
        }
    }
    private void registrarSAB(){
        String nombre= textoNombreSAB.getText();
        String comision= textoComision.getText();
        String ID= textoID.getText();
        try{
            double comisionSAB= Double.parseDouble(comision);
            SAB sab= new SAB(nombre, comisionSAB, ID);
            baseDatos.registrarSAB(sab);
            JOptionPane.showMessageDialog(this,"Registro de SAB exitoso");
            limpiarSAB();
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this,"Verifique que sus datos numericos sean correctos","ERROR DE REGISTRO",JOptionPane.WARNING_MESSAGE);
            //e.printStackTrace();
        }
    }
    private void limpiarEmpresa(){
        textoNombreEmpresa.setText("");
        textoNemonico.setText("");
        textoSector.setText("");
        textoAcciones.setText("");
        textoCompra.setText("");
        textoVenta.setText("");
    }
    private void limpiarSAB(){
        textoNombreSAB.setText("");
        textoComision.setText("");
        textoID.setText("");
    }
    private void registrarEmpresa(){
        String nombre= textoNombreEmpresa.getText();
        String nemonico= textoNemonico.getText();
        String sector= textoSector.getText();
        String acciones= textoAcciones.getText();
        String compra= textoCompra.getText();
        String venta= textoVenta.getText();
        try{
            int accion= Integer.parseInt(acciones);
            double Vcompra= Double.parseDouble(compra);
            double Vventa= Double.parseDouble(venta);
            Empresa emp= new Empresa(nombre,accion,Vcompra,Vventa);
                    emp.setNemonico(nemonico);
                    emp.setSector(sector);
                    emp.setVariacion(BOT.genValorAccion(1,3.4));
            baseDatos.registrarEmpresa(emp);
            JOptionPane.showMessageDialog(this,"Registro de empresa exitoso");
            limpiarEmpresa();
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this,"Ingrese datos validos en la secciones numericas","ERROR DE REGISTRO",JOptionPane.ERROR_MESSAGE);
     //   e.printStackTrace();
        }
    }
    public void run(){
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
}
