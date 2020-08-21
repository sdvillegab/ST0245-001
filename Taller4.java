
/**
 *La clase Taller4 dos tiene como objetivo dar solución al taller 4
 *
 *@autor Mauricio Toro, Camilo Paez
 *@version 1
 */
public class Taller4 {


    /**
     * @param array es un arreglo de numeros enteros
     * 
     *
     *En este metodo se quiere elejir el elemento maximo de un
     *arreglo de enteros
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
        if(array.length-1 == indice) return max;
        if(array[indice]>max)return arrayMax(array,indice+1,array[indice]);
        else return arrayMax(array,indice+1,max);
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
    public static boolean groupSum(int start, int[] array, int target) {
        if(start>=array.length)return target == 0;
        return groupSum(start+1, array, target-array[start]) || groupSum(start+1,array,target);
    }



    /**
     * @param n numero entero, hasta que numero se hace la serie
     *
     * el metodo se encarga de devolvernos el valor fibonacci en la enesima posicion
     * @see <a href="https://es.wikipedia.org/wiki/Sucesi%C3%B3n_de_Fibonacci"> fibonnaci <a/>
     * @return el valor encontrado en long dada la posible cantidad de bits
     */
    public static long fibonacci(int n) {
        if(n ==0 ) return 0;
        if(n == 1) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
