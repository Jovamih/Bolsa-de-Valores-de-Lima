
package Modelo.Components;

public class Solicitud {
    private  int accionesNegociar;  //en caso que deseé vender acciones
    private  double valorAcciones;     //valor de acciones a la que desea comprar/vender
    private  String empresa;
    private  String operacion;
    public Solicitud(String operacion, String empresa, int acciones, double valor) {
        this.accionesNegociar=acciones;
        this.valorAcciones=valor;
        this.operacion= operacion;
        this.empresa= empresa;
    }
    public Solicitud(){
        //una solicitud vacia
    }
    public int getAccionesNegociar(){
        return accionesNegociar;
    }
    public double getValorAcciones(){
        return valorAcciones;
    }
    public double getMonto(){
        return accionesNegociar*valorAcciones;
    }
    public String getEmpresa(){
        return empresa;
    }
    public String getOperacion(){
        return operacion;
    }
    @Override
    public String toString(){
        String informacion="";
        informacion="SOLICITUD DE "+this.operacion+
                    "\n--------------------------"+
                    "\nEmpresa: "+this.empresa+
                    (this.operacion.equals(Constants.VENTA) ? "Pongo a disposicon de la BVL: ":"Solicito comprar: ")+
                    "\n Un total de "+accionesNegociar+" acciones a un valor de "+valorAcciones+
                     (this.operacion.equals("COMPRA") ? ("\nDeposito de"+getMonto()):"")+
                    "\nAtentamente, un querido accionista\n";
        return informacion;
    }
}
