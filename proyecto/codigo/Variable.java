import java.util.*;


public class Variable{
    private String nombreVariable;
    private TreeSet<String> recolectorDeValores = new TreeSet<String>();
    private Valor [] valores;
    
    public Variable(String nombreVariable){
        this.nombreVariable = nombreVariable;
    }

    public void agregarValor(String nombreValor){
        recolectorDeValores.add(nombreValor);
    }

    public Valor [] getValores(){
        return valores;
    }

   
    public void llenarValores(){
        valores = new Valor[recolectorDeValores.size()];
        int i = 0;
        for(String val: recolectorDeValores){
            valores [i] = new Valor(val, nombreVariable);
            i++; 
        }
    }

}
