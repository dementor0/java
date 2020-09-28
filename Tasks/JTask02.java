package com.company;
import java.util.Scanner;

public class JTask02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int h = sc.nextInt();
        System.out.println(area(a,h));
    }
    public static int area(int a, int h){
        int S;
        S= (a*h)/2;
        return S;
    }
}
