/**
 * Clase CargarDatos
 * En esta clase se ejecutan la mayoriade operaciones del programa,
 * como cargar los datos,construir el arból y realizar la validación
 * 
 * @author Julian Ramirez, Samuel Villegas
 * @version 15/11/2020
 */

import java.io.*;
import java.util.*;



public class CargarDatos{

/**
 * 
 * Motivo: Permite cargar los datos del txt a un ArrayList. 
 *   Retorno: ArrayList<String[]>
 *  Complejidad: O(m*n) m siendo la cantidad de estudiantes y n la cantidad de columnas 
 *   Metodos extra utilizados: comprobarVariable O(1)
 *                               verificarNota O(1)
 * @param direccion
 * @return res (ArrayList<String[]>)
 */
private static ArrayList<String[]> cargar(String direccion){
    ArrayList<String[]> res = new ArrayList<>();
    try {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("data/"+direccion), "utf-8"));
        String linea;
        int indiceFilas = 0;
        while ((linea = in.readLine()) != null) {
            String partesLinea[] = linea.split(";");
            if (indiceFilas != 0) {
                String columnas[] = new String[31];
                int indiceColumnas = 0;
                for (int i = 0; i < partesLinea.length; i++) {
                    if (comprobarVariable(i)) {
                        if ((i > 64 && i < 73))
                            columnas[indiceColumnas] = verificarNota(partesLinea[i]);
                        else if (partesLinea[i].isEmpty())
                            columnas[indiceColumnas] = "*";
                        else
                            columnas[indiceColumnas] = partesLinea[i];
                        indiceColumnas++;
                    }
                }
                res.add(columnas);
            } else {
                res.add(partesLinea);
            }
            indiceFilas++;
        }
    } catch (Exception e) {
        System.out.println(e);
    }
    return res;
}

/**
 *   Motivo: Permite comprobar que variables serán utilizadas en la creación del aŕbol. 
 *   Retorno: Boolean
 *   Complejidad: O(1) 
 *   Metodos extra utilizados: Ninguno
 *
 * @param indice
 * @return true or false (boolean)
 */
private static boolean comprobarVariable(int indice){
    if( (indice>3 && indice<11) ||(indice == 13) || (indice == 22) || (indice ==26) || (indice >27 && indice <33) 
    || (indice ==35) || (indice ==36) || (indice ==42) || (indice ==45) || (indice == 52) || (indice ==54) || (indice ==55)
    || (indice>64 && indice<73) || (indice ==77) ){
        return true;
    }
    return false;
}

/**
 * 
 *  Motivo: Permite cambiar el formato de las notas para los datos. 
 *   Retorno: String
 *   Complejidad: O(1) 
 *   Metodos extra utilizados: Ninguno
 * 
 * @param cadena
 * @return (String) [Una cadena que señala el intervalo en
 *                   el que se encuentra la nota que se recibe 
 *                   como cadena]
 */
private static String verificarNota(String cadena){
    if(cadena.isEmpty()) return "";
    float numero = Float.parseFloat(cadena);

    if(numero>0 && numero<21){
        return "Mayor a 0 y menor a 21";
    }
    if(numero>20 && numero<41){
        return "Mayor a 20 y menor a 41";
    }
    if(numero>40 && numero<61){
        return "Mayor a 40 y menor a 61";
    }
    if(numero>60 && numero<81){
        return "Mayor a 60 y menor a 81";
    }
    if(numero>80 && numero<101){
        return "Mayor a 80 y menor a 101";
    }
    return "";
}

/*  
    Motivo: Permite asignar las variables que se van a validar
    Retorno: Variable []
    Complejidad: O(k) siendo k el numero de variables 
    Metodos extra utilizados: comprobarVariable O(1)
*/

/**
 *  Motivo: Permite asignar las variables que se van a validar
 *   Retorno: Variable []
 *   Complejidad: O(k) siendo k el numero de variables 
 *   Metodos extra utilizados: comprobarVariable O(1)
 * 
 * @param data
 * @return variables (Variable[]) 
 */
