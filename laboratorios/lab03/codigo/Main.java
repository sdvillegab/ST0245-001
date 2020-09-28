import java.util.*;
import java.io.*;


public class Main{
	
	public static void main(String [] args) throws IOException{
		/* Casos de prueba
		This_is_a_[Beiju]_text
		[[]][][]Happy_Birthday_to_Tsinghua_University
		asd[fgh[jkl
		asd[fgh[jkl[
		[[a[[d[f[[g[g[h[h[dgd[fgsfa[f
		asd[gfh[[dfh]hgh]fdfhd[dfg[d]g[d]dg
		*/
	
		leerDatos();

		
		
	}
	
	
	public static  void leerDatos() throws IOException{
		BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));		
		Queue<String> partes = new LinkedList<>();
				
		String parte = bufer.readLine();	
		while(!parte.equals("")){
			partes.add(parte);
			parte = bufer.readLine();
		}
		
		for(String p : partes){
			tecladoRoto(p);
			System.out.println("");
		}
	}
	
	
	public static void tecladoRoto(String cadena){ //complexity O(n+m) siendo n la longitud de la cadena y m la longitud de divisiones que se realizaron a la cadena.  
		
		char partes [] = cadena.toCharArray(); // O(n) 
		LinkedList<String> lista = new LinkedList<>(); //O(1)
		String paro = ""; //O(1)
		int limInf = 0; //O(1)
		boolean corchetes = false; //O(1) 
		
		for(int i =0;i<partes.length;i++){ //O(n)
			if(partes[i] != '[' && partes[i] != ']' ) corchetes = true; //O(1)
			
			if((partes.length-1 == i && corchetes && (partes[i] != '[' && partes[i] != ']' ))){//O(1)
				
				if(paro.equals("[")) lista.addFirst(cadena.substring(limInf,i+1)); //O(1)
				else if(paro.equals("]")) lista.addLast(cadena.substring(limInf,i+1)); //O(1)
				break; //O(1)
			}
				
						
			if(partes[i] == '[' || partes[i] == ']'){ //O(1)
				if(corchetes){ //O(1)
					if(lista.size() == 0 || paro.equals("") ||  paro.equals("[") ) //O(1)
						lista.addFirst(cadena.substring(limInf,i)); //O(1)
					else lista.addLast(cadena.substring(limInf,i)); //O(1)
					corchetes = false; //O(1)
				}
				limInf = i+1; //O(1)
				paro = String.valueOf(partes[i]);		//O(1)				
			}			
		}

		while(!lista.isEmpty()){ //O(m)
			System.out.print(lista.removeFirst());
		}
	}
	
}