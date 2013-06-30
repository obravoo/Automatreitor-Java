# -*- coding: cp1252 -*-
# -*- coding: utf-8 -*-

#Importamos las funciones necesarias
from Tkinter import *
from random import randrange

#Se crea un canvas todo gris
fen = Tk()
fen.wm_title("Analizador de Automatas - USS")
can = Canvas(fen, width=700, height=700, bg='white')
can.grid(row=1, column=0, columnspan=3)


#Se crea circulo
circulo = can.create_oval(90, 90, 200, 200, fill='gray')

#Etiqueta de Menú
Label(fen, text='Aqui Menu ').grid(row=0, column=0)

#Ejecutamos
fen.mainloop()
