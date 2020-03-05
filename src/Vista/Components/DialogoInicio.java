
package Vista.Components;
import Controlador.ControladorPrincipal;
import Vista.SesionVista;
import Vista.SoftwareVista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class DialogoInicio extends JDialog {
    Container contenido= this.getContentPane();
    SoftwareVista frame=null;
    JTextField infoCapital;
    JComboBox <String> combo_sab;
    JButton iniciar;
    JPanelPRO panel = new JPanelPRO("/Recursos/natural.jpg");
    public DialogoInicio(SoftwareVista frame){
        super(frame);
        this.frame= frame;
        settings();
        initComponents();
    }
    private void settings(){
        this.setSize(437, 245);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setModal(true);
    }
    private void initComponents(){
        contenido.setLayout(new BorderLayout());
        panel.setLayout(null);
        JLabel titulo= new JLabel("Mi primer inicio");
        JLabel capital= new JLabel("Capital Inicial");
        JLabel sab= new JLabel("Afiliar a un SAB");
        infoCapital= new JTextField();
        combo_sab= new JComboBox<>();
        iniciar= new JButton("Vamos!");
        //
           
        titulo.setFont(new Font("Segoe UI Light", 1, 19));
        panel.add(titulo);
        titulo.setBounds(150, 10, 150, 20);

        capital.setFont(new Font("Segoe UI Light", 1, 16));
        panel.add(capital);
        capital.setBounds(70, 70, 120, 22);

        sab.setFont(new Font("Segoe UI Light", 1, 16)); 
        panel.add(sab);
        sab.setBounds(60, 120, 140, 20);

        infoCapital.setFont(new Font("Segoe UI Light", 1, 18)); 
        infoCapital.setHorizontalAlignment(JTextField.CENTER);
        infoCapital.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        infoCapital.setOpaque(false);
        panel.add(infoCapital);
        infoCapital.setBounds(230, 80, 130, 20);

        combo_sab.setFont(new Font("Segoe UI Light", 1, 16));
        panel.add(combo_sab);
        combo_sab.setBounds(220, 120, 160, 30);

        iniciar.setFont(new Font("Segoe UI Light", 1, 18)); 
        iniciar.setOpaque(false);
        iniciar.setActionCommand("PRIMER_INICIO");
        panel.add(iniciar);
        iniciar.setBounds(150, 180, 150, 40);

        contenido.add(panel,BorderLayout.CENTER);
    }
    public String getSAB(){
        return (String)combo_sab.getSelectedItem();
    }
    public double getCapital(){
        double capital=0.0;
        try{
            capital= Double.parseDouble(infoCapital.getText());
        }catch(Exception e){
            capital=0;
        }
        return capital;
    }
    public void añadirSab(String lista){
          if(lista!=null)
            combo_sab.addItem(lista);
        
    }
    public void limpiar(){
        infoCapital.setText("");
    }
    public void setController(ActionListener c){
        iniciar.addActionListener(c);
    }
    public void run(){
        this.setLocationRelativeTo(frame);
        this.setVisible(true);
    }
}
