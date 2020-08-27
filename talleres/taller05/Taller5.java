/**
 * Taller 5 presenta las soluciones a los ejercicios
 * 
 * 
 */
public class Taller5{

    /**
     * insertionSort recibe una arreglo de n elementos y lo devuelve ordenado
     * 
     * @param int[]
     * @return int[]
     */
    public static int[] insertionSort(int[] arr){

        for(int i = 0; i < arr.length; i++){
            for(int j = i; j > 0; j++){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];

                }
            }
        }
    }

    /**
     * sumaArreglo realiza la suma de los elementos de un arreglo
     * y la devuelve
     * @param int[] 
     * return int
     */
    public static int sumaArreglo(int[]  arr){
        int suma = 0;
        for(int i = 0;  i < arr.length; i++){
            suma += arr[i];
        }
        return suma;
    }

    /**
     * tablaMultiplicar calcula las tablas de multipliocar desde 1 hasta n
     * 
     * @param int que es n
     * @return void
     */
    public static void tablaMultiplicar(int n){
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= 10; j++){
                System.out.println(i+"*"+j+"="+i*j);
            }
        }
    }
}