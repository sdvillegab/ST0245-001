import java.util.LinkedList;

public class Vertice{
	
	String Id;
	String x;
	String y;
	String nombre;
	LinkedList<Arco> conexiones = new LinkedList<>();
	
	Vertice(String Id,String y, String x, String nombre){
		this.Id = Id;
		this.x = x;
		this.y = y;
		this.nombre = nombre;
	}
	
	String mostrarVertice(){
		return "Id: "+this.Id +" x: "+this.x+" y: "+this.y+" nombre: "+this.nombre +"["+mostrarConexiones()+"]";
	}
	String mostrarConexiones(){
		if(conexiones.isEmpty())return "Vacio";
		String res = "";
		
		for(Arco ar: conexiones){
			res+= "("+ar.conexion.Id+") ";
		}
		return res;
	}
	
}