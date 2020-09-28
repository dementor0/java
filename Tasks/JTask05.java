package com.company;
import java.util.Scanner;

public class JTask05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        op(N, a, b);
    }
    public static void op(int N,int a, int b) {
        if (a + b == N)
            System.out.println("сложение");
        else if (a - b == N)
            System.out.println("вычитание");
        else if (a * b == N)
            System.out.println("умножение");
        else if (a / b == N)
            System.out.println("деление");
    }
}
