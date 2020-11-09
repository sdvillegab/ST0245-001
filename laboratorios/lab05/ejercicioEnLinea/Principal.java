public class Principal {
    public static void main(String [] args){

        Grafo grafo = new Grafo(3);
        grafo.Insert(0, 1, 10);
        grafo.Insert(1, 2, 10);
        grafo.Insert(2, 0, 10);
        System.out.println(grafo.Bicoloreable());

        Grafo grafo2  = new Grafo(3);
        grafo.Insert(0, 1, 10);
        grafo.Insert(1, 2, 10);
        System.out.println(grafo2.Bicoloreable());

        Grafo grafo3 =  new Grafo(9);
        grafo.Insert(0, 1, 10);
        grafo.Insert(0, 2, 10);
        grafo.Insert(0, 3, 10);
        grafo.Insert(0, 4, 10);
        grafo.Insert(0, 5, 10);
        grafo.Insert(0, 6, 10);
        grafo.Insert(0, 7, 10);
        grafo.Insert(0, 8, 10);
        System.out.println(grafo3.Bicoloreable());


        

    } 

    
}
