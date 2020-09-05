import java.util.Arrays;

/**
 * La clase Coordenadas tiene la intención de representar un objeto que simule el comportamiento
 * de la clase ya implementada "ArrayList"
 * es claro que no se puede utilizar dicha estructura ya utilizada dentro de este ejercicio. 
 * Para más información de la clase ArrayList:
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
 * 
 * 
 * @author Mauricio Toro, Andres Paez
 * @version 1
 * 
 * @author Julian Ramirez,Samuel Villegas
 * @version 2
 */

public class Coordenadas {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int elements[]; 
    
    /**
    * El metodo constructor se utiliza para incializar
    * variables a valores neutros como 0 o null.
    * El contructor no lleva parámetros en este caso.
    */
    public Coordenadas() {
        size = 0;
        elements = new int[DEFAULT_CAPACITY];
    }     

    
    /**
    * Tiene la intención de retornar la longitud del objeto
    * @return longitud del objeto
    *
    * El size esta influenciado por las funciones add y del
    */
    public int size() {
        return size;
    }   //T(n)=O(1)
    
    /** 
    * @param e el elemento a guardar
    * Agrega un elemento e a la última posición de la lista
    *
    */
    public void add(int e) {      
        if(elements.length == this.size){
            int[] newVec = new int [elements.length*2];
            for(int i = 0; i<elements.length;i++){
                newVec [i] = elements[i];
            }
            newVec[elements.length] = e;
            elements = newVec;
            size++;
        }else{
            elements[size] = e;
            size++;
        }
    }//T(n) = O(n)
    
    
    /** 
    * @param i es un íncide donde se encuentra el elemento posicionado
    * Retorna el elemento que se encuentra en la posición i de la lista.
    *
    */
    public int get(int i) throws Exception{
        if (i >= size || i < 0)
            throw new Exception("index: " + i);

        return elements[i];
    }//T(n) = O(1)
    
    /**
    * @param index es la posicion en la cual se va agregar el elemento
    * @param e el elemento a guardar
    * Agrega un elemento e en la posición index de la lista
    *
    */
    public void add(int index, int e) throws Exception{
        if (index > size || index < 0) throw new Exception("index: " + index);     
        int [] newVec;    
        if(elements.length == this.size)newVec = new int [elements.length*2];          
        else newVec = new int [elements.length];
           
        boolean cam = false;
        for(int i = 0; i<size+1;i++ ){
            if(i == index){             
                  newVec[i] = e;
                  cam = true;
                  continue;
            }
            if(cam) newVec [i] = elements[i-1];
            else newVec [i] = elements[i];          
        }
        elements = newVec;
        size++;      
    }// T(n) = O(n) 

    /**
    * @param index es la posicion en la cual se va eliminar el elemento
    *
    * ELimina el elemento  en la posición index de la lista
    *
    */
    public void del(int index)throws Exception{
        if (index >= size || index < 0) throw new Exception("index: " + index);
        int[] newVec = new int [elements.length];
       
        boolean cam = false;
        for(int i = 0; i<size;i++ ){           
            if(i == index)cam = true;            
            if(i==size-1)newVec[i] = 0;
            else if(cam)newVec[i] = newVec[i] = elements[i+1];
            else newVec[i]= elements[i];       
        }
        elements = newVec;
        size--;
    }//T(n) = O(n)
}