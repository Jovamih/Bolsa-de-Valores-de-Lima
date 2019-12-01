
package Vista;
import Controlador.ControladorPrincipal;

public interface InterfazVista {
    String INICIAR="INICIAR_SESION";
    String USUARIO="NOMBRE_USUARIO";
    String CHECK_SESION="MANTENER_SESION";
    String SALIR="EXIT";
    public void setController(ControladorPrincipal controller);
    public void run();
}
