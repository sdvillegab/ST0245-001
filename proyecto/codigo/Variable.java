/**
 * Clase Variable
 * Esta clase es para definir una variable
 * (Una variable puede ser cosiderada como una columna dentro de la tabla)
 * 
 * @author Julian Ramirez, Samuel Villegas
 * @version 15/11/2020
 */
import java.util.*;

public class Variable{
    private String nombreVariable;
    private TreeSet<String> recolectorDeValores = new TreeSet<String>();
    private Valor [] valores;
    int index;
    
    /**
     * Constructor de Variable: Recibe los argumentos 
     * nombreVariable e index,y asigna sus valores a los
     * atributos del mismo nombre
     * 
     * @param nombreVariable
     * @param index
     */
    public Variable(String nombreVariable, int index){
        this.nombreVariable = nombreVariable;
        this.index =  index;
    }

    /**
     * agregarValor() recibe un parametro y este
     * se añade al atributo de tipo TreeSet<String> recolectorDeValores
     * @param nombreValor
     */
    public void agregarValor(String nombreValor){
        recolectorDeValores.add(nombreValor);
    }

    /**
     *  Retorna el atributode esta clase valores,
     * este es de tipo Valor[]
     * 
     * @return valores
     */
    public Valor [] getValores(){
        return valores;
    }

    /**
     *  Retorna el atributode esta clase valores,
     * este es de tipo Valor[]
     * 
     * @return valores
     */
    public String getNombreVariable(){
        return nombreVariable;
    }

   /**
    * Recorre el TreeSet<String> valores y 
    * con los String que recibe va creando objetos
    * de tipo Valor,y los añade al atributo Valor[] valores
    */
    public void llenarValores(){
        valores = new Valor[recolectorDeValores.size()];
        int i = 0;
        for(String val: recolectorDeValores){
            valores [i] = new Valor(val, nombreVariable,index);
            i++; 
        }
    }

    /**
     * elimiminarValores() remueve todos los valores que hayan
     * en  el TreeSet<String> recolectorDeValores
     */
    public void eliminarValores(){
        recolectorDeValores.clear();
    }

}
