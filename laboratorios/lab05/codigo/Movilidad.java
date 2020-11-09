import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
public class Movilidad {
    
    static ArrayList<String[]> cargarDatos(String direccion){

        ArrayList<String []> respuesta = new ArrayList<>();
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(direccion),"utf-8"));
            String linea;
            int indice = 0;
            while((linea = in.readLine())!= null){
                if(indice!=0){
                    String partesLinea [] = linea.split(" "); 
                    respuesta.add(partesLinea);
                }
                indice++;         
            }
            
        } catch (Exception e) {
           System.out.println(e);
        }
        return respuesta;
    }

    static Grafo pasarGrafo(ArrayList<String[]> data, int cantVertices){
        Grafo respuesta = new Grafo(cantVertices);
        for(String [] filas: data){
            if(!filas[1].equals(filas[0])){
                respuesta.Insert(Integer.parseInt(filas[0])-1,Integer.parseInt(filas[1])-1, Integer.parseInt(filas[2]));
            }
       
        }
        return respuesta;
    }
    
    
    static Vertice verticeAlejado(Grafo grafo, boolean visitados[]){
        LinkedList<Vertice> vertices = grafo.lista.get(0); 
        Vertice verticeRes = new Vertice(-1, -1);
        int lejania = -1;
        for(Vertice vertice: vertices){
            if(vertice.peso>lejania && !visitados[vertice.indice]){
                lejania = vertice.peso;
                verticeRes = vertice;
            }
        }
        if(verticeRes.indice!=-1)visitados[verticeRes.indice] = true;      
        return verticeRes;
    }

    static void buscarParticionesAux(Grafo grafo,Vertice actual, int pesoRestante, ArrayList<Vertice> respuesta,boolean visitados []){       
        LinkedList<Vertice> verticesAdy =  grafo.lista.get(actual.indice);


        Collections.sort(verticesAdy);
        Vertice menor = null;

        for(Vertice vertice: verticesAdy){
            if(!visitados[vertice.indice] && vertice.indice!=0){
                menor = vertice;
                break;
            }
        }

        if(menor==null || (pesoRestante-menor.peso)<0){
            return;
        }

        pesoRestante-=menor.peso;
        visitados[menor.indice] = true;
        respuesta.add(menor);
      
        if(respuesta.size() == 4){
            int numero = grafo.lista.get(menor.indice).get(0).peso;
            if(pesoRestante-numero<0){
                pesoRestante+=menor.peso;
                visitados[menor.indice] = false;
                respuesta.remove(respuesta.size()-1);
            }
            return;
        }else{
            int sizeRespuesta = respuesta.size(); 
            buscarParticionesAux(grafo,menor, pesoRestante,respuesta, visitados);      
            if(respuesta.size() == sizeRespuesta){
                int numero = grafo.lista.get(menor.indice).get(0).peso;
                if(pesoRestante-numero<0) {
                    pesoRestante+=menor.peso;
                    visitados[menor.indice] = false;
                    respuesta.remove(respuesta.size()-1);
                }  
            }                    
        }
    }
    
    static void buscarParticiones(Grafo grafo){             
        ArrayList<ArrayList<Vertice>> particiones = new ArrayList<>();     
        boolean visitados [] = new boolean[grafo.cantVer];            
        Vertice ver = verticeAlejado(grafo,visitados);
        visitados[ver.indice] = true;
        while(ver.indice != -1){
            ArrayList<Vertice> vertice = new ArrayList<>();
            vertice.add(ver);
            buscarParticionesAux(grafo, ver, ver.peso+5, vertice, visitados);
            particiones.add(vertice);
            ver = verticeAlejado(grafo,visitados);
        }
    }


    static void inicio(String direccion, int cantVertices){
        ArrayList<String[]> data = cargarDatos(direccion);
        Grafo grafo = pasarGrafo(data,cantVertices);
        buscarParticiones(grafo);
    }

    

}
