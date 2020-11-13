public class Valor {
    private String variablePadre;
    private String nombreValor;
    private int nodoSi_cant1;
    private int nodoSi_cant0;
    private int nodoNo_cant1;
    private int nodoNo_cant0; 
    private float indiceGini;
    private int index;


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

    public String getNombreValor(){
        return this.nombreValor;
    }

    public String getVariablePadre() {
        return variablePadre;
    }

    public int getIndex(){
        return this.index;
    }
    

    public void masNodoSi_cant1(){
        nodoSi_cant1++;
    }
    public void masNodoSi_cant0(){
        nodoSi_cant0++;
    }
    public void masNodoNo_cant1(){
        nodoNo_cant1++;
    }
    public void masNodoNo_cant0(){
        nodoNo_cant0++;
    }

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

    public float getIndiceGini(){
        return this.indiceGini;
    }

}
