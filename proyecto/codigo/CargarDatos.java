
import java.io.*;

public class CargarDatos{

    private static Variable listaVariables[] = new Variable [30];
    private static String conjuntoDatos[][]; 
    private static String valorExito[];
    private static Valor giniMenor = new Valor("","");

    private static void cargar(String direccion, int cantidadData){
        conjuntoDatos = new String [cantidadData-1][30];
        valorExito = new String [cantidadData-1];
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(direccion), "utf-8"));          
            String linea;
            int indice = 0;
            
            while ((linea = in.readLine())!=null) {
                String partesLinea [] = linea.split(";");
                int j = 0;
                for(int i = 0;i<partesLinea.length;i++){
                   if(comprobarVariable(i) && indice == 0 && i!= partesLinea.length-1 ){
                        listaVariables[j] = new Variable(partesLinea[i]);
                        j++;
                    }else if(comprobarVariable(i) && indice != 0){
                        if(i == partesLinea.length-1){
                            valorExito[indice-1] = partesLinea[i];
                        }else{
                            conjuntoDatos[indice-1][j] = partesLinea[i];
                            j++;
                        } 
                    }
                }  
                
                indice++;
                
            } 
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    private static boolean comprobarVariable(int indice){
        if( (indice>3 && indice<11) ||(indice == 13) || (indice == 22) || (indice ==26) || (indice >27 && indice <33) 
        || (indice ==35) || (indice ==36) || (indice ==42) || (indice ==45) || (indice == 52) || (indice ==54) || (indice ==55)
        || (indice>64 && indice<73) || (indice ==77) ){
            return true;
        }
        return false;
    }

    private static void hallarValores(){
        
        
        for(int i = 0;i< conjuntoDatos.length; i++){
            
            for(int j = 0; j< conjuntoDatos[i].length;j++){
                
                listaVariables[j].agregarValor(conjuntoDatos[i][j]);
            }

        }

    }
    private static void llenarValores2(){
        for(Variable var: listaVariables){
            var.llenarValores();
        }  
    }

    

    private static void mostrar(){
        for(int i = 0;i<listaVariables.length; i++){
            Valor valores [] =  listaVariables[i].getValores();
            for(int j = 0;j<valores.length;j++){
                System.out.print(" "+valores[j].getNombreValor()+" ");
            }
            System.out.println("#############");      
        }
    }

    private static void ConteoProm(){
        
        for(int i = 0;i< conjuntoDatos.length; i++){
            String valor = valorExito[i];
            for(int j = 0; j< conjuntoDatos[i].length;j++){

                    Valor valores [] = listaVariables[j].getValores();
                    for(int k=0;k<valores.length;k++){
                                           
                            if(conjuntoDatos[i][j].equals(valores[k].getNombreValor())){
                                if(valor.equals("1")){
                                    valores[k].masNodoSi_cant1();
                                }else{
                                    valores[k].masNodoSi_cant0();
                                }
                            }else{
                                if(valor.equals("1")){
                                    valores[k].masNodoNo_cant1();
                                }else{
                                    valores[k].masNodoNo_cant0();
                                }
                            }
                    }                                       
                             
            }
        }
    }
    
    private static void SacarGini(){
        for (Variable val: listaVariables) {
            for (Valor var : val.getValores()) {
                var.calcularIndiceGini();
            }
        }   
    }
    
    private static Valor giniMenor(){
        
        for(int i = 0;i< conjuntoDatos.length; i++){
            
            String valor = valorExito[i];
            for(int j = 0; j< conjuntoDatos[i].length;j++){

                    Valor valores [] = listaVariables[j].getValores();
                    
                    for(int k=0;k<valores.length;k++){
                        if(giniMenor.getIndiceGini()>valores[k].getIndiceGini()){
                            giniMenor = valores[i]; 
                        }                        
                    }                                                             
            }
        }
        
        return giniMenor;
    }
   
    public static Valor inicio(String direccion, int cantidadData){
        cargar(direccion,cantidadData);
        hallarValores();
        llenarValores2();
        ConteoProm();
        SacarGini();
        return giniMenor();
    }
}
