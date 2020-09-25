/*
 *Solucion a los ejercicios del Taller8
 * @author Mauricio Toro, Andrés Páez 
 * @version 1
 * 
 * @author Julian Ramirez,Samuel Villegas
 * @version 2
 */

import java.util.*;

public class Taller8 {
 
    /**
    * @param string es una cadena de texto que viene de este modo 3 4 5 * + o de esta manera 2 3 * 5 +
    * todo viene separado por espacios por lo que la funcion split.("") vendría muy bien para separarlos
    * Se intenta hacer el calculo por medio del metodo polaco posfijo
    * @return un entero resultado de la operación
    */
    public static int polaca (String string){
        Stack<Integer> numbers = new Stack<Integer>();
        String[] data = string.split(" ");
        for(String item : data){
                int res = 0;
                int temp;
                    switch(item){
                        case "+":
                            temp = numbers.pop();
                            res = numbers.pop() + temp;
                            numbers.push(res);
                            break;
                        case "-": 
                            temp = numbers.pop();
                            res = numbers.pop() - temp;
                            numbers.push(res);
                            break;
                        case "*":   
                            temp = numbers.pop();
                            res = numbers.pop() * temp;
                            numbers.push(res);
                            break;
                        case "/": 
                            temp = numbers.pop();
                            res = numbers.pop() / temp;
                            numbers.push(res);
                            break; 
                        default:
                            int num = Integer.parseInt(item);
                            numbers.push(num);
                    }
        }
        return numbers.pop();
    }

    /**
    * @param neveras es una estructura de datos para representar el almacen con las neveras
    * @param solicitudes es una estructura de datos para representar las solicitudes
    */
    public static void asignarSolicitudes(Stack<Nevera> listaNev, Queue<Solicitud> listaSol){		
	String res = "[";
		for(int k = listaSol.size();k>0;k--){
			Solicitud sol = listaSol.remove();		
			res+="('"+sol.getEntidad()+"' ,[";		
			for(int i = 0;i<sol.getCantidadNeveras();i++){	
				if(listaNev.size() == 0) break;
				if(i==sol.getCantidadNeveras()-1 || listaNev.size() == 1)
					res+=listaNev.pop().imprimirNevera();
				else res+=listaNev.pop().imprimirNevera()+",";					
			}			
			res+="])";		
			if(listaNev.size() == 0) break;
			else res+=",\n";
		}
		res+="]";	
		System.out.println(res);
	}
	
    /**
    * @param stack es una pila ya implementada que se crea en el test
    * Este método se encarga de poner la pila stack en orden inverso
    * Nota: recuerde que la funcion pop() no solo expulsa la última 
    * posición de una pila si no que tambien devuelve su valor.
    * @return una pila que haga el inverso de stack
    */
    public static Stack<Integer> inversa(Stack<Integer> stack){
        Stack<Integer>  a = new Stack<Integer>();
        while(!stack.empty()){
            a.push(stack.pop());
        } 
        return a;
    }
    
    
    /**
    * @param queue es una cola ya implementada que se crea en el test
    * Este método se encarga de atender a personas.
    * Nota: Se debe imprimir en consola a quién atiende y sacarlo de la cola
    * existe una función "pull" que hace el trabajo más fácil
    * 
    */
    public static void cola (Queue<String> queue){
        while(queue.peek() != null){
            System.out.println("Atiendo a "+queue.poll());
        }
    }
    
   
}
