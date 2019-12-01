
package Modelo.DataAccessObject;
//Patron de Diseño -> Factory Method
public class FactoryDataBase {
    public static DataBase getBaseDeDatos(String DATABASE){
        DataBase data=null;
        switch(DATABASE){
            case DataBase.OFFLINE:
                data= new OfflineDataBase();
                break;
            case DataBase.MySQL:
                break;
            case DataBase.SQLServer:
                break; //cierre
            default:
                //no tendria porque suceder pero por default se deja vacio pa futuras implementaciones
                break;
        }
        return data;
    }
}
