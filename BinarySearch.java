package com.milon.DataStructureAndAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int[] arr2=arr;

        System.out.println("Sort of array");
        for (int a:arr2){
            System.out.print(a+" ");
        }
        System.out.println();
        int middle;
        System.out.println("Enter item:");
        int item=sc.nextInt(),left=0,right=arr.length-1;
        while (left<=right){
            middle=(left+right)/2;
            if (arr2[middle]==item){
                System.out.println("The Item index is:"+middle);
                return;
            }else if (arr2[middle]<item){
                left=middle+1;
            }else {
                right=middle-1;
            }
        }
        System.out.println("Item not found..!");
    }
}
