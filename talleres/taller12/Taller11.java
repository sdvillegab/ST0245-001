import java.util.ArrayList;
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
        
    
        System.out.println("DFS: "+dfs(0,4,grafo));
        System.out.println("DFS: "+dfs(5,1,grafo));
        System.out.println("DFS: "+dfs(4,4,grafo));
        System.out.println("DFS: "+dfs(4,1,grafo));
    }

    public static boolean dfs(int start, int finish, GrafoLista graph){
        boolean visited[] = new boolean[graph.size()];
        return dfsAux(start, finish, graph, visited);
    }

    public static boolean dfsAux(int start, int finish, GrafoLista graph, boolean[] visited){
        visited[start] = true;
        if(start == finish) return true;
        ArrayList<Integer> childs = graph.obtenerVerticesAsociados(start);
        for(Integer child : childs){
            if(!visited[child]){
                return dfsAux(child, finish, graph, visited);
            }
        }
        return false;
    }
}
