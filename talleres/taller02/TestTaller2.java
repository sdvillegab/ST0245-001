/**
 * La clase TestTaller2 sirve para hacer las pruebas de los ejercicios del Taller2
 * Julian Ramirez, Samuel Villegas
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TestTaller2 {

	
	public static boolean ejercicio1(){
		int a, b, c, d;
		a=Taller2.gcd(12,36);
		b=Taller2.gcd(8,12);
		c=Taller2.gcd(72,108);
		d=Taller2.gcd(162, 270);
		if(a==12 && b==4 && c==36 && d==54)
			return true;
		return false;
	}
	
	public static boolean ejercicio2(){
		boolean a, b, c, d;
		a=Taller2.SumaGrupo(new int[] {2, 4, 8}, 9);
		b=Taller2.SumaGrupo(new int[] {2, 4, 8}, 8);
		c=Taller2.SumaGrupo(new int[] {10, 2, 2, 5}, 9);
		d=Taller2.SumaGrupo(new int[] {10, 2, 2, 5}, 17);
		if(!a && b && c && d)
			return true;
		return false;
	}
	
	public static void ejercicio3(){
		System.out.println("Para la cadena 'abc' el resultado debe ser similar a:");
		System.out.println("a, ab, abc, ac, b, bc, c\n");
		Taller2.combinations("abc");

		System.out.println("Para la cadena 'Eafit' el resultado debe ser similar a:");
		System.out.println("E, Ea, Eaf, Eafi, Eafit, Eaft, Eai, Eait, Eat, Ef, Efi, Efit, Eft, Ei, Eit, Et, a, af, afi, afit, aft, ai, ait, at, f, fi, fit, ft, i, it, t\n");
		Taller2.combinations("Eafit");
		
		System.out.println("Para la cadena 'Hola' el resultado debe ser similar a:");
		System.out.println("H, Ho, Hol, Hola, Hoa, Hl, Hla, Ha, o, ol, ola, oa, l, la, a\n");
		Taller2.combinations("Hola");

		System.out.println("Para la cadena 'Hi' el resultado debe ser similar a:");
		System.out.println("H, i, Hi\n");
		Taller2.combinations("Hi");
	}
	
	public static void ejercicio4(){
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
		System.out.println("C1, C2 : "+Taller2.subCadenaComun("ABCDGH", "AEDFHR"));
		System.out.println("C3, C4 : "+Taller2.subCadenaComun("ABCDGHLFJJVJJIWEHHH", "AEDFHRKUWQUGUXGHB"));
		// *Nota* Al hacer la prueba con las cadenas de los datasets completas,
		// se generó un StackOverflow,
		// mientras que con otras cadenas de menor tamaño este error no ocurre,
		//aun asi notamos que el tiempo de ejecucion resultó ser bastante grande para las cadenas que usamos
		System.out.println("Adn1(25), Adn2(25) : "+Taller2.subCadenaComun(adn1.substring(0,25), adn2.substring(0,25)));
		System.out.println("Adn1(10), Adn3(10) : "+Taller2.subCadenaComun(adn1.substring(0,10), adn3.substring(0,10)));
		System.out.println("Adn2(5), Adn3(5) : "+Taller2.subCadenaComun(adn2.substring(0,5), adn3.substring(0,5)));
	}
	
	public static void main(String[] args){	
        //Ejercicio1
        if(ejercicio1())
            System.out.println("Ejercicio 1 Correcto");
        else
        System.out.println("Ejercicio 1 Incorrecto");

        //Ejercicio2
        if(ejercicio2())
            System.out.println("Ejercicio 2 Correcto");
        else
        System.out.println("Ejercicio 2 Incorrecto");
        
        
        //Ejercicio3
		ejercicio3();
		
		//Ejercicio 4
		ejercicio4();
        

    }
}