import java.util.*;

public class Principal{

    public static void main(String args []){        
       //Arbol arbol = CargarDatos.Inicio("data/0_train_balanced_15000.csv");
       //double porcentajes [] = CargarDatos.Test("1_test_balanced_15000.csv", arbol);
       //System.out.println("El algoritmo tiene un porcentaje "+porcentajes[0]+" de acierto");
       //System.out.println("El algoritmo tiene un porcentaje "+porcentajes[1]+" de fallo");
       //System.out.println("El algoritmo tiene un porcentaje "+Math.abs(100-(porcentajes[1]+porcentajes[0]))+" de marguen de error");
        pruebas("0_train_balanced_15000.csv","0_test_balanced_5000.csv");
        pruebas("1_train_balanced_45000.csv","1_test_balanced_15000.csv");
        pruebas("2_train_balanced_75000.csv","2_test_balanced_25000.csv");
        pruebas("3_train_balanced_105000.csv","3_test_balanced_35000.csv");
        pruebas("4_train_balanced_135000.csv","4_test_balanced_45000.csv");
    }
    public static void pruebas(String archivoEntrenamiento, String archivoTest){
        long tiempoE0 = System.currentTimeMillis();
        Arbol arbol = CargarDatos.Inicio(archivoEntrenamiento);
        long totalE0 = System.currentTimeMillis()-tiempoE0;
        long tiempoT0 = System.currentTimeMillis();
        double porcentajes[] = CargarDatos.Test(archivoTest, arbol);
        long totalT0 = System.currentTimeMillis()-tiempoT0;
        System.out.println("Entrenmiento: "+totalE0+" Test:"+totalT0);
     }
}
