#!/usr/bin/env python
# coding: utf-8

# In[8]:


import time
numero=[13,98]
tiempo = [0,0,0,0,0,0]
promedio=0
min=99999999999999
max=0

for x in numero:
	for y in range(1,6):
		start = time.time()
		print("Los numero divisores de ", x, " son: ")
		cont=0
		sw = 0
		m=0
		primo = 0
		while cont!=x and sw == 0:
			cont = cont + 1
			m = x % cont
			if m == 0:
				primo = primo +1                
				print(cont)
			if primo == 3:
				print("El numero no es primo")                
				sw = 1            
		stop = time.time()
		tiempo[y] = stop - start 
		promedio = promedio + tiempo[y]*1000
		print(tiempo[y]*1000)
		if sw == 0:
			print("El numero es primo")    
	promedio = promedio / 5
	print("El promedio de tiempos es:", promedio)


# In[ ]:




