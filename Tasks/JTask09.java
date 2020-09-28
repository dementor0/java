package com.company;
import java.util.Scanner;

public class JTask09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(sumOfCubes(arr,n));
    }
    public static double sumOfCubes(int[] arr,int n){
        double sum=0;
        for(int i=0; i< n; i++){
            sum= sum+ Math.pow(arr[i],3);
        }
        return sum;
    }
}