private static Variable[] asignarVariables(ArrayList<String[]> data){       
    String [] partesLinea = data.remove(0);
    Variable [] variables = new Variable[30];
    int j = 0;
    for(int i = 0;i<partesLinea.length;i++){
        if(i!=partesLinea.length-1 && comprobarVariable(i)){
            variables [j] =  new Variable(partesLinea[i], j); 
            j++;
        }
    }
    return variables;      
} 

/**
 * Motivo: Permite asignar los diferentes valores que se van a validar como nodos del arbol (Las variables pueden tener 1 o más valores),
 *   si no encuentra variables quiere decir que para el conjunto de datos a validar no se encuentran valores disponibles. 
 *   Retorno: Boolean
 *   Complejidad: O(m*k) siendo m la cantidad de estudiantes, k la cantidad de variables, o datos del estudiante.
 *   Metodos extra utilizados: contains(Hashset) O(1) 
 *                               agregarValor(Variable) O(1)
 *                               llenarValores(Variable) O(v) siendo la cantidad de valores de una variable, 
 *                               este valor es mínimo podemos tomarlo como constante.
 * 
 * @param data
 * @param valoresEvaluados
 * @param variables
 * @return true or false (boolean)
 */
private static boolean pasarValores(ArrayList<String[]> data, HashSet<String> valoresEvaluados, Variable[] variables){         
    int p = 0;    
    for(String [] fila: data){
        int i=0;
        String valorFinal = fila[30];
        for(String columna: fila){
            if(i != 30){
                if(!(valoresEvaluados.contains(variables[i].getNombreVariable()+columna))) {
                    variables[i].agregarValor(columna);   
                    p++;          
                }
            }                  
            i++;  
        }   
    }  
    if(p==0) return false;
    for(Variable variable :variables){
        variable.llenarValores();
    }
    return true;
}

/**
 * ConteoProm Permite realizar el conteo en los valores sobre la cantidad que 0 y 1 que cumplen el valor, y la cantidad de 0 y 1 que no la cumplen, para despues 
 * hallar el gini. 
 * O(m*k*v) m => numero de estudiantes o filas, k numero de variables o columnas, v el numero de valores de la varible respectiva
 * 
 * @param data
 * @param valoresEvaluados
 * @param variables
 */
private static void ConteoProm(ArrayList<String[]> data, HashSet<String> valoresEvaluados, Variable[] variables){   
    int i = 0;
    for(String[] fila: data){
        int j = 0;
        for(String columna: fila){
            if(j!=30){
                Valor [] valores = variables[j].getValores();
                String valorFinal = fila[30];              
                for(int k = 0;k<valores.length;k++){
                    if(!(valoresEvaluados.contains(variables[j].getNombreVariable()+columna))){
                        if(columna.equals(valores[k].getNombreValor())){
                            if(valorFinal.equals("1")){
                                valores[k].masNodoSi_cant1();
                            }else{
                                valores[k].masNodoSi_cant0();
                            }
                        }else{
                            if(valorFinal.equals("1")){
                                valores[k].masNodoNo_cant1();
                            }else{
                                valores[k].masNodoNo_cant0();
                            }
                        }
                    }     

                }
            }
            j++;
        }
        i++;
    }
    if(i == 0) {
        System.out.println("");
    }
}

/**
 * crearArbol() permite construir el arbol de desicion
 * 
 * @param data
 * @param valoresEvaluados
 * @param nodo
 * @param variables
 */
