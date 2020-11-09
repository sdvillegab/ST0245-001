import java.util.LinkedList;



public class Grafo{

    LinkedList<LinkedList<Vertice>> lista = new LinkedList<>();
    int cantVer;
    int cantArc;

    Grafo(int cantVer){
        this.cantVer = cantVer;
        this.cantArc = 0;
        for(int i = 0;i<cantVer;i++){
            lista.add(new LinkedList<Vertice>());
        }
    }


    private boolean InsertAux(int inicio, int fin,int peso){
        int i = 0; 
        for(LinkedList<Vertice> lis: lista){
            if(i == inicio){
                for(Vertice ver: lis){
                    if(ver.indice == fin){
                        ver.peso = peso;
                        return true;
                    }
                }
                lis.add(new Vertice(fin,peso));
                cantArc++;
                return true;
            }
            i++;
        }
        return false;
    }

    boolean Insert(int inicio, int fin, int peso){
        return InsertAux(inicio, fin, peso) && InsertAux(fin,inicio, peso);
    }

    private boolean Bicoloreable(Color visitados [],  LinkedList<Integer> orden){
        if(orden.size() == 0) return true;

        int actual = orden.remove();
        Color otroColor;
        if(visitados[actual].equals(Color.NEGRO)) otroColor = Color.VERDE;
        else otroColor = Color.NEGRO;


        int i = 0;
        for(LinkedList<Vertice> lis: this.lista){
            if(i == actual){
                for(Vertice ver:lis){
                    if(visitados[ver.indice] == null){
                        visitados[ver.indice] = otroColor;
                        orden.add(ver.indice);
                    }else{ 
                        if(!visitados[ver.indice].equals(otroColor))
                            return false;                 
                    }
                }
            }
            i++;
        }

        return Bicoloreable(visitados, orden);   
    }

    public boolean Bicoloreable(){
        LinkedList<Integer> orden = new LinkedList<>();
        orden.add(0);
        Color [] visitados =  new Color[cantVer];
        visitados[0] = Color.NEGRO;
        return Bicoloreable(visitados,orden);
    }

    
    


}