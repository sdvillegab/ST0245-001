"""
Created on Thu Aug 13 11:36:17 2020

@author: Samuel y Julian
"""
import csv

def leer_datos(fichero):
    path = open("codigo/data/"+fichero)
    lista = csv.reader(path)

    for i in lista:
        print(i)    

    path.close()

leer_datos("0_train_balanced_15000.csv")
