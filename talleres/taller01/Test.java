/*
*La clase Test sirve para probar algunos TAD
* @autor Julian Ramirez,Samuel Villegas
*/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Test{

    public static void testPunto(){
        String nombreFichero = "puntos.txt";
        File fichero = new File("data/" + nombreFichero);
        Scanner scan = null;
        try {
            scan = new Scanner(fichero);
            scan.nextLine();
            while (scan.hasNextLine()) {
                String lectura = scan.nextLine();
                Scanner scan2 = new Scanner(lectura);
                scan2.useDelimiter(" ");
                String id = scan2.next();
                double y = Double.parseDouble(scan2.next());
                double x = Double.parseDouble(scan2.next());
                Point p = new Point(x, y);
                System.out.println(id +" = Cartesianas: (" + x + "," + y + ") - Polares: (" +
                p.radio2D() + "," + p.TetaAngle() + "°) ;");
                scan2.close(); 
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scan.close();
        }
    }

    public static Fecha leerFecha(String linea){
        int day = Integer.parseInt(linea.substring(3,5));
        int month = Integer.parseInt(linea.substring(0,2));
        int year = Integer.parseInt(linea.substring(6,10));
        return new Fecha(day, month, year);
    }

    public static void testFecha() {
        String nombreFichero = "fechas.txt";
        File fichero = new File("data/" + nombreFichero);
        Scanner scan = null;
        try {
            scan = new Scanner(fichero);
            Fecha f1 = null;
            Fecha f2 = null;
            for(int i = 0; scan.hasNextLine(); i++){
                if(i >= 1 && i < 87){
                    f2 = f1;
                    f1 = leerFecha(scan.nextLine());
                    String resultado = "";
                    if(f2.comparar(f1) == 1){
                         resultado = " > ";
                    }else if(f2.comparar(f1) == -1){
                         resultado = " < ";
                    }else{
                         resultado = " = ";
                    }
                    System.out.println(f2.toString()+" es"+ resultado +"que "+ 
                    f1.toString());
                }else{
                     f1 = leerFecha(scan.nextLine());
                     System.out.println(f1.toString());
                }
            }
        }catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            scan.close();
        }
    }

    public static void main(String args[]) {
        System.out.println("¿Que desea probar? \n 1 - Punto \n  2 - Fecha ");
        Scanner scan = new Scanner(System.in);
        int lector = scan.nextInt();
        switch(lector){
            case 1:
                testPunto();
            break;
            case 2:
                testFecha();
            break;
        }
        scan.close();
    }
}