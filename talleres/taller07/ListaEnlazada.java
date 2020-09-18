/**
 * ListaEnlazada
 * 
 * Dado que tanto el metodo insert como remove son de
 * complejidad O(n),pueden ser utilizados con millones de abejas
 * 
 * @author Julian Ramirez,Samuel Villegas
 */
import java.lang.IndexOutOfBoundsException; // Usar esto cuando se salga el índice
// Una lista simplemente enlazada
public class ListaEnlazada {
        private Node first;
        private int size;

    public ListaEnlazada(){
        size = 0;
        first = null;	
    }

	/**
	 * Returns the node at the specified position in this list.
	 * @param index - index of the node to return
	 * @return the node at the specified position in this list
	 * @throws IndexOutOfBoundsException
	 */
	private Node getNode(int index) throws IndexOutOfBoundsException {
		if (index >= 0 && index < size) {
			Node temp = first;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
			return temp;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Returns the element at the specified position in this list.
	 * @param index - index of the element to return
	 * @return the element at the specified position in this list
         * @throws IndexOutOfBoundsException
	 */
	public int get(int index) throws IndexOutOfBoundsException {
		Node temp = getNode(index);
		return temp.data;
	}
        
        /**
         * Returns the amount of data entered into the list
         * @return the amount of data entered into the list
         * 
         */
        public int size(){
            return this.size;
        }
         /**
         * Allows inserting data in the last position
         * @param data data to enter
         */
        public void insert(int data){
            insert(data,size);
        }


	// Inserta un dato en la posición index
        public void insert(int data, int index) throws IndexOutOfBoundsException{
            if(index>=0 && index<=size){
                Node buscar = first;
                Node nuevo = new Node(data);
                if(index == 0){
                    this.first = nuevo;
                    first.next = buscar;
                    this.size++;
                    return;
                }
                int cont = 0;
                while(cont<index-1){
                    buscar = buscar.next;
                    cont++;
                }      
                Node aux = buscar.next;
                buscar.next = nuevo;
                nuevo.next=aux;    
                size++;
            }else{
                throw new IndexOutOfBoundsException();
            }   
        }

	// Borra el dato en la posición index
	public void remove(int index)throws IndexOutOfBoundsException{
		if (index >= size || index < 0)throw new IndexOutOfBoundsException();   
		if(index == 0 ){
		    first = first.next;
		    size--;
		    return;
		}
		Node buscar = first;
		int cont = 0;
		while(cont<index-1){
		    buscar = buscar.next;
		    cont++;
		}      
		Node aux = buscar.next;
		buscar.next = aux.next;
		size--;    
	}

	public void clear(){
	    this.first = null;
	    this.size = 0;
	}

	// Verifica si está un dato en la lista
	public boolean contains(int data){
	    int n = containsPos(data);
	    if(n==-1)return false;
	    else return true;
	}

	public int containsPos(int data){
	   Node buscar = first;
	   int cont = 0;
	   while(buscar != null){
	       if (buscar.data == data)return cont;
	       buscar = buscar.next;
	       cont++;
	   }
	   return -1;
	}

	private static int maximo(Node nodo, int n){
	    if(nodo == null) return n;
	    System.out.println(nodo.data);
	    if(nodo.data>n){
		n = nodo.data;
	    }
	    return maximo(nodo.next,n);
	}

	public static int maximo (ListaEnlazada lista){
	    return maximo(lista.first,-999999999);
	}

	private static boolean comparar(Node nodo1,Node nodo2){
	    if(nodo1.next == null) return true;
	    if(nodo1.data != nodo2.data) return false;
	    else return comparar(nodo1.next,nodo2.next);
	}

	public static boolean comparar(ListaEnlazada lista1, ListaEnlazada lista2){
	    if(lista1.size != lista2.size) return false;
	    else return comparar(lista1.first,lista2.first);
	}
	//Comprueba si la lista es un palindromo
	public boolean palindromo(){
		if(size<3)return false;
		
		Node aux = first;
		Node other = null;

		int n = 0;
		int middle = size/2;	
			
		while(aux != null){
			if(n == middle && size%2 != 0){
				aux = aux.next;			
				n++;
				continue;				
			}
			if(n >= middle){
				if(other.data != aux.data) return false;
				other = other.next;
			}else{
				Node opt = other;
				other = new Node(aux.data);
				other.next = opt;
			}	
			aux = aux.next;			
			n++;
		}
		return true;
	}


}
