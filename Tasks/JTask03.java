package com.company;
import java.util.Scanner;

public class JTask03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chickens = sc.nextInt();
        int cows = sc.nextInt();
        int pigs = sc.nextInt();
        System.out.println(Legs(chickens,cows,pigs));
    }
    public static int Legs(int chickens, int cows, int pigs){
        int sum =chickens*2+cows*4+pigs*4;
        return sum;
    }
}
