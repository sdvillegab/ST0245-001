
import javafx.util.Pair;

public class Taller10 {

    public static void main(String[] args) {
        Arbol arb = new Arbol();

        arb.Insertar(new Pair("Samuel", 10));
        arb.Insertar(new Pair("Samuel", 5));
        arb.Insertar(new Pair("Samuel", 20));
        arb.Insertar(new Pair("Samuel", 3));
        arb.Insertar(new Pair("Samuel", 9));
        arb.Insertar(new Pair("Samuel", 11));
        arb.Insertar(new Pair("Samuel", 22));
        arb.Insertar(new Pair("Samuel", 1));
        
        
        arb.generarCadena();
        
        System.out.println(arb.Buscar(99));
    }

}
