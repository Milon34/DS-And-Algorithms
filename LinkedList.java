package com.milon.java_live_course.Collection_Framework;

import java.util.Scanner;

public class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
            next = null;
        }
    }


    public LinkedList insert(LinkedList list, int data) {
        Node new_node = new Node(data);
        new_node.next = null;

        //initially the Linked List is Empty..
        if (list.head == null) {
            list.head = new_node;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    public static void printList(LinkedList list) {
        Node curNode = list.head;
        System.out.print("Linked List:");
        if (curNode == null) {
            System.out.println("error! Could not create a new node");
            return;
        }
        while (curNode != null) {
            System.out.print(curNode.data + " ");
            curNode = curNode.next;
        }

    }

    public static LinkedList deleteByKey(LinkedList list, int key) {

        Node curNode = list.head, prev = null;
        if (curNode != null && curNode.data == key) {
            list.head = curNode.next;
            System.out.println(key + " found and deleted ");
            return list;
        }
        while (curNode != null && curNode.data != key) {
            prev = curNode;
            curNode = curNode.next;
        }
        if (curNode != null) {
            prev.next = curNode.next;
            System.out.println(key + " found and deleted");
        }
        if (curNode == null) {
            System.out.println(key + " found and deleted");
        }
        return list;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            list.insert(list, i);
        }
        deleteByKey(list, 2);

//        list.insert(list, 1);
//        list.insert(list, 2);
//        list.insert(list, 3);
        printList(list);
    }
}
