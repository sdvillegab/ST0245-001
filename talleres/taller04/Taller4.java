
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

/**
 *La clase Taller4 dos tiene como objetivo dar solución al taller 4
 *
 *@autor Mauricio Toro, Camilo Paez
 *@version 1
 *
 * @autor Julian Ramirez,Samuel Villegas
 * @version 2
 */
public class Taller4 {


    public static void main(String[] args) {

        System.out.println("Pruebas arrayMax desde 10020 hasta 10040");
        for(int i = 10020;i<=10040;i++){
            long fi = System.currentTimeMillis();
            arrayMax(new int[i]);
            long ff = System.currentTimeMillis()-fi;
            System.out.println(ff);
        }

        System.out.println("Pruebas volumenes desde 14 hasta 34");
        for(int i = 14;i<=34;i++){
            long fi = System.currentTimeMillis();
            Volumenes(new int[i],10);
            long ff = System.currentTimeMillis()-fi;
            System.out.println(ff);
        }


        System.out.println("Pruebas fibonacci desde 130 hasta 50");
        for(int i = 30;i<=50;i++){
            long fi = System.currentTimeMillis();
            fibonacci(i);
            long ff = System.currentTimeMillis()-fi;
            System.out.println(ff);
        }
    }


    /**
     * @param array es un arreglo de numeros enteros
     *
     *
     *Este metodo se utiliza para llamar el metodo privado arrayMax
     *
     * @return el elemento más grande
     */
    public static int arrayMax(int[] array) {
        return arrayMax(array,0,-9999999);
    }

    /**
     * @param array es un arreglo de numeros enteros
     * @param indice iterador en el arreglo
     * @param max nos indica cual es el maximo hasta el momento
     *
     *En este metodo se quiere elejir el elemento maximo de un
     *arreglo de enteros
     *
     * @return el elemento más grande
     */
    private static int arrayMax(int[] array, int indice, int max){
        if(indice == array.length-1) return max;
        if(array[indice]>max)return arrayMax(array,indice+1,array[indice]); //T(n-1) =  O(1)
        else return arrayMax(array,indice+1,max);
    }


    /**
     * @param array es un arreglo de numeros enteros, representan volumen
     * @param target es la meta, el numero que debe alacanzar la suma
     *
     * Este metodo se utiliza para llamar el metodo privado groupSum
     *
     *
     * @return verdadero si hay una combinación que suponga el valor target, falso de lo contrario
     */


    public static boolean Volumenes(int[] array, int target) {
        return Volumenes(0,array,target);
    }

    /**
     * @param start es un contador, nos sirve para saber cuando debemos parar
     * @param array es un arreglo de numeros enteros, representan volumen
     * @param target es la meta, el numero que debe alacanzar la suma
     *
     * en este método se busca hacer la suma de los volumnes posibles
     * de modo que se acomode de tal forma que se alcance el valor target
     * pista: la clave esta en el numero de elementos y que no siempre se toman
     * los elementos, en ocaciones pasan por ejemplo en un conjuntos [5,6,7,8] para un
     * target 12 se toman el 5 y el 7 pasando por 6 sin cogerlo.
     *
     *
     * @return verdadero si hay una combinación que suponga el valor target, falso de lo contrario
     */
    private static boolean Volumenes(int start, int[] array, int target) {
        if(start>=array.length)return target == 0;
        return Volumenes(start+1, array, target-array[start]) || Volumenes(start+1,array,target); // T(n-1) + T(n-1)  =  C1*2^n-1 = O(2^n)
    }



    /**
     * @param n numero entero, hasta que numero se hace la serie
     *
     * el metodo se encarga de devolvernos el valor fibonacci en la enesima posicion
     * @see <a href="https://es.wikipedia.org/wiki/Sucesi%C3%B3n_de_Fibonacci"> fibonnaci <a/>
     * @return el valor encontrado en long dada la posible cantidad de bits
     */
    public static long fibonacci(int n) {
        if(n ==0 ) return 0; // C1 = 3
        if(n == 1) return 1; // C2 = 3
        return fibonacci(n-1) + fibonacci(n-2); //T(n-1) + T(n-2) = c_1 F_n + c_2 L_n (where c_1 and c_2 are arbitrary parameters) F_n is fibo number and L_n is lucas number
    }
}
