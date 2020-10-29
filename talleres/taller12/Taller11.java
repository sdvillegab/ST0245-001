
public class Taller11 {

    public static void main(String[] args) {
        GrafoLista grafo = new GrafoLista(6);
        grafo.agregarArco(10, 0, 1);
        grafo.agregarArco(20, 5, 0);
        grafo.agregarArco(30, 5, 3);
        grafo.agregarArco(40, 2, 0);
        grafo.agregarArco(50, 4, 3);
        grafo.agregarArco(60, 3, 2);
        grafo.agregarArco(70, 0, 3);
        grafo.agregarArco(80, 3, 0);
        grafo.agregarArco(90, 3, 1);
        grafo.agregarArco(100, 2, 4);
        
        grafo.mostrar();
        System.out.println(grafo.obtenerLongitud(3,1));
        System.out.println(grafo.obtenerVerticesAsociados(3));
        
        
        GrafoMatriz grafo2 = new GrafoMatriz(6);
        grafo2.agregarArco(10, 0, 1);
        grafo2.agregarArco(20, 5, 0);
        grafo2.agregarArco(30, 5, 3);
        grafo2.agregarArco(40, 2, 0);
        grafo2.agregarArco(50, 4, 3);
        grafo2.agregarArco(60, 3, 2);
        grafo2.agregarArco(70, 0, 3);
        grafo2.agregarArco(80, 3, 0);
        grafo2.agregarArco(90, 3, 1);
        grafo2.agregarArco(100, 2, 4);
        
        grafo2.mostrarMatriz();
        System.out.println(grafo2.obtenerLongitud(3,1));
        System.out.println(grafo2.obtenerVerticesAsociados(3));
        
    }
    
}
