import java.util.*;


public class Variable{
    private String nombreVariable;
    private TreeSet<String> recolectorDeValores = new TreeSet<String>();
    private Valor [] valores;
    int index;
    
    public Variable(String nombreVariable, int index){
        this.nombreVariable = nombreVariable;
        this.index =  index;
    }

    public void agregarValor(String nombreValor){
        recolectorDeValores.add(nombreValor);
    }

    public Valor [] getValores(){
        return valores;
    }
    public String getNombreVariable(){
        return nombreVariable;
    }

   
    public void llenarValores(){
        valores = new Valor[recolectorDeValores.size()];
        int i = 0;
        for(String val: recolectorDeValores){
            valores [i] = new Valor(val, nombreVariable,index);
            i++; 
        }
    }
    public void eliminarValores(){
        recolectorDeValores.clear();
    }

}
