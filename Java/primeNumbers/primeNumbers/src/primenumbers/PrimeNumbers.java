/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumbers;

import java.math.BigDecimal;
import static java.math.BigDecimal.ROUND_HALF_UP;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author William
 */
public class PrimeNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el numero del cual desea conocer si es primo ");
        BigInteger num = sc.nextBigInteger();
        long promedio =0;
        long min = 999999999;
        long max = 0;
        for (int i = 0; i < 5; i++) {
   
            long TInicio = 0, TFin =0; //Variables para determinar el tiempo de ejecución
             long [] tiempo = new long [5];
            boolean primo = isPrime(num);

            if (primo) {
                System.out.println("El número es primo");
            }else{
                System.out.println("No es un numero primo");
            }
            TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
            tiempo[i] = TFin - TInicio; //Calculamos los milisegundos de diferencia
            System.out.println("Tiempo de ejecución en milisegundos: " + tiempo[i]);
            promedio = promedio + tiempo[i];
              if (i == 0) {
                min = tiempo[0];
                 }
            
            
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
    
    public static boolean isPrime(BigInteger num){
        BigInteger dos = BigInteger.ONE.add(BigInteger.ONE);
    if ( num.compareTo(dos) ==1 && num.mod(dos).equals(BigInteger.ZERO) ) {
        System.out.println(num + " is not prime");
        return false;
    }
    BigDecimal top = new BigDecimal(num);
    top = sqrt(top,2).add(BigDecimal.ONE);
    BigDecimal cont = BigDecimal.ONE.add(BigDecimal.ONE.add(BigDecimal.ONE)); 
    BigInteger conti = BigInteger.ONE.add(BigInteger.ONE.add(BigInteger.ONE));
    BigDecimal vdos = BigDecimal.ONE.add(BigDecimal.ONE);
    while(cont.compareTo(top)<0){
        if (num.mod(conti).equals(BigInteger.ZERO)) {
            return false;
        }
    cont = cont.add(vdos);
    }
    System.out.println(num + " is prime");
    return true; 
}
    
    public static BigDecimal sqrt(BigDecimal A, final int SCALE) {
    BigDecimal x0 = new BigDecimal("0");
    BigDecimal x1 = new BigDecimal(Math.sqrt(A.doubleValue()));
    BigInteger num = BigInteger.ONE.add(BigInteger.ONE);
    BigDecimal TWO = new BigDecimal(num);
    while (!x0.equals(x1)) {
        x0 = x1;
        x1 = A.divide(x0, SCALE, ROUND_HALF_UP);
        x1 = x1.add(x0);
        x1 = x1.divide(TWO, SCALE, ROUND_HALF_UP);

    }
    return x1;
}


}



