
package laboratorio4;

import java.util.Scanner;
public class Principal {
    
    public static void main(String[] args) {
        Entrada();
    }
    
    public static void Entrada(){ // n + nlog(n) : insertar,imprimir. n es la cantidad de nodos
        Scanner input = new Scanner(System.in);
        Arbol arbol = new Arbol();
        while(input.hasNextInt()){
            arbol.Insertar(input.nextInt());
        }
        arbol.mostrarPosOrden();
    }
    
}
