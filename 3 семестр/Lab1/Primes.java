package com.company;
import java.util.Scanner;
/*
Данная программа создана с целью нахождения простых чисел в нужном пользователю диапазоне чисел.
Scanner используется для ввода диапазона пользователем.
 */
public class Primes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int j=2;j<=n;j++) {
            if (isPrime(j) == true) {
                System.out.println(j);
            }
        }
    }
    public static boolean isPrime(int n){
        for(int i=2; i<n; i++){
            if(n % i==0)
                return false;
        }
        return true;
    }
}
