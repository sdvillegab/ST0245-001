/*
*La clase Test sirve para probar algunos TAD
* @autor Julian Ramirez,Samuel Villegas
*/
import java.util.Scanner;

public Class Test{

    public void testPunto(){

    }

    public void  testFecha(){

    }

    public void testLinea(){

    }

    public static void main(){
        System.out.println("¿Que desea probar? \n 1 - Punto \n  2 - Fecha  \n 3 - Linea2D");
        Scanner scan = new Scanner(System.in);
        int lector = scan.nextInt();
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
    }
}