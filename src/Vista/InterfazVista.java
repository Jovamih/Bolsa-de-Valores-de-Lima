
package Vista;
import Controlador.ControladorPrincipal;
import java.awt.event.*;
/**
 * <h1> Interfaz {@code InterfazVista}</h1>
 * Esta es una interfaz que obliga a las clases encargadas de la vista {@link SesionVista} y {@link SoftwareVista}
 * @author Johan
 * @version 1.0
 */
public interface InterfazVista {
    String INICIAR="INICIAR_SESION";
    String USUARIO="NOMBRE_USUARIO";
    String CHECK_SESION="MANTENER_SESION";
    String SALIR="EXIT";
    /**
     * <h1> Funcion {@code setConstroller()}</h1>
     * Recibe un controlador de eventos como parametro para que las vistas preserven el patron de diseño MVC
     * <p>
     * @param controller : Controlador que debe implementar la Interfaz {@code ActionListener} @see java.awt.event.ActionListener
     * 
     */
    public void setController(ActionListener controller);
    /**
     * <h1> Metodo {@code run()}</h1>
     * Permite visualizar la ventana centrandola en la pantalla
     * <p>
     * No recibe paramatros de entrada y no devuelev ningun valor
     */
    public void run();
}
