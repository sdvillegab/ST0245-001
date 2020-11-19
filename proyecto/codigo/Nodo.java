/**
 * Clase Arbol
 * Esta clase es para definir la estructura de un nodo
 * 
 * @author Julian Ramirez, Samuel Villegas
 * @version 15/11/2020
 */
public class Nodo {
    Valor valor;
    Nodo der;
    Nodo izq;
    /**
     * Constructor de Nodo: Recibe un Valor y lo asigna
     * al atributo valor,los demás atributos los coloca nulos
     * @param valor
     */
    Nodo(Valor valor){
        this.valor = valor;
        this.der = null;
        this.izq = null;
    }
}
