/*
Acceso a base de datos multiple, para acceso a  archivos, MySql y SQLServer
*/
package Modelo.DataAccessObject;

import Modelo.Components.Credenciales;
import Modelo.Empresa;
import Modelo.Inversionista;
import Modelo.SAB;
import java.util.ArrayList;

public interface DataBase {
    public static final String OFFLINE="OFFLINE";
    public static final String MySQL="MYSQL";
    public static final String SQLServer="SQLSERVER";
    //C
    public void addInversionista(Inversionista inversionista);
    //R

    public Inversionista getInversionista(Credenciales cuenta);
    public ArrayList<SAB> getListaSAB();
    public ArrayList<Empresa> getListaEmpresa();
    public SAB getSAB(String ID);
    public Empresa getEmpresa(String ID);
    public void registrarEmpresa(Empresa emp);
    public void registrarSAB(SAB sab);
    //U
    public void updateInversionista(Inversionista inversionista);
    public void updateEmpresa(Empresa emp);
    //D
    public boolean deleteInversionista(Credenciales credenciales);

}
