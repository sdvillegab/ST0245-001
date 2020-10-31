import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;
public class GrafoLista {

    private LinkedList<LinkedList<Vertice>> lista;
    private int numVertices;
    private int numArcos;

    GrafoLista(int numVertices) {
        this.numVertices = numVertices;
        lista = new LinkedList<>();
        for (int i = 0; i < numVertices; i++) {
            lista.add(new LinkedList<>());
        }
    }

    private boolean agregarArco(Vertice indiceEtiqueta, int verticePartida) {

        int cont = 0;

        for (LinkedList list : lista) {
            if (cont == verticePartida) {
                list.add(indiceEtiqueta);
                numVertices++;
                return true;
            }
            cont++;
        }
        return false;
    }

    boolean agregarArco(int etiqueta, int verticePartida, int verticeLlegada) {
        if(agregarArco(new Vertice(verticeLlegada, etiqueta), verticePartida)){
            numArcos+=1;
            return true;
        }
        return false;
    }

    ArrayList<Integer> obtenerVerticesAsociados(int valorPartida) {
        ArrayList<Integer> verticesAsociados = new ArrayList<>();

        int cont = 0;
        for (LinkedList list : lista) {
            if (cont == valorPartida) {
                Iterator iter = list.iterator();
                while (iter.hasNext()) {
                    verticesAsociados.add((Integer) ((Vertice) iter.next()).valor);
                }
            }
            cont++;
        }

        return verticesAsociados;
    }

    int obtenerLongitud(int verticePartida, int verticeLlegada) {

        int cont = 0;
        for (LinkedList list : lista) {
            if (cont == verticePartida) {
                Iterator iter = list.iterator();
                while (iter.hasNext()) {
                    Vertice dato =(Vertice) iter.next();
                    if (dato.valor == verticeLlegada) {
                        return (dato.etiqueta);
                    }
                }
            }
            cont++;
        }
        return -1;
    }

    public int size(){
        return numArcos;
    }
    
    void mostrar() {
        int cont = 0;
        for (LinkedList list : lista) {
            Iterator iter = list.iterator();
            System.out.println(cont+": ");
            while (iter.hasNext()) {
                System.out.println(iter.next());
            }
            System.out.println("");
            cont++;
        }
    }

}
