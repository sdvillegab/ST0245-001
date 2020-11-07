package codigo;
import java.util.*;

class Main{
    
    public static GrafoLista cargarDatos(String archivo){
        Scanner  scan = new Scanner(new File(archivo));
        scan.nextLine();
        scan.nextLine();
        int numVertices = 0;
        while(!scan.nextLine().equals("Costo de Caminos Cortos. Formato: ID, ID, peso")){
            numVertices++;
        }
        GrafoLista g = new GrafoLista(n); 
        while(scan.hasNextLine()){
            String cadena = scan.nextLine();
            String[] cadenaSeparada = cadena.split(" ");
            int verticePartida = (int) cadenaSeparada[0];
            int verticeLlegada = (int) cadenaSeparada[1];
            int peso = (int) cadenaSeparada[2];
            g.agregarArco(peso, verticePartida, verticeLlegada);
        }
        return g;
    }

    public static void main(String args[]){
        GrafoLista g = ("dataset-ejemplo-U=11-p=1.1.txt");

    }
      /**
    * Algoritmo para asignar vehiculos compartidos 
    * Complejidad: ???, donde n son los duenos de vehiculos y la empresa
    *
    * @param  grafo  Un grafo que puede estar implementado con matrices o con listas de adyacencia
    * @return una lista de listas con la permutacion para cada subconjunto de la particion de duenos de vehiculo
    */
    public static LinkedList<LinkedList<Integer>> asignarVehiculos(GrafoLista grafo, float p){
        
    }
        
    /**
    * Metodo para escribir un archivo con la respuesta
    * Complejidad: Mejor y peor caso es O(n), donde n son los duenos de vehiculo y la empresa
    *
    * @param  permutacionParaCadaSubconjunto es una lista de listas con la permutacion para cada subconjunto de la particion de duenos de vehiculo
    */
    public static void guardarArchivo(LinkedList<LinkedList<Integer>> permutacionParaCadaSubconjunto,int numeroDePuntos, float p){
          final String nombreDelArchivo = "respuesta-ejemplo-U="+numeroDePuntos+"-p="+p+".txt";
          try {
             PrintWriter escritor = new PrintWriter(nombreDelArchivo, "UTF-8");
             for (LinkedList<Integer> lista: permutacionParaCadaSubconjunto){
                  for (Integer duenoDeVehiculo: lista)
                       escritor.print(duenoDeVehiculo + " ");
                  escritor.println();
             }             
             escritor.close();
          }
          catch(IOException ioe) {
              System.out.println("Error escribiendo el archivo de salida " + ioe.getMessage() );
          }  
    }
    
    public static void main(String[] args){
          //Recibir el numero de duenos de vehiculo y la empresa, y el valor de p por el main
          final int numeroDePuntos = args.length == 0 ? 205 : Integer.parseInt(args[0]);
          final float p = args.length < 2 ? 1.3f : Float.parseFloat(args[1]);
          // Leer el archivo con las distancias entre los duenos de los vehiculos y la empresa
          DigraphAM grafo = leerArchivo(numeroDePuntos, p);
          // Asignar los vehiculos compartidos
          long startTime = System.currentTimeMillis();
          LinkedList<LinkedList<Integer>> permutacionParaCadaSubconjunto = asignarVehiculos(grafo,p);
          long estimatedTime = System.currentTimeMillis() - startTime;
          System.out.println("El algoritmo tomo un tiempo de: "+estimatedTime+" ms");
          // Guardar en un archivo         
          guardarArchivo(permutacionParaCadaSubconjunto, numeroDePuntos, p);
        
   }

}