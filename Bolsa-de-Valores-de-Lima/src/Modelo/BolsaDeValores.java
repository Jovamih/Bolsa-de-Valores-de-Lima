
package Modelo;
import Modelo.Components.Accion;
import Modelo.Components.Constants;
import Modelo.Components.Solicitud;
public final class BolsaDeValores {
   private static String respuesta;
   private static int count=0; //cuenta las operaciones compra/venta consultadas
   //comsiones a aplizar por operacion
    private static final double CAVALI=0.000650; //0.0650%
    private static final double BVL=0.000775;    //0.0775%
    private static final double SMV= 0.0005;    //0.05%
    private static final double IGV= 0.19;
   public BolsaDeValores(){
   }
    public static void ProcesaPropuestaVenta(double sab,Solicitud orden, Inversionista usuario){
        //aplicaos los descuentos sobre el capital de inversionista
        double monto =orden.getMonto()-orden.getMonto()*interes(sab);
        double capitalI=usuario.getCapital();
        usuario.setCapital(capitalI+monto);
        //aplicamos los resultados alas acciones
        Accion acciones = usuario.getAccion(orden.getEmpresa());
        if(acciones!=null){
             acciones.setAcciones(acciones.getAcciones()-orden.getAccionesNegociar());
               if(acciones.getAcciones()<=0){
                   usuario.removerAccion(acciones);
               }else  usuario.guardarAccion(acciones);
        }     
        respuestaOperacion(orden,monto,capitalI,usuario.getCapital());
     count++;
    }
    public static void ProcesaPropuestaCompra(double sab,Solicitud orden, Inversionista usuario){
        //aplicamos los descuentos e intereses de compra de acciones
        try{
        double monto= orden.getMonto()+ orden.getMonto()*interes(sab);
        double capitalI= usuario.getCapital();
        usuario.setCapital(capitalI-monto);
        //aplicamos los resultados a las acciones
        Accion acciones = usuario.getAccion(orden.getEmpresa());
        if(acciones!=null){
            acciones.setAcciones(acciones.getAcciones()+orden.getAccionesNegociar());
        }else{
            acciones= new Accion(usuario.getTitular(),orden.getEmpresa(),orden.getAccionesNegociar());
        }
        respuestaOperacion(orden,monto,capitalI,usuario.getCapital());       
        usuario.guardarAccion(acciones);
        count++;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private static void respuestaOperacion(Solicitud orden,double montoF,double capitalI, double capitalF){
        respuesta="OPERACION DE "+orden.getOperacion()+
                  "\n-------------------------------"+
                  "\nCapital Inicial : "+capitalI+
                  "\nEmpresa              : "+orden.getEmpresa()+
                  "\nAcciones solicitadas : "+orden.getAccionesNegociar()+
                  "\nValor de la accion   : "+orden.getValorAcciones()+
                  "\n"+(orden.getOperacion().equals(Constants.COMPRA) ? "Costo":"Ganancia")+" bruto: "+orden.getMonto()+
                  "\n-----------------------------"+
                  "\nINTERESES"+
                  "\n-----------------------------"+
                  "\nBolsa de Valores de Lima : "+ BVL*100+"%"+
                  "\nCAVALI                   : "+ CAVALI*100+"%"+
                  "\nSMV                      : "+SMV*100+"%"+
                  "\nIGV                      : "+IGV*100+"%"+
                  "\n"+(orden.getOperacion().equals(Constants.COMPRA) ? "Costo":"Ganancia")+" Neto: "+montoF+
                  "\n----------------------------------"+
                  "\nCapital final : "+capitalF+ 
                  "\n----------------------------------";
        
    }
    public static String getRespuestaOperacion(){
        return respuesta;
    }
    private static double interes(double interes){
        return (CAVALI+BVL+SMV+IGV+interes/100);
    }
}
