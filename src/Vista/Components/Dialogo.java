package Vista.Components;
//import Vista.SoftwareVista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Dialogo extends JDialog implements ActionListener{
    private JFrame frame;
    private JLabel titulo;
    private JTextArea areaTexto;
    private JButton aceptar;
    private Container content= this.getContentPane();
    private JPanelPRO panel;
    private String url="";
    public Dialogo(JFrame frame, String url){
        super(frame);
        this.frame= frame;
        this.url=url;
        settings();
        initComponents();
    }
    private void settings(){
        this.setSize(360,430);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setModal(true);
    }
    private void initComponents(){
        content.setLayout(new BorderLayout());
        panel= new JPanelPRO(url);
        
        JScrollPane scroll= new JScrollPane();
        areaTexto= new  JTextArea(); 
        titulo = new JLabel("OPERACION EXITOSA!");
        aceptar= new JButton("Aceptar");
        panel.setLayout(null);

        areaTexto.setColumns(20);
        areaTexto.setFont(new Font("Segoe UI Light", 1, 14)); 
        areaTexto.setRows(5);
        areaTexto.setEditable(false);
        scroll.setViewportView(areaTexto);

        panel.add(scroll);
        scroll.setBounds(20, 50, 320, 320);

        titulo.setFont(new Font("Segoe UI Light", 1, 18));
        titulo.setForeground(Color.white);
        panel.add(titulo);
        titulo.setBounds(80, 20, 190, 30);

         aceptar.setFont(new Font("Segoe UI Light", 1, 14));
        panel.add( aceptar);
          aceptar.setBounds(130, 380, 110, 29);
         aceptar.addActionListener(this);
        content.add(panel, BorderLayout.CENTER);
    }
    public void setTitulo(String url){
        titulo.setText(url);
    }
    public void setMensaje(String texto){
        areaTexto.setText(texto);
    }
    public void setFondo(String url){
        this.url= url;
    }
    @Override
    public void actionPerformed(ActionEvent evt){
        Object btn= (Object)evt.getSource();
        if(btn==  aceptar){
            areaTexto.setText(null);
            this.dispose();
        }
    }
    public void run(){
        this.setLocationRelativeTo(frame);
        this.setVisible(true);
    }
}
