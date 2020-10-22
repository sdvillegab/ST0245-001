
package taller11;

import java.util.ArrayList;

public class GrafoMatriz {
    
    private int matriz [][];
    private int numVertices;
    private int numArcos;
    private final int SIN_CONEXION = Integer.MIN_VALUE;
    
    GrafoMatriz(int cantidadVertices){        
       this.matriz = new int [cantidadVertices][cantidadVertices];
       this.numVertices = cantidadVertices;    
       for(int i = 0;i<cantidadVertices;i++){
           for(int j = 0;j<cantidadVertices;j++){
               this.matriz[i][j] = SIN_CONEXION;
           }
       }
    }
    
    boolean agregarArco(int etiqueta, int verticePartida, int verticeLlegada){
        try {
            this.matriz[verticePartida][verticeLlegada] = etiqueta;
            this.numArcos++;
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    ArrayList<Integer> obtenerVerticesAsociados(int verticePartida){
        ArrayList<Integer> nodosAsociados = new ArrayList<>();
        for(int i = 0;i<numVertices;i++){
            if(this.matriz[verticePartida][i] != SIN_CONEXION)nodosAsociados.add(this.matriz[verticePartida][i]);
        }
        return nodosAsociados;
    }
    
    int obtenerLongitud(int verticePartida, int verticeLlegada){
        return this.matriz[verticePartida][verticeLlegada];
    }
    
    void mostrarMatriz(){
        for(int i = 0;i<numVertices;i++){
           for(int j = 0;j<numVertices;j++){
               if(this.matriz[i][j] != SIN_CONEXION) System.out.print(this.matriz[i][j]+" ");
               else System.out.print("00 ");
           }
          System.out.println("");
       }
    }
    
    
}