public static void crearArbol(ArrayList<String []> data,HashSet<String> valoresEvaluados,Nodo nodo, Variable [] variables){ 
    final int CANTIDAD_VALORES = 198;
    
    ArrayList<String[]> SI = new ArrayList<>();
    ArrayList<String[]> NO = new ArrayList<>();

    for(String [] filas: data){      
        if(filas[nodo.valor.getIndex()].equals(nodo.valor.getNombreValor())) SI.add(filas);
        else NO.add(filas);    
    }


    if(SI.size()<10){
        int n = comprobarDatoMayor(SI);
        if(n == 1) nodo.der = new Nodo(new Valor("1", "Terminal", -1));
        else nodo.der = new Nodo(new Valor("0", "Terminal", -1));
    }
    if(NO.size()<10){
        int n = comprobarDatoMayor(NO);
        if(n == 1) nodo.izq = new Nodo(new Valor("1", "Terminal", -1));
        else nodo.izq = new Nodo(new Valor("0", "Terminal", -1));
    } 
    
    Variable variableSi []= new Variable[30];
    Variable variableNo []= new Variable[30];
    HashSet<String> valoresEvaluadoSi = new HashSet<>();
    HashSet<String> valoresEvaluadoNo = new HashSet<>();

    for(int i = 0;i<variables.length;i++){       
        variableSi [i] = new Variable(variables[i].getNombreVariable(), i);
        variableNo [i] = new Variable(variables[i].getNombreVariable(), i);
    }
    for(String valoresEva: valoresEvaluados){
        valoresEvaluadoSi.add(valoresEva);
        valoresEvaluadoNo.add(valoresEva);
    }

    if(nodo.izq==null || !nodo.izq.valor.getVariablePadre().equals("Terminal")){

        if(!pasarValores(NO, valoresEvaluadoNo, variableNo)){
            int n = comprobarDatoMayor(NO);
            if(n == 1) nodo.izq = new Nodo(new Valor("1", "Terminal", -1));
            else nodo.izq = new Nodo(new Valor("0", "Terminal", -1));
        }else{       

            ConteoProm(NO, valoresEvaluadoNo, variableNo);
            calcularGini(variableNo);
            Valor valor =  giniMenor(variableNo);

            valoresEvaluadoNo.add(valor.getVariablePadre()+valor.getNombreValor());
            
            if(valoresEvaluadoNo.size() == CANTIDAD_VALORES){
                int n = comprobarDatoMayor(NO);
                if(n == 1) nodo.izq = new Nodo(new Valor("1", "Terminal", -1));
                else nodo.izq = new Nodo(new Valor("0", "Terminal", -1));

            }else if(comprobarMismoTipo(NO)){
                
                if(NO.get(0)[30].equals("1")) nodo.izq = new Nodo(new Valor("1", "Terminal", -1));
                else nodo.izq = new Nodo(new Valor("0", "Terminal", -1));

            }else{
                nodo.izq =  new Nodo(valor);
                crearArbol(NO, valoresEvaluadoNo, nodo.izq, variableNo);
            }

        }      
    }
    if(nodo.der==null || !nodo.der.valor.getVariablePadre().equals("Terminal")){
        if(!pasarValores(SI, valoresEvaluadoSi, variableSi)){
            int n = comprobarDatoMayor(SI);
            if(n == 1) nodo.der = new Nodo(new Valor("1", "Terminal", -1));
            else nodo.der = new Nodo(new Valor("0", "Terminal", -1));
        }else{
            ConteoProm(SI, valoresEvaluadoSi, variableSi);
            calcularGini(variableSi);
            Valor valor =  giniMenor(variableSi);
            valoresEvaluadoSi.add(valor.getVariablePadre()+valor.getNombreValor());

            if(valoresEvaluadoSi.size() == CANTIDAD_VALORES){

                int n = comprobarDatoMayor(SI);
                if(n == 1) nodo.der = new Nodo(new Valor("1", "Terminal", -1));
                else nodo.der = new Nodo(new Valor("0", "Terminal", -1));

            }else if(comprobarMismoTipo(SI)){

                if(SI.get(0)[30].equals("1")) nodo.der = new Nodo(new Valor("1", "Terminal", -1));
                else nodo.der = new Nodo(new Valor("0", "Terminal", -1));

            }else{
                nodo.der =  new Nodo(valor);
                crearArbol(SI, valoresEvaluadoSi, nodo.der, variableSi);
            }
        }    
    } 

}

/**
 * comprobarMismoTipo Permite saber si la data tiene todos los resultados iguales, es decir, si el exito de todos los datos es 1 o 0.
 * O(m) m siendo el numero de estudiantes o filas
 * 
 * @param data
 * @return
 */
