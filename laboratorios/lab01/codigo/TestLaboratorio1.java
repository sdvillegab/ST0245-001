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
		System.out.println("C1, C2 : "+Laboratorio1.subCadenaComun("ABCDGH", "AEDFHR"));
		System.out.println("C3, C4 : "+Laboratorio1.subCadenaComun("ABCDGHLFJJVJJIWEHHH", "AEDFHRKUWQUGUXGHB"));
		// *Nota* Al hacer la prueba con las cadenas de los datasets completas,
		// se generó un StackOverflow,
		// mientras que con otras cadenas de menor tamaño este error no ocurre,
		//aun asi notamos que el tiempo de ejecucion resultó ser bastante grande para las cadenas que usamos
		System.out.println("Adn1(25), Adn2(25) : "+Laboratorio1.subCadenaComun(adn1.substring(0,25), adn2.substring(0,25)));
		System.out.println("Adn1(10), Adn3(10) : "+Laboratorio1.subCadenaComun(adn1.substring(0,10), adn3.substring(0,10)));
		System.out.println("Adn2(5), Adn3(5) : "+Laboratorio1.subCadenaComun(adn2.substring(0,5), adn3.substring(0,5)));
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
        ejercicio12();
    }
}