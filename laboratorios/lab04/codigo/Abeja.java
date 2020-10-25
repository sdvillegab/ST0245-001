
package laboratorio4;

import java.math.BigDecimal;

public class Abeja extends Mapa{
   
    BigDecimal latitud;
    BigDecimal longitud;
    BigDecimal altura;
    int cuadrante;

    public Abeja(BigDecimal latitud, BigDecimal longitud, BigDecimal altura) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.altura = altura;
    }

  
}
