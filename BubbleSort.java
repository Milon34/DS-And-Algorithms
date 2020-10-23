package com.milon.java_live_course.DS_ALGO;

import java.util.Scanner;

public class BubbleSort {
public void bubble_Sort(int arr[]){
    int i,j,temp;
    for (i=0;i<arr.length;i++){
        for (j=0;j<arr.length-i-1;j++){
            if (arr[j]>arr[j+1]){
                temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
    }
}
    public static void main(String[] args) {
    BubbleSort bubbleSort=new BubbleSort();
        Scanner fc=new Scanner(System.in);
        System.out.println("Enter Size no.:");
        int n=fc.nextInt();
        int arr[]=new int[n];

        for (int i=0;i<n;i++){
            arr[i]=fc.nextInt();
        }
        System.out.println("before bubble sort..");
        for (int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();

        System.out.println("After bubble sort.");
        bubbleSort.bubble_Sort(arr);
        for (int i:arr){
            System.out.print(i+" ");
        }

        // System.out.println(selection_sort.toString());
    }
    }

