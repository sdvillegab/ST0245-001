"subconjuntos.py sirve para encontrar las posibles combinaciones en la cadena s"
"Autores: Julian Ramirez, Samuel Villegas"

def subconjuntos(s):
        subconjuntosBase("", s)

def subconjuntosBase(base, s):
    if len(s) == 0:
        print(base)
    else:
        subconjuntosBase(base + s[0], s[1:])
        subconjuntosBase(base, s[1:])

def test_subconjuntos():
    print("Cadena abc:")
    subconjuntos("abc")
    print("Cadena Eafit:")
    subconjuntos("Eafit")
    print("Cadena Hola:")
    subconjuntos("Hola")

test_subconjuntos()