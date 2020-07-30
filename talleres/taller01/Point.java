public class Point {

    private double x,y,z;

    public Point(double x,double y,double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public double radio2D(){
        return Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
    }
    public double radio3D(){
        return Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2)+Math.pow(this.z,2));
    }
    public double TetaAngle(){
        return Math.atan(y/x);
    }
    public double Fi(){
        return Math.atan(radio2D()/z);
    }
    public double Euclides2D(Point p){
        return Math.sqrt(Math.pow(p.getX()-this.x,2)+Math.pow(p.getY()-this.y,2));
    }
    public double Euclides3D(Point p){
        return Math.sqrt(Math.pow(p.getX()-this.x,2)+Math.pow(p.getY()-this.y,2)+Math.pow(p.getZ()-this.z,2));
    }
}
