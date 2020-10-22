package taller11;

import java.util.LinkedList;
import java.util.ArrayList;
import javafx.util.Pair;
import java.util.Iterator;

public class GrafoLista {

    private LinkedList<LinkedList<Pair<Integer, Integer>>> lista;
    private int numVertices;
    private int numArcos;

    GrafoLista(int numVertices) {
        this.numVertices = numVertices;
        lista = new LinkedList<>();
        for (int i = 0; i < numVertices; i++) {
            lista.add(new LinkedList<>());
        }
    }

    private boolean agregarArco(Pair<Integer, Integer> indiceEtiqueta, int verticePartida) {
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
        return agregarArco(new Pair(verticeLlegada, etiqueta), verticePartida);
    }

    ArrayList<Integer> obtenerVerticesAsociados(int valorPartida) {
        ArrayList<Integer> verticesAsociados = new ArrayList<>();

        int cont = 0;
        for (LinkedList list : lista) {
            if (cont == valorPartida) {
                Iterator iter = list.iterator();
                while (iter.hasNext()) {
                    verticesAsociados.add((Integer) ((Pair) iter.next()).getKey());
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
                    Pair<Integer,Integer> dato =(Pair<Integer,Integer>) iter.next();
                    if (dato.getKey() == verticeLlegada) {
                        return (dato.getValue());
                    }
                }
            }
            cont++;
        }
        return -1;
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
