
package Modelo.DataAccessObject;

import Modelo.Components.Credenciales;
import Modelo.Empresa;
import Modelo.Inversionista;
import Modelo.SAB;
import java.io.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
//la base de datos offline tendra una sola instancia y cargara todos los datos en sus arrayList
//al terminar el programa guardara todo los datos en el archivo
public final class OfflineDataBase implements DataBase {
    File databaseInv, databaseEmp, databaseSAB;
    public OfflineDataBase(){
        databaseInv= new File("dataInversionistas.dat");
        databaseEmp= new File("dataEmpresas.dat");
        databaseSAB= new File("dataSAB.dat");
      // settings();
    }

    @Override
    public void addInversionista(Inversionista inversionista){
         ArrayList<Inversionista> lista= (ArrayList<Inversionista>)leerDatos(databaseInv);
         if(lista==null) lista= new ArrayList<>();
         lista.add(inversionista);
         guardarDatos(databaseInv,lista);
    }

    @Override
    public Inversionista getInversionista(Credenciales cuenta) {
        ArrayList<Inversionista> lista = (ArrayList<Inversionista>)leerDatos(databaseInv);
        if(lista==null) return null;
        else{
           Optional<Inversionista> inver=lista
                                        .stream()
                                        .filter((Inversionista l)->l.getCredenciales().equals(cuenta))
                                        .findFirst();
            return inver.isPresent()?inver.get():null;
        }
    }

    @Override
    public ArrayList<SAB> getListaSAB() {
        ArrayList<SAB> lista= (ArrayList<SAB>)leerDatos(databaseSAB);
        if(lista==null) lista= new ArrayList();
        return lista;
    }

    @Override
    public ArrayList<Empresa> getListaEmpresa() {
        ArrayList<Empresa> lista= (ArrayList<Empresa>)leerDatos(databaseEmp);
        if(lista==null) lista= new ArrayList<>();
        return lista;
    }

    @Override
    public SAB getSAB(String ID) {
        ArrayList<SAB> lista= getListaSAB();
        Optional<SAB> sab= lista.stream().filter(s->s.getNombre().equals(ID)).findFirst();
        return sab.isPresent()?sab.get():null;
    }

    @Override
    public Empresa getEmpresa(String ID) {
        ArrayList<Empresa> lista= getListaEmpresa();
        Optional<Empresa> optEmpresa= lista.stream().filter(e->e.getNombre().equals(ID)).findFirst();
        return optEmpresa.isPresent()?optEmpresa.get():null;
    }
   @Override
   public void updateEmpresa(Empresa emp){
       int index=0;
       ArrayList<Empresa> lista= getListaEmpresa();
       if((index= lista.indexOf(emp))!=-1){
           lista.set(index, emp);
           guardarDatos(databaseEmp,lista);
       }
   }
    @Override
    public void updateInversionista(Inversionista inversionista) {
        int index=0;
        ArrayList<Inversionista> lista=(ArrayList<Inversionista>)leerDatos(databaseInv);
        if(lista!=null){
            if((index=lista.indexOf(inversionista))!=-1){
                lista.set(index, inversionista);
                guardarDatos(databaseInv, lista);
            }
        }
    }

    @Override
    public boolean deleteInversionista(Credenciales cuenta) {
        int index=0;
         ArrayList<Inversionista> lista = (ArrayList<Inversionista>)leerDatos(databaseInv);
        if(lista==null || lista.isEmpty()) return false;
        else{
        for(int i=0; i<lista.size();i++){
            Credenciales cred= lista.get(i).getCredenciales();
            if(cred.getCorreo().equals(cuenta.getCorreo()) && cred.getContraseña().equals(cuenta.getContraseña())){
                index=i;
                }
            }
        }
        lista.remove(index);
        guardarDatos(databaseInv,lista);
        return true;
    }


    @Override
    public void registrarEmpresa(Empresa emp){
        ArrayList<Empresa> lista= getListaEmpresa();
        lista.add(emp);
        guardarDatos(databaseEmp, lista);
    }
    @Override
    public void registrarSAB(SAB sab){
        ArrayList<SAB> lista= getListaSAB();
        lista.add(sab);
        guardarDatos(databaseSAB, lista);
    }
  
  
    private void settings(){
        try{
        if(!databaseInv.exists()) 
            databaseInv.createNewFile();
        if(!databaseEmp.exists()) databaseEmp.createNewFile();
        if(!databaseSAB.exists()) databaseSAB.createNewFile();
        }catch(IOException e){
            
        }
    }
    private Object leerDatos(File file){
        Object lista=null;
        if(file.exists()){
        try{
            FileInputStream fis=new FileInputStream(file);
            ObjectInputStream ois= new ObjectInputStream(fis);
            lista= (Object)ois.readObject();
            ois.close();
        }catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OfflineDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return lista;
    }
    private void guardarDatos(File file, Object lista){
        
        try{
            if(!file.exists()) file.createNewFile();
            ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(lista);
            oos.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
