package com.company;
import java.util.Scanner;

public class JTask04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double prob = sc.nextDouble();
        int prize = sc.nextInt();
        int pay = sc.nextInt();
        System.out.println(Cond(prob, prize, pay));
    }
    public static boolean Cond(double prob,int prize, int pay){
        boolean c;
        if (prob * prize > pay){
            c = true;
        }
        else {
            c = false;
        }
        return c;
    }
}
