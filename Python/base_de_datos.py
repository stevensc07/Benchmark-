import pymysql
import time

class Conexion:

    def __init__(self, servidor, usuario, clave, base_datos):
        self.db = pymysql.connect(servidor, usuario, clave, base_datos)
        self.cursor = self.db.cursor()
        print("Conexión a Base de datos exitosa")

    def ejecutar_sentencia(self, sql):
        self.cursor.execute(sql)
        return self.cursor

    def cerrar_conexion(self):
        self.db.close()
        print("Base de datos desconectada")

    def commit(self):
        self.db.commit()
        return

    def rollback(self):
        self.db.rollback()
        return

tiempo = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
promedio = 0
for x in range(1,101):
    print("----------------------------------------------------------------------------------------------------------")
    start = 0
    stop =0
    try:
        start = time.time()
        cx= Conexion('localhost', 'root', '', 'hoteles')
        sql = "SELECT  HOTELNAME, ADDRESS, STATE, PHONE, FAX, EMAILID, WEBSITE, TYPE, ROOMS, HOTELID FROM hotel_tourism"
        cursor = cx.ejecutar_sentencia(sql)
        datos = cursor.fetchall()
        for data in datos:
            print(data[0])
            print(data[1])
            print(data[2])
            print(data[3])
            print(data[4])
            print(data[5])
            print(data[6])
            print(data[7])
            print(data[8])
            print(data[9])
    except Exception as e:
        cx.rollback()
        print(e)
    finally:
        cx.cerrar_conexion()
    stop = time.time()
    tiempo[x] = stop - start
    promedio = promedio + tiempo[x]
    print("El tiempo de ejecucion es: ", tiempo[x]*1000)

promedio = promedio / 100
print ("El tiempo promedio es" , promedio*1000)

for x in tiempo:
    print(x*1000)
