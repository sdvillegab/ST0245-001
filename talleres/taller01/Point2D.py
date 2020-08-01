import math
class Point2D:
    def __init__(self,x,y):
        self.x = x
        self.y = y

    def getX(self):
        return self.x

    def getY(self):
        return self.y

    def redio(self):
        return math.sqrt(math.pow(self.x,2)+ math.pow(self.y,2))
       
    def TetaAngle(self):
        return math.atan(self.y/self.x)
    
    def Euclides(self,p):
        return math.sqrt(math.pow(p.getX()-self.x,2)+math.pow(p.getY()-self.y,2))
    
