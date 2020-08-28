/**
 * Taller 5 presenta las soluciones a los ejercicios
 * 
 * @autor Julian Ramirez,Samuel Villegas
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
            for(int j = i; j > 0; j--){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }else{
                    break;
                }
            }
        }
        return arr;
    }

    /**
     * sumaArreglo realiza la suma de los elementos de un arreglo
     * y la devuelve
     * @param int[] 
     * return int
     */
    public static int sumaArreglo(int[]  arr){
        int suma = 0;//c1
        for(int i = 0;  i < arr.length; i++){//c2 + c3*n
            suma += arr[i];//c4*n
        }
        return suma;//c5
        //T(n)= c1+c2+c3*n+c+c4*n+c5
        //O(n)
    }

    /**
     * tablaMultiplicar calcula las tablas de multipliocar desde 1 hasta n
     * 
     * @param int que es n
     * @return void
     */
    public static void tablaMultiplicar(int n){
        for(int i = 1; i <= n; i++){//c1*n
            for(int j = 0; j <= 10; j++){//c2
                System.out.println(i+"*"+j+"="+i*j);//c3*c2
            }
        }
        //O(n)
    }

    public static void main(String args[]){
        /*for(int i = 1000000;i <= 2000000000; i+=1000){
            long ti = System.currentTimeMillis();
            sumaArreglo(new int[i]);
            long tf = System.currentTimeMillis();
            System.out.println(tf-ti);
        }*/
        int[] arr = {5,4,0,1,2,3};
        int[] ordered = insertionSort(arr);
        for(int i = 0;i < ordered.length; i++){
            System.out.println(ordered[i]);
        }
        tablaMultiplicar(3);
    }
}