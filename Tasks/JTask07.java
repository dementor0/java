package com.company;
import java.util.Scanner;

public class JTask07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(addUpTo(x));
    }
    public static int addUpTo(int x){
        int sum=0;
        for(int i=0; i<=x; i++){
            sum=sum+i;
        }
        return sum;
    }
}
