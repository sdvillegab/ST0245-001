import math
class Point3D:
    def __init__(self,x,y,z):
        self.x = x
        self.y = y
        self.z = z
               
    def getX(self):
        return self.x

    def getY(self):
        return self.y   

    def getZ(self):
        return self.z

    def radio(self):
        return math.sqrt(math.pow(self.x,2)+math.pow(self.y,2)+math.pow(self.z,2))  
        
    def Fi(self):
        return math.atan(math.sqrt(math.pow(self.x,2)+ math.pow(self.y,2))/self.z)

    def TetaAngle(self):
        return math.atan(self.y/self.x)      

    def Euclides(self,p):
        return math.sqrt(math.pow(p.getX()-self.x,2)+math.pow(p.getY()-self.y,2)+math.pow(p.getZ()-self.z,2))


punto1 = Point3D(1,4,8)
punto2 = Point3D(3,6,9)
print(punto1.radio())
print(punto1.TetaAngle())
print(punto1.Fi())
print(punto1.Euclides(punto2))