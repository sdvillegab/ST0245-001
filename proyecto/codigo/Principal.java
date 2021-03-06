/**
 * Clase Principal
 * En esta clase se incluyen los llamados para que se ejecute
 * tanto el programa como las pruebas
 * 
 * @author Julian Ramirez, Samuel Villegas
 * @version 15/11/2020
 */
import java.util.*;

public class Principal{
    /**
     * Clase main: Permite ejecutar el programa
     * @param args
     */
    public static void main(String args []){        
        pruebas("0_train_balanced_15000.csv","0_test_balanced_5000.csv");
        pruebas("1_train_balanced_45000.csv","1_test_balanced_15000.csv");
        pruebas("2_train_balanced_75000.csv","2_test_balanced_25000.csv");
        pruebas("3_train_balanced_105000.csv","3_test_balanced_35000.csv");
        pruebas("4_train_balanced_135000.csv","4_test_balanced_45000.csv");
    }
    /**
     * Recibe los nombres de el archivo para validación,y 
     * para el entrenamiento,y lanza el proceso de la construcción del
     * el arbol y su posterior validación
     * (Nota: En algunas ocasiones también se utiliza para probar
     * tiempo y memoria,por lo que parte del codigo estará comentado
     * )
     * @param archivoEntrenamiento
     * @param archivoTest
     */
    public static void pruebas(String archivoEntrenamiento, String archivoTest){
       /**  double totalE = 0;
        Arbol arbol = CargarDatos.Inicio(archivoEntrenamiento);
        for(int i = 0; i < 100; i++){
            long tiempoE0 = System.currentTimeMillis();
            double porcentajes[] = CargarDatos.Test(archivoTest, arbol);
            long totalE0 = System.currentTimeMillis()-tiempoE0;
            totalE += totalE0;
        }
        totalE /= 100;
        System.out.println(totalE)**/
          long tiempoE0 = System.currentTimeMillis();
          Arbol arbol = CargarDatos.Inicio(archivoEntrenamiento);
          System.out.println("MB: " + (double) ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024)/1024);
          long totalE0 = System.currentTimeMillis()-tiempoE0;
          long tiempoT0 = System.currentTimeMillis();
          double porcentajes[] = CargarDatos.Test(archivoTest, arbol);
          long totalT0 = System.currentTimeMillis()-tiempoT0;
          System.out.println("Entrenmiento: "+totalE0+" Test:"+totalT0);
          System.out.println("El algoritmo tiene un porcentaje "+porcentajes[0]+" de acierto");
          System.out.println("El algoritmo tiene un porcentaje "+porcentajes[1]+" de fallo");
          System.out.println("El algoritmo tiene un porcentaje "+Math.abs(100-(porcentajes[1]+porcentajes[0]))+" de marguen de error");
     }
}
