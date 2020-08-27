"Aqui se encuentra la solucion de los ejercicios del taller 5"
import random

def insertionSort(arr):
    for i in range(len(arr)):
        for  j in range(1):
            if  arr[j] < arr[j-1]:
                temp = arr[j]
                arr[j] = arr[j-1]
                arr[j-1] =  temp

    return arr

def sumaArreglo(arr):
    suma = 0
    for i in range(len(arr)):
        suma = suma + arr[i]
    return suma

def  tablaMultiplicar(n):
    for i in range(1,n+1):
        for  j in range(10):
            print(str(i)+'*'+str(j)+'='+str(i*j))


def generarArreglo(n):
    arr = []
    for i in range(n):
        arr.append(random.randrange(0,100,1))
    return arr


print(sumaArreglo(generarArreglo(10)))