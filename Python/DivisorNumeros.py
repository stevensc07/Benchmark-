#!/usr/bin/env python
# coding: utf-8

# In[12]:


import time
numero=[671265232]
tiempo = [0,0,0,0,0,0]
promedio=0
min=99999999999999
max=0
for x in numero:
	for y in range(1,6):
		start = time.time()
		print("Los numero divisores de ", x, " son: ")
		cont=0
		m=0
		while cont!=x:
			cont = cont + 1
			m = x % cont
			if m == 0:
				print(cont)
		stop = time.time()
		tiempo[y] = stop - start 
		promedio = promedio + tiempo[y]*1000
		print(tiempo[y]*1000)
	promedio = promedio / 5
	print("El promedio de tiempos es:", promedio)
for x in tiempo:
    print(x*1000)


# In[ ]:




