"""
Created on Thu Aug 13 11:36:17 2020

@author: Samuel y Julian
"""
       
import csv

def leer_datos(fichero):
    path = open("codigo/data/"+fichero, encoding='utf-8')
    lista = csv.reader(path, delimiter=";")
    return lista

lista = leer_datos("0_test_balanced_5000.csv")
for i in lista:
    print(i)
