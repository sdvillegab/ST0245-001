import java.util.*;

public class Principal{

    public static void main(String args []){        
       Arbol arbol = CargarDatos.Inicio("data/0_train_balanced_15000.csv");
       double porcentajes [] = CargarDatos.Test("1_test_balanced_15000.csv", arbol);
       System.out.println("El algoritmo tiene un porcentaje "+porcentajes[0]+" de acierto");
       System.out.println("El algoritmo tiene un porcentaje "+porcentajes[1]+" de fallo");
       System.out.println("El algoritmo tiene un porcentaje "+Math.abs(100-(porcentajes[1]+porcentajes[0]))+" de marguen de error");
    }
}
