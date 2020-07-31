/*
*La clase Test sirve para probar algunos TAD
* @autor Julian Ramirez,Samuel Villegas
*/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Test{

    public static void testPunto(){
       File fichero = new File("data/"+puntos.txt);
       Scanner scan = null;
       try{
          scan = new Scanner(fichero);
          while(scan.hasNextLine()){
            int id = Integer.parseInt(scan.next());
            double y = Double.parseDouble(scan.next());
            double x = Double.parseDouble(scan.next());
          }
       }catch(FileNotFoundException fnfe){
          System.out.println(fnfe);    
       }catch(Exception e){
           e.printStackTrace();
       }finally{
         scan.close();    
       }
    }

    public static void  testFecha(){

    }

    public static void testLinea(){

    }

    public static void main(){
        System.out.println("¿Que desea probar? \n 1 - Punto \n  2 - Fecha  \n 3 - Linea2D");
        final Scanner scan = new Scanner(System.in);
        final int lector = scan.nextInt();
        switch(lector){
            case 1:
                testPunto();
            break;
            case 2:
                testFecha();
            break;
            case 3:
                testLinea();
            break;

        }
        scan.close();
    }
}