/**
 *
 * @author Julian Ramirez,Samuel Villegas
 * Solucion a los puntos 1.1 y 1.2 del laboratorio
 */
public class Laboratorio1 {
    
    /**
     * Devuelve la longitud de la subcadena comun más grande enntre dos cadenas
	 * @param  s1 es una cadena
	 * @param s2 es una cadena
	 *
	 * @return int devuelve la longitud de la subcadena común más grande entre dos cadenas
	 */
	public static int subCadenaComun(String s1,String s2){
        return subCadenaComunAux(s1,s2,s1.length(),s2.length());
    }
    /**
     * Es un auxiliar para obtener la longitud de la subcadena comun mas larga
    */
    private static int subCadenaComunAux(String s1, String s2 , int i, int j ){
        if (i == 0 || j == 0){
            return 0; //c1
        }
        if (s1.charAt(i-1) == s2.charAt(j-1)){
            return 1 + subCadenaComunAux(s1, s2, i-1, j-1); //c2+T(n-1,m-1)
        }else{
            return Math.max(subCadenaComunAux(s1, s2, i, j-1), subCadenaComunAux(s1, s2, i-1, j));//c3+T(n,m-1)+T(n-1,m)
        }
    }
    
    /**
     * Calcular de cuantas formas se puede llenar un rectangulo de 2xn
     * con rectangulos de 1x2
     * 
     * @param n longitud n del rectangulo de 2xn
     * @return el numero de formas en que se puede llenar un rectangulo de 2xn
     * con rectangulos de 1x2
     */
    public static int llenaRectangulo(int n){
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }
        else{
            return llenaRectangulo(n-1)+llenaRectangulo(n-2);
        }
    }

}