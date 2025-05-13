package diario;

import java.util.ArrayList;

public class GestorEntradas {
    public boolean eliminarEntradaPorId(int id, ArrayList<NuevaEntrada> entradas){
        //Si la entrada es null o empty
        if(entradas == null || entradas.isEmpty()){
            return false;
        }
        //Recorremos el arraylist
        for(int i = 0; i < entradas.size(); i++){
            if(entradas.get(i).getId() == id){
                //Si la entrada es igual al id, la eliminamos
                entradas.remove(i);
                return true;
            }
        }
        //Si no se ha encontrado la entrada, devolvemos false
        return false;
    }
}
