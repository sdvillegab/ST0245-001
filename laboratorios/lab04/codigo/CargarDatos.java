
package laboratorio4;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;

public class CargarDatos {
      
   public static ArrayList<Abeja> Cargar(){
        ArrayList<Abeja> abejas = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("ConjuntoDeDatosCon100abejas.txt"), "utf-8"));          
            String linea;
                        
            while ((linea = in.readLine())!=null) {
                String partesLinea [] = linea.split(",");
                if(Character.isAlphabetic(partesLinea[0].charAt(0))) continue;
                abejas.add(new Abeja(BigDecimal.valueOf(Double.parseDouble(partesLinea[0])*111325),
                        BigDecimal.valueOf(Double.parseDouble(partesLinea[1])*111325),
                        BigDecimal.valueOf(Double.parseDouble(partesLinea[2]))));
            } 
        }catch (Exception e) {
            System.out.println(e);
        }
        return abejas;
   }
   
   public static BigDecimal [] ObtenerMinMax(ArrayList<Abeja> abejas){
       BigDecimal minimosMaximos [] =  new BigDecimal[6];
       BigDecimal minLat = new BigDecimal(Double.MAX_VALUE);
       BigDecimal maxLat = new BigDecimal(-80);
       BigDecimal minLon = new BigDecimal(Double.MAX_VALUE);
       BigDecimal maxLon = new BigDecimal(Double.MIN_VALUE);
       BigDecimal minAlt = new BigDecimal(Double.MAX_VALUE);
       BigDecimal maxAlt = new BigDecimal(Double.MIN_VALUE);

       
       for(Abeja abe: abejas){
           if(minLat.compareTo(abe.latitud) == 1) minLat = abe.latitud;
           if(maxLat.compareTo(abe.latitud) == -1) maxLat = abe.latitud;
           
           if(minLon.compareTo(abe.longitud) == 1) minLon = abe.longitud;
           if(maxLon.compareTo(abe.longitud) == -1) maxLon = abe.longitud;
            
           if(minAlt.compareTo(abe.altura) == 1) minAlt = abe.altura;
           if(maxAlt.compareTo(abe.altura) == -1) maxAlt = abe.altura;
           
       }
       minimosMaximos[0] =  minLat;
       minimosMaximos[1] =  maxLat;
       minimosMaximos[2] =  minLon;
       minimosMaximos[3] =  maxLon;
       minimosMaximos[4] =  minAlt;
       minimosMaximos[5] =  maxAlt;
       
       return minimosMaximos;  
   }
   
   public static double obtenerDiagonalPrincipal(BigDecimal minimosMaximos[]){
       return Math.sqrt(Math.pow(minimosMaximos[1].doubleValue()-minimosMaximos[0].doubleValue(), 2)+Math.pow(minimosMaximos[3].doubleValue()-minimosMaximos[2].doubleValue(), 2)+Math.pow(minimosMaximos[5].doubleValue()-minimosMaximos[4].doubleValue(), 2));
   }
 
}
