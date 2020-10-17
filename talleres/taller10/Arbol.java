
import javafx.util.Pair;

public class Arbol {

    public Nodo raiz;
    public int tamano;

    public Arbol() {
        this.raiz = null;
        tamano = 0;
    }

    private void Insertar(Pair<String, Integer> dato, Nodo nodo) {
        if (nodo.dato.getValue() < dato.getValue() && nodo.der == null) {
            nodo.der = new Nodo(dato);
            return;
        }
        if (nodo.dato.getValue() > dato.getValue() && nodo.izq == null) {
            nodo.izq = new Nodo(dato);
            return;
        }
        if (nodo.dato.getValue() == dato.getValue()) {
            return;
        }

        if (nodo.dato.getValue() > dato.getValue()) {
            Insertar(dato, nodo.izq);
        }
        if (nodo.dato.getValue() < dato.getValue()) {
            Insertar(dato, nodo.der);
        }
    }

    public void Insertar(Pair<String, Integer> dato) {
        if (raiz == null) {
            raiz = new Nodo(dato);
            return;
        } else {
            Insertar(dato, raiz);
        }
    }

    private boolean Buscar(Integer dato, Nodo nodo) {
        if (nodo != null) {
            if (nodo.dato.getValue() == dato) {
                return true;
            }

            if (nodo.dato.getValue() > dato) {
                return Buscar(dato, nodo.izq);
            }
            if (nodo.dato.getValue() < dato) {
                return Buscar(dato, nodo.der);
            }
        }
        
        return false;
        

    }

    public boolean Buscar(Integer dato) {
        return Buscar(dato, raiz);
    }

    private void mostrar(Nodo nodo) {
        System.out.println(nodo.dato);
        if (nodo.izq == null) {
            return;
        } else {
            mostrar(nodo.izq);
        }

        if (nodo.der == null) {
            return;
        } else {
            mostrar(nodo.der);
        }
    }

    public void mostrar() {
        mostrar(raiz);
    }

    public void generarCadena() {
        System.out.println("digraph G{​​");
        generarCadenaAux(raiz);
        System.out.println("}​​");
    }

    private void generarCadenaAux(Nodo nodo) {
        if (nodo.izq != null) {
            System.out.println(nodo.dato.getValue() + "->" + nodo.izq.dato.getValue());
        }
        if (nodo.der != null) {
            System.out.println(nodo.dato.getValue() + "->" + nodo.der.dato.getValue());
        }
        if (nodo.izq == null) {
            return;
        } else {
            generarCadenaAux(nodo.izq);
        }
        if (nodo.der == null) {
            return;
        } else {
            generarCadenaAux(nodo.der);
        }
    }

}
