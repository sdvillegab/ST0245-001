/**
 * La clase Punto tiene la intención de representar coordenadas en el espacio y calcular su distancia.
 *
 * Codigo base : @author Mauricio Toro, Andres Paez
 * @version 1
 *
 * Codigo Completo: @autor Julian Ramirez,Samuel Villegas
 * @version 2
 */

public class Point {

    private double x,y,z;
     
    /**
     * Se inicializan los atributos de clase para 3D
     */
    public Point(double x,double y,double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Se inicializan los atributos de clase para 2D
     */    
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * Método para obtener la variable global x.
     *
     * @return eje coordenado x
     */
    public double getX() {
        return this.x;
    }

    /**
     * Método para obtener la variable global y.
     *
     * @return eje coordenado y
     */
    public double getY() {
        return this.y;
    }

    /**
     * Método para obtener la variable global z.
     *
     * @return eje coordenado z
     */
    public double getZ() {
        return this.z;
    }

    /**
     * Método para obtener el radio polar en 2D
     * 
     *
     * @return radio polar
     *
     * @see <a href="http://mathworld.wolfram.com/PolarCoordinates.html"> Ver más <a/>
     */
    public double radio2D(){
        return Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
    }

    /**
     * Método para obtener el radio polar en 3D
     * 
     *
     * @return radio polar
     *
     */
    public double radio3D(){
        return Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2)+Math.pow(this.z,2));
    }
     /**
     * Método para obtener el angulo Teta.
     *
     * @return angulo Teta.
     */
    public double TetaAngle(){
        return Math.atan(y/x);
    }

    /**
     * Método para obtener el angulo Fi.
     *
     * @return angulo Fi.
     */
    public double Fi(){
        return Math.atan(radio2D()/z);
    }

    /**
     * Método para obtener la distacia euclidiana en 2D. La distacia
     * euclidiana o euclídea es la distancia "ordinaria" (que se mediría con una regla) entre 
     * dos puntos de un espacio euclídeo, la cual se deduce a partir del teorema de Pitágoras.
     * En otras palabras es halla el radio polar a la diferencia entre los dos puntos.
     *
     *
     *
     * @return distancia euclidiana (radio polar a la diferencia de dos puntos)
     *
     * @param otro Este parámetro hace referencia a otro Punto en el espacio con es cual se desea
     * comparar el Punto desde el cual fue llamado.
     * @see <a href="http://mathworld.wolfram.com/Distance.html"> Ver más <a/>
     */
    public double Euclides2D(Point p){
        return Math.sqrt(Math.pow(p.getX()-this.x,2)+Math.pow(p.getY()-this.y,2));
    }

    /**
     * Método para obtener la distacia euclidiana en 3D.
     *
     * @return distancia euclidiana (radio polar a la diferencia de dos puntos)
     *
     * @param otro Este parámetro hace referencia a otro Punto en el espacio con es cual se desea
     * comparar el Punto desde el cual fue llamado.
     */
    public double Euclides3D(Point p){
        return Math.sqrt(Math.pow(p.getX()-this.x,2)+Math.pow(p.getY()-this.y,2)+Math.pow(p.getZ()-this.z,2));
    }
}
