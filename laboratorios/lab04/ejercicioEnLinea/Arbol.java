/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio4;

import javafx.util.Pair;

public class Arbol {

    public Nodo raiz;
    public int tamano;

    public Arbol() {
        this.raiz = null;
        tamano = 0;
    }

    private void Insertar(int dato, Nodo nodo) {
        if (nodo.dato < dato && nodo.der == null) {
            nodo.der = new Nodo(dato);
            return;
        }
        if (nodo.dato > dato && nodo.izq == null) {
            nodo.izq = new Nodo(dato);
            return;
        }
        if (nodo.dato == dato) {
            return;
        }

        if (nodo.dato > dato) {
            Insertar(dato, nodo.izq);
        }
        if (nodo.dato < dato) {
            Insertar(dato, nodo.der);
        }
    }

    public void Insertar(int dato) {
        if (raiz == null) {
            raiz = new Nodo(dato);
            return;
        } else {
            Insertar(dato, raiz);
        }
    }

    private boolean Buscar(Integer dato, Nodo nodo) {
        if (nodo != null) {
            if (nodo.dato == dato) {
                return true;
            }
            if (nodo.dato > dato) {
                return Buscar(dato, nodo.izq);
            }
            if (nodo.dato < dato) {
                return Buscar(dato, nodo.der);
            }
        }
        
        return false;
        

    }

    public boolean Buscar(Integer dato) {
        return Buscar(dato, raiz);
    }

    private void mostrarInorden(Nodo nodo) {
        System.out.println(nodo.dato);
        if (nodo.izq == null)return;
        else mostrarInorden(nodo.izq);
        
        if (nodo.der == null) return;
        else mostrarInorden(nodo.der);        
    }
    private void mostrarPosOrden(Nodo nodo) {
        if(nodo != null){
            mostrarPosOrden(nodo.izq);
            mostrarPosOrden(nodo.der);
            System.out.println(nodo.dato);
        } 
    }

    public void mostrarInorden() {
        mostrarInorden(raiz);
    }
    
    public void mostrarPosOrden(){
        mostrarPosOrden(raiz);
    }

    public void generarCadena() {
        System.out.println("digraph G{​​");
        generarCadenaAux(raiz);
        System.out.println("}​​");
    }

    private void generarCadenaAux(Nodo nodo) {
        if (nodo.izq != null) {
            System.out.println(nodo.dato + "->" + nodo.izq.dato);
        }
        if (nodo.der != null) {
            System.out.println(nodo.dato + "->" + nodo.der.dato);
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
