"Suma_grupo.py sirve para darnos a conocer si hay algun subconjunto el cual su suma = target "
"Autores: Julian Ramirez, Samuel Villegas"

def Suma_grupo(nums, target):
        return Suma_grupo1(0, nums, target)

def Suma_grupo1(start, nums, target):
        if start >= len(nums) : return target == 0
        return Suma_grupo1(start+1, nums, target - nums[start]) or Suma_grupo1(start+1, nums, target)


def test_Suma_grupo():
    a = Suma_grupo([2,4,8], 9)
    b = Suma_grupo([2,4,8], 8)
    c = Suma_grupo([10,2,2,5], 9)
    d = Suma_grupo([10,2,2,5], 17)
    if not(a) and b and c and d :
		    return True
    else : 
         return False


if test_Suma_grupo() == True : print("Ej2 Correcto")
else :
   print("Ej2 Incorrecto")