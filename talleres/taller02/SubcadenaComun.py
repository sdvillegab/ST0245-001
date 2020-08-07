"SubcadenaComun.py devuelve la longitud de del subcadena común más grande entre dos cadenas"
"Autores: Julian Ramirez,Samuel Villegas"
def  subcadena_comun(s1, s2, i, j):
    if i == 0 or j == 0 : return 0
    if s1[i-1] == s2[j-1] : return 1 + subcadena_comun(s1, s2, i-1, j-1)
    else : return max(subcadena_comun(s1, s2, i, j-1), subcadena_comun(s1, s2, i-1, j))

def test_subcadenaComun():
    a = "ABCDGH"
    b = "AEDFHR"
    print(subcadena_comun(a, b, len(a), len(b)))

test_subcadenaComun()
