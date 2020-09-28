import java.util.*;
import java.io.*;

public class Mapa{
	
	
	
	public static void main(String [] args){
		
		File archivo = new File("medellin.txt"); //(1)
		LinkedList<Vertice> vertices = new LinkedList<>(); //(1)
		boolean arcos = false; //(1)
		
		try{ //(1)
			Scanner entrada = new Scanner(archivo);
			String linea;
			
			while(entrada.hasNextLine()){ //(n)
				
				linea = entrada.nextLine(); //(1)
				String [] partes = linea.split(" "); //(1)
				
					
				
				if(partes[0].equals("Vertices.")) continue; //(1)
				
				if(partes[0].equals("Arcos.")){ //(1)
					arcos = true;
					continue;				
				}
						
						
				int comienzo = partes[0].length()+partes[1].length() //(1)
					+partes[2].length()+2;		
						
				if(!arcos){ //(1)
					if(partes.length >= 4) vertices.add(new Vertice(partes[0],partes[1],partes[2],linea.substring(comienzo))); //(1)
					else vertices.add(new Vertice(partes[0],partes[1],partes[2],""));	//(1)
				}else{

					Vertice verInicio = null; //(1)
					Vertice verFinal = null; //(1)
					
					for(Vertice ver: vertices){ //O(m) m = n-p siendo p la cantidad de arcos
							if(ver.Id.equals(partes[0]))verInicio = ver;	//(1)
							if(ver.Id.equals(partes[1]))verFinal = ver;		//(1)					
							if(verInicio!=null && verFinal!=null) break;    //(1)
					}
				
					if(partes.length >= 4) verInicio.conexiones.add(new Arco(verFinal,partes[2],linea.substring(comienzo)));	//(1)											
					else verInicio.conexiones.add(new Arco(verFinal,partes[2],""));	 //(1)
				}			
			}
					
		}catch(Exception e){ //(1)
			System.out.println(e.getMessage()); //(1)
		}
		
	}

}