/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package divisoresdenumeros;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Camilo D
 */
public class DivisoresDeNumeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     
        Scanner sc = new Scanner(System.in);
        BigInteger[] numero = new BigInteger [100];
        
        numero[0] = BigInteger.valueOf(1234567);
        numero[1] = BigInteger.valueOf(912337373);
        numero[2] = new BigInteger("93838383447");
        numero[3] = new BigInteger("839378363");
        numero[4] = new BigInteger("838483835");
        numero[5] = new BigInteger("1234393");
//        System.out.println("Digite numero del cual quiere saber los divisores: ");
//        numero = sc.nextBigInteger();

        float promedio = 0;
        long min = 999999;
        long max = 0;

            
        
     for (int i = 0; i < 5; i++) {
         for (int j = 0; j < 5; j++) {
//             System.out.println(numero[i]);
        System.out.println("los numero divisores de " + numero[i]+ " son:");
        BigInteger cont = BigInteger.ZERO;
        BigInteger m;
         long TInicio = 0, TFin =0; //Variables para determinar el tiempo de ejecución
         long [] tiempo = new long [5];
         TInicio = System.currentTimeMillis();
         
                while (!cont.equals(numero[i])) {
                    cont= cont.add(BigInteger.ONE);
//                        System.out.println(cont);
                    m = numero[i].mod(cont);
                    if (m.equals(BigInteger.ZERO)) {
                            System.out.println(cont);
                    }
                }
             
        TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
        tiempo[i] = TFin - TInicio; //Calculamos los milisegundos de diferencia
        System.out.println("Tiempo de ejecución en milisegundos: " + tiempo[i]);
        promedio = promedio + tiempo[i];
         
         if (min > tiempo[i]) {
             min = tiempo[i];
         }
         
         if (max < tiempo[i] ){
             max = tiempo[i];
         }
         
         
         }
            promedio = promedio / 5;
        System.out.println("El tiempo promedio es:" + promedio);
        System.out.println("El minimo tiempo fue: " + min);
        System.out.println("El maximo tiempo fue:" + max);
        
         
         
        }    
        
        
    }
    
}
























