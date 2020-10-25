package laboratorio4;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Cubo extends Mapa {

    boolean buscarCien = false;
    double diagonal;
    BigDecimal[] mitades = new BigDecimal[3];
    Mapa nodosInferiores[] = new Mapa[8];
    BigDecimal[] minimosMaximos = new BigDecimal[6];

    Cubo(BigDecimal[] minimosMaximos) {
        this.minimosMaximos = minimosMaximos;
        mitades[0] = (minimosMaximos[0].add(minimosMaximos[1])).divide(BigDecimal.valueOf(2));
        mitades[1] = (minimosMaximos[2].add(minimosMaximos[3])).divide(BigDecimal.valueOf(2));
        mitades[2] = (minimosMaximos[5].add(minimosMaximos[4])).divide(BigDecimal.valueOf(2));
        for (int i = 0; i < 8; i++) {
            nodosInferiores[i] = null;
        }
    }

    public int buscarCuadrante(Abeja abeja) {
        BigDecimal latAbe = abeja.latitud;
        BigDecimal lonAbe = abeja.longitud;
        BigDecimal altAbe = abeja.altura;

        boolean A = ((latAbe.doubleValue() >= minimosMaximos[0].doubleValue()) && (latAbe.doubleValue() <= mitades[0].doubleValue()));
        boolean B = ((latAbe.doubleValue() >= mitades[0].doubleValue()) && (latAbe.doubleValue() <= minimosMaximos[1].doubleValue()));

        boolean C = ((lonAbe.doubleValue() >= minimosMaximos[2].doubleValue()) && (lonAbe.doubleValue() <= mitades[1].doubleValue()));
        boolean D = ((lonAbe.doubleValue() >= mitades[1].doubleValue()) && (lonAbe.doubleValue() <= minimosMaximos[3].doubleValue()));

        boolean E = ((altAbe.doubleValue() >= minimosMaximos[4].doubleValue()) && (altAbe.doubleValue() <= mitades[2].doubleValue()));
        boolean F = ((altAbe.doubleValue() >= mitades[2].doubleValue()) && (altAbe.doubleValue() <= minimosMaximos[5].doubleValue()));

        if (A && C && E) {
            return 0;
        }
        if (B && C && E) {
            return 1;
        }
        if (A && D && E) {
            return 2;
        }
        if (B && D && E) {
            return 3;
        }
        if (A && C && F) {
            return 4;
        }
        if (B && C && F) {
            return 5;
        }
        if (A && D && F) {
            return 6;
        }
        if (B && D && F) {
            return 7;
        }

        return -1;
    }

    public BigDecimal[] crearLimites(int cuadrante) {
        BigDecimal minimosMaximos[] = new BigDecimal[6];

        switch (cuadrante) {
            case 0:
                minimosMaximos[0] = this.minimosMaximos[0];
                minimosMaximos[1] = this.mitades[0];
                minimosMaximos[2] = this.minimosMaximos[2];
                minimosMaximos[3] = this.mitades[1];
                minimosMaximos[4] = this.minimosMaximos[4];
                minimosMaximos[5] = this.mitades[2];
                break;
            case 1:
                minimosMaximos[0] = this.mitades[0];
                minimosMaximos[1] = this.minimosMaximos[1];
                minimosMaximos[2] = this.minimosMaximos[2];
                minimosMaximos[3] = this.mitades[1];
                minimosMaximos[4] = this.minimosMaximos[4];
                minimosMaximos[5] = this.mitades[2];
                break;
            case 2:
                minimosMaximos[0] = this.minimosMaximos[0];
                minimosMaximos[1] = this.mitades[0];
                minimosMaximos[2] = this.mitades[1];
                minimosMaximos[3] = this.minimosMaximos[3];
                minimosMaximos[4] = this.minimosMaximos[4];
                minimosMaximos[5] = this.mitades[2];

                break;
            case 3:
                minimosMaximos[0] = this.mitades[0];
                minimosMaximos[1] = this.minimosMaximos[1];
                minimosMaximos[2] = this.mitades[1];
                minimosMaximos[3] = this.minimosMaximos[3];
                minimosMaximos[4] = this.minimosMaximos[4];
                minimosMaximos[5] = this.mitades[2];
                break;
            case 4:
                minimosMaximos[0] = this.minimosMaximos[0];
                minimosMaximos[1] = this.mitades[0];
                minimosMaximos[2] = this.minimosMaximos[2];
                minimosMaximos[3] = this.mitades[1];
                minimosMaximos[4] = this.mitades[2];
                minimosMaximos[5] = this.minimosMaximos[5];
                break;
            case 5:
                minimosMaximos[0] = this.mitades[0];
                minimosMaximos[1] = this.minimosMaximos[1];
                minimosMaximos[2] = this.minimosMaximos[2];
                minimosMaximos[3] = this.mitades[1];
                minimosMaximos[4] = this.mitades[2];
                minimosMaximos[5] = this.minimosMaximos[5];

                break;
            case 6:
                minimosMaximos[0] = this.minimosMaximos[0];
                minimosMaximos[1] = this.mitades[0];
                minimosMaximos[2] = this.mitades[1];
                minimosMaximos[3] = this.minimosMaximos[3];
                minimosMaximos[4] = this.mitades[2];
                minimosMaximos[5] = this.minimosMaximos[5];
                break;
            case 7:
                minimosMaximos[0] = this.mitades[0];
                minimosMaximos[1] = this.minimosMaximos[1];
                minimosMaximos[2] = this.mitades[1];
                minimosMaximos[3] = this.minimosMaximos[3];
                minimosMaximos[4] = this.mitades[2];
                minimosMaximos[5] = this.minimosMaximos[5];

                break;

        }

        return minimosMaximos;
    }

    public void asignarAbeja(Abeja abeja) {
        if (buscarCien == true) {
            System.out.println("Cubo: { L1: ("+this.minimosMaximos[0]+","+this.minimosMaximos[1]+") L2: ("+
                this.minimosMaximos[2]+","+this.minimosMaximos[3]+") L3: ("+this.minimosMaximos[4]+","+this.minimosMaximos[5]+") ]"+
                    "} Abeja: { Latitud: ("+abeja.latitud+")Longitud: ("+abeja.longitud+") Altura: ("+abeja.altura+") } ");
            return;
        }

        int cuadrante = buscarCuadrante(abeja);
        if (cuadrante != -1) {
            if (nodosInferiores[cuadrante] == null) {
                nodosInferiores[cuadrante] = abeja;
            } else if (nodosInferiores[cuadrante] instanceof Abeja) {
                Abeja abejaAux = (Abeja) nodosInferiores[cuadrante];
                Cubo cuboAux = new Cubo(crearLimites(cuadrante));

                cuboAux.obtenerDiagonal();

                if (cuboAux.diagonal < 100) {
                    cuboAux.buscarCien = true;
                }
                cuboAux.asignarAbeja(abejaAux);
                cuboAux.asignarAbeja(abeja);
                nodosInferiores[cuadrante] = cuboAux;

            } else {
                Cubo cuboAux = (Cubo) nodosInferiores[cuadrante];
                cuboAux.asignarAbeja(abeja);
                nodosInferiores[cuadrante] = cuboAux;
            }
        }

    }

    public void obtenerDiagonal() {
        this.diagonal = Math.sqrt(Math.pow(minimosMaximos[1].doubleValue() - minimosMaximos[0].doubleValue(), 2) + Math.pow(minimosMaximos[3].doubleValue() - minimosMaximos[2].doubleValue(), 2) + Math.pow(minimosMaximos[5].doubleValue() - minimosMaximos[4].doubleValue(), 2));
    }

}