public static boolean comprobarMismoTipo(ArrayList<String []> data){
    String i = data.get(0)[30];
    for(String [] filas: data){
        if(!filas[30].equals(i)) return false;
    }
    return true;
}
    
/**
 * comprobarDatoMayor Permite saber que valor de exito se repite mas, ya sea 1 o 0. 
 * O(m) m siendo el numero de estudiantes o filas
 * 
 * @param data
 * @return (int)
 */
public static int comprobarDatoMayor(ArrayList<String []> data){
    int cont1 = 0;
    int cont0 = 0;
    for(String [] filas: data){
        if(filas[30].equals("1")) cont1++;
        else cont0++;
    }
    if(cont1>cont0) return 1;
    else return 0;
}

/**
 * giniMenor devuelve el Valor con el que se obtiene un indice de gini menor
 * O(k*v) k siendo el numero de columnas o variables, y v siendo numero de valores
 * 
 * @param variables
 * @return valorRetorno (Valor)
 */
private static Valor giniMenor(Variable[] variables){
    Valor valorRetorno =  new Valor(" ","",-1);
    for(Variable var:variables){
        for(Valor val: var.getValores()){
            if(valorRetorno.getIndiceGini()>val.getIndiceGini()){
                valorRetorno = val;
            }
        }
    }

    return valorRetorno;
}

/**
 * calcularGini Realiza iteraciones por todos los valores existentes en kas variables y llama al metodo calcularIndiceGini el cual calcula el indice del valor actual.
 * O(k*v) k siendo el numero de columnas o variables, y v siendo numero de valores
 * 
 * @param variables
 */
private static void calcularGini(Variable[] variables){
    for(Variable var: variables){
        for(Valor val: var.getValores()){
            val.calcularIndiceGini();
        }
    }
}

/**
 * 
 * @param direccion
 * @return arbol (Arbol) [Devuelve el arbol de desición ya construido]
 */
public static Arbol Inicio(String direccion){
    ArrayList<String[]> data = cargar(direccion);

    Variable variables [] = asignarVariables(data);

    HashSet<String> valoresEvaluados = new HashSet<>();
    pasarValores(data, valoresEvaluados, variables);
    ConteoProm(data,valoresEvaluados , variables);
    calcularGini(variables);


    Valor valor =  giniMenor(variables);

    Arbol arbol = new Arbol();
    arbol.raiz = new Nodo(valor);

    valoresEvaluados.add(valor.getVariablePadre()+valor.getNombreValor());
    
    crearArbol(data, valoresEvaluados, arbol.raiz, variables);

    return arbol;
}

/**
 * Test realiza la validación,y devuelve los porecentajes de acierto,
 * fallo y margen de error
 * 
 * @param direccion
 * @param arbol
 * @return porcentajes (double[])
 */
public static double[] Test(String direccion, Arbol arbol){
    ArrayList<String []> data = cargar(direccion);
    int contAciertos = 0;
    int contFallos = 0;
    double porcentajes[] =  new double[2];
    for(String [] fila: data){
        String resultado = recorridoArbol(fila, arbol.raiz);
        if(resultado.equals(fila[30])) contAciertos++;
        else contFallos++;
    }
    porcentajes [0] = (contAciertos*100)/ data.size();  
    porcentajes [1] = (contFallos*100)/ data.size(); 
    return porcentajes;
}

/**
 * recorridoArbol Permite recorrer el arbol con valores de un estudiante especifico, para retornar la predicción 
 * @param fila
 * @param nodo
 * @return (String)
 */
public static String recorridoArbol(String [] fila,Nodo nodo){
    if(nodo.valor.getVariablePadre().equals("Terminal")) return nodo.valor.getNombreValor();
    if(fila[nodo.valor.getIndex()].equals(nodo.valor.getNombreValor())){
        return recorridoArbol(fila,nodo.der);
    }else{
        return recorridoArbol(fila,nodo.izq);
    }
}

}
