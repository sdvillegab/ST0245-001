/**
 * Test ejercicios del lab 1
 * @autor Julian Ramirez,Samuel Villegas
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class TestLaboratorio1{
    public static void ejercicio11(){
		String adn1,adn2,adn3;
		adn1 = adn2 = adn3 = "";
		String nombreFichero = "adn.txt";
        File fichero = new File("data/" + nombreFichero);
        Scanner scan = null;
        try {
			scan = new Scanner(fichero);
			adn1 = scan.next(); 
			adn2 = scan.next();
			adn3 = scan.next();  

		}catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            scan.close();
		}
		for(int i = 10; i < 40;i++){
            long t1 = System.currentTimeMillis();
            //System.out.println("Adn1(), Adn2() : "+Laboratorio1.subCadenaComun(adn1.substring(0,i), adn2.substring(0,i)));
            Laboratorio1.subCadenaComun(adn1.substring(0,i), adn2.substring(0,i));
            long t2 = System.currentTimeMillis();
            System.out.println(t2-t1);
        }

    }
    public static void ejercicio12(){
        System.out.println("Para 1: "+Laboratorio1.llenaRectangulo(1));
        System.out.println("Para 2: "+Laboratorio1.llenaRectangulo(2));
        System.out.println("Para 5: "+Laboratorio1.llenaRectangulo(5));
        System.out.println("Para 9: "+Laboratorio1.llenaRectangulo(9));
        System.out.println("Para 15: "+Laboratorio1.llenaRectangulo(15));
    }
    public static void main(String args[]){
        ejercicio11();
        //ejercicio12();
    }
}