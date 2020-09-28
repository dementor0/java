package com.company;
import java.util.Scanner;

public class JTask01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(Mod(x,y));
    }
    public static int Mod(int a,int b){
        int c;
        c= a % b;
        return c;
    }
}

