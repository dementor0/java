package com.company;
import java.util.Scanner;

public class JTask10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        abcmath(a,b,c);
    }
    public static void abcmath(int a,int b,int c) {
        for (int i = 0; i < b; i++) {
            a = a + a;
        }
        if (a % c == 0) {
            boolean z = true;
            System.out.println(z);
        }
        else {
            boolean z = false;
            System.out.println(z);
        }
    }
}
