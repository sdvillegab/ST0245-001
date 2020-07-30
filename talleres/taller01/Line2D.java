public class Line2D {

    private Point begin;
    private Point end;

    public Line2D(Point begin , Point end ){
            this.begin = begin;
            this.end = end;
    }

    public String getPoints() {
        String res = "";
        int dy = (int)(end.getY()-begin.getY());
        int dx = (int)(end.getX()-begin.getX());

        if(dx!=0) {
            //Siplificación de fracción.
            if(dy==0) {
                dx = 1;
            }else{
                int n = max(Math.abs(dx),Math.abs(dy));
                dx=dx/n;
                dy=dy/n;
            }

            //Hallar puntos intermedios.
            int x=(int)(begin.getX()),y=(int)(begin.getY());
            res+="("+x+","+y+")";

            while(true){
                x=x+dx;
                y=y+dy;
                res+="("+x+","+y+")";
                if(x==end.getX() && y==end.getY()){
                    break;
                }
            }
        }else{
            res+="("+begin.getX()+","+begin.getY()+")"+"("+end.getX()+","+end.getY()+")";
        }

        return res;
    }

    public int max(int a, int b){
        int res = 0, max = 0;
        if(a<b){
            int temp = b;
            b = a;
            a = temp;
        }
        do{
            res = a%b;
            max = b;
            a = b;
            b = res;
        }while(res!=0);
        return max;
    }
}
