public class Nodo {
    Valor valor;
    Nodo der;
    Nodo izq;

    Nodo(Valor valor){
        this.valor = valor;
        this.der = null;
        this.izq = null;
    }
}
