import java.util.LinkedList;
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
        
    
        System.out.println("DFS: "+dfs(0,5,grafo)); 
        System.out.println("DFS: "+dfs(5,1,grafo));
        System.out.println("DFS: "+dfs(4,4,grafo));
        System.out.println("DFS: "+dfs(4,1,grafo));

        System.out.println("BFS: "+bfs(0,5,grafo));
        System.out.println("BFS: "+bfs(5,1,grafo));
        System.out.println("BFS: "+bfs(4,4,grafo));
        System.out.println("BFS: "+bfs(4,1,grafo));


        
        
        
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

    private static boolean bfs(Vertice inicio, Vertice fin, GrafoLista grafo, LinkedList<Vertice> valores, boolean [] visitados){
        if(inicio.valor == fin.valor) return true;       
        if(valores.isEmpty()) return false;
        valores.remove();
        visitados [inicio.valor] = true;
        LinkedList<Vertice> ady = grafo.getLista().get(inicio.valor);

        for(Vertice ver: ady){
            if(!visitados[ver.valor]) valores.add(ver);
        }      
        if(!valores.isEmpty()) {
            Vertice ver = valores.peek();
            return bfs(ver, fin, grafo, valores,visitados);         
        }
        return false;
    }
    public static boolean bfs(int inicio, int fin, GrafoLista grafo){
        LinkedList<Vertice> valores = new LinkedList<>();
        valores.add(new Vertice(inicio,0));
        boolean visitados [] = new boolean [grafo.getLista().size()];
        return bfs(new Vertice(inicio, 0), new Vertice(fin,0), grafo,valores,visitados);
    }
    
}

