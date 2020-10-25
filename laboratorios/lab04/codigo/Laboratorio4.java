
package laboratorio4;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Laboratorio4 {

    
    public static void main(String[] args) {        
        Inicio();
    }
    
    
    
    public static void Inicio(){
        ArrayList<Abeja> abejas = CargarDatos.Cargar();
        Cubo cubo = new Cubo(CargarDatos.ObtenerMinMax(abejas));
        for(Abeja abeja: abejas){
            cubo.asignarAbeja(abeja);
        }
    
    }
    
}
