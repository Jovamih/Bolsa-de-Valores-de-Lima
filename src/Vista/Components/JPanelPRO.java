package Vista.Components;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Graphics;
/**
 * Panel {@code JPanelPRO}
 * Extiende la clase {@link javax.swing.JPanel}
 * <p>
 * Esta clase tiene como objetivo redefinir los metodos escenciales de JPanel
 * para poder mostrar una imagen de fondo personalizada
 */
public class JPanelPRO extends JPanel{
    private String url=null;
    public JPanelPRO(String url){
        this.url=url;
    }
    @Override
    public void paintComponent(Graphics g){
       Dimension dm= this.getSize();
       this.setOpaque(false);
      try{
       ImageIcon fondo= new ImageIcon(getClass().getResource(url));
       g.drawImage(fondo.getImage(),0,0,dm.width,dm.height,null);
      }catch(Exception e){
          System.out.println("Error al procesar Imagen >"+e);
          e.printStackTrace();
      }
       super.paintComponent(g);
    }
}
