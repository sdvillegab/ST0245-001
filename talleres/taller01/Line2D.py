class Line2D() :
    "The Class Line2D is a representation of line with begin point and end point"
    def _init_(self, begin, end ) :
        self.begin = begin;
        self.end = end;

    def getPoints(self) :
        res = ""
        dy = self.end.getY() - self.begin.getY()
        dx = self.end.getX() - self.begin.getX()

        if dx != 0 :
            "Simplificación de fracción."
            if dy == 0 :
                dx = 1
            else:
                n = max(abs(dx),abs(dy))
                dx = dx/n
                dy=dy/n

            "Hallar puntos intermedios."
            x = self.begin.getX()
            y = self.begin.getY()
            res += "("+x+","+y+")"

            while True :
                x = x + dx
                y = y + dy
                res += "("+x+","+y+")"
                if x == self.end.getX() and y == self.end.getY() :
                    break
        else :
          res += "("+self.begin.getX()+","+self.begin.getY()+")"+"("+self.end.getX()+","+self.end.getY()+")";

        return res;

    def max(self, a,  b) :
        res = 0
        max = 0
        if a < b :
            temp = b
            b = a
            a = temp

        while True :
            res = a % b
            max = b
            a = b
            b = res
            if res == 0:
                break
        return max

