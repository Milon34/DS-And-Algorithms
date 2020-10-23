package com.milon.java_live_course.DS_ALGO;
import java.util.Scanner;

public class Selection_Sort {
    public void selection_Sort(int a[]){
        int i,j,temp,min_index;
        for (i=0;i<a.length-1;i++){
            min_index=i;
            for (j=i+1;j<a.length;j++){
                if (a[j]<a[min_index]){
                    min_index=j;
                }
            }
            if (min_index!=i){
                temp=a[i];
                a[i]=a[min_index];
                a[min_index]=temp;
            }
        }
    }
    public static void main(String[] args) {
        Selection_Sort selection_sort=new Selection_Sort();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Size no.:");
        int n=sc.nextInt();
        int arr[]=new int[n];

        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("before selection sort..");
        for (int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();

        System.out.println("After selection sort.");
        selection_sort.selection_Sort(arr);
        for (int i:arr){
            System.out.print(i+" ");
        }

       // System.out.println(selection_sort.toString());
    }
}
