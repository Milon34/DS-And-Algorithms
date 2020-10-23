package com.milon.DataStructureAndAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Asus on 10/14/2020.
 */
public class Ds {
    int capasity=3;
    int [] stack=new int[capasity];
    int top=-1;

    void push(int x){
        if (top<capasity-1) {
            top = top + 1;
            stack[top] = x;
            System.out.println(x);
        }else {
            System.out.println("Exception push.!");
        }
    }
    int pop(){

        if (top<0){

            System.out.println("Exception! pop");
            return -1;


        }else {

            int value=stack[top];

            top=top-1;
            return value;
        }
    }
    int peek(){
        if (top<0) {
            System.out.println("Exception! Stack underflow.");
            return -1;
        }else {
            return stack[top];
        }

    }

    public static void main(String[] args) {
        Ds d=new Ds();
        System.out.println("Peek Returned:"+d.peek());
        d.push(5);
        System.out.println("Pop called:"+d.pop());
        d.push(6);
        d.push(7);
        d.push(8);

        System.out.println("Peek Returned:"+d.peek());
    }
}
class StackFirst{
    public static void main(String[] args) {
        Stack<String> st=new Stack<>();

        st.push("milon");
        st.push("ahmed");
        st.push("hello");
        System.out.println(st.pop());
        System.out.println(st.peek());
    }
}

class ListArray{
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<5;i++){
            list.add(i+1);
        }
        System.out.println(list);
//        for (int i=list.size()-1;i>=0;i--){
//           // System.out.println(i);
//          System.out.println(list.remove(i));
//            break;
//        }
//       // System.out.println(list);
    }
}