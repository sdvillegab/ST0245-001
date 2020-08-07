"Euclides.py sirve para calcular el MCD con el algoritmo de Euclides"
"Autores: Julian Ramirez, Samuel Villegas"

"Metodo para obtener el MCD"
def gcd_euclid(p, q):
    if p == 0: return q
    elif q == 0: return p
    else: return gcd_euclid(q, p % q)

"Pruebas para comprobar funcionamiento"
def test_gcd():
    a = gcd_euclid(12,36)
    b = gcd_euclid(8,12)
    c = gcd_euclid(72,108)
    d = gcd_euclid(162, 270)
    if a==12 and b==4 and c==36 and d==54:
	    return True
    return False
    
if test_gcd() == True : print("Ej1 Corrrecto")
else : print("Ej1 Incorrecto")