/**
 * Clase Valor
 * Esta clase es para definir un valor
 *(Un Valor es una respuesta a una variable,es decir un posible valor de una variable ) 

 * @author Julian Ramirez, Samuel Villegas
 * @version 15/11/2020
 */
public class Valor {
    private String variablePadre;
    private String nombreValor;
    private int nodoSi_cant1;
    private int nodoSi_cant0;
    private int nodoNo_cant1;
    private int nodoNo_cant0; 
    private float indiceGini;
    private int index;

    /**
     * Constructor de Valor,inicializa algunos atributos en 0,otros con
     * los valores recibidos por parametro,y uno en una constante 
     * 
     * @param nombreValor
     * @param variablePadre
     * @param index
     */
    public Valor(String nombreValor, String variablePadre,int index){
        this.nombreValor = nombreValor;
        this.variablePadre = variablePadre;
        nodoSi_cant1 = 0;
        nodoSi_cant0 = 0;
        nodoNo_cant1 = 0;
        nodoNo_cant0 = 0;
        indiceGini = 999999999;
        this.index = index;
    }
    /**
     * Retorna un String,que esel atributo nombreValor
     * @return this.nombreValor (El atributo nombreValor de esta misma clase)
     */
    public String getNombreValor(){
        return this.nombreValor;
    }

    /**
     *  Retorna un String,que esel atributo variablePadre
     * @return this.nombreValor (El atributo nombreValor de esta misma clase)
     */
    public String getVariablePadre() {
        return variablePadre;
    }

    /**
     *  Retorna un int,que es el atributo index
     * @return index (El atributo index de esta misma clase)
     */
    public int getIndex(){
        return this.index;
    }
    
    /**
     * Aumenta en 1 el atributo int nodoSi_cant1++
     */
    public void masNodoSi_cant1(){
        nodoSi_cant1++;
    }

    /**
     * Aumenta en 1 el atributo int nodoSi_cant0++
    */
    public void masNodoSi_cant0(){
        nodoSi_cant0++;
    }

    /**
     * Aumenta en 1 el atributo int nodoNo_cant1++
     */
    public void masNodoNo_cant1(){
        nodoNo_cant1++;
    }

    /**
     * Aumenta en 1 el atributo int nodoNo_cant0++
     */
    public void masNodoNo_cant0(){
        nodoNo_cant0++;
    }
    /**
     *  calcularIndiceGini() permite calcular el indice de gini,en base a
     * los atributos de esta misma clase,el resultado lo asigna al atributo
     * indiceGini
     * @return void
    */
    public void calcularIndiceGini(){
        float totalSi = nodoSi_cant0+nodoSi_cant1;
        float totalNo = nodoNo_cant0+nodoNo_cant1;
        if(totalSi==0 || totalNo==0){
            this.indiceGini=0;
            return;
        }    
        float p0Si, p1Si, p0No, p1No, igSi, igNo, igPon;
        p0Si = nodoSi_cant0/totalSi;
        p1Si = nodoSi_cant1/totalSi;
        p0No = nodoNo_cant0/totalNo;
        p1No = nodoNo_cant1/totalNo;
        igSi = 1 - ((p0Si*p0Si)+(p1Si*p1Si));
        igNo = 1 - ((p0No*p0No)+(p1No*p1No));
        igPon = ( (totalNo*igNo) +(totalSi*igSi) ) / (totalNo+totalSi) ;
        this.indiceGini = igPon;       
        //System.out.println(variablePadre+" == "+nombreValor+" ig: "+ igPon);
    }
    
    /**
     * Retorna un float,que es el atributo indiceGini
     * @return this.indiceGini (El atributo indiceGini de esta misma clase)
     */
    public float getIndiceGini(){
        return this.indiceGini;
    }

}
