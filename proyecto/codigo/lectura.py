"""
Created on Thu Aug 13 11:36:17 2020

@author: Samuel y Julian
"""
import csv
path = open("data/0_test_balanced_5000.csv")
lista = csv.reader(path)


for i in lista:
    print(i)    

path.close()
