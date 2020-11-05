package com.milon.java_live_course.Collection_Framework;

import java.util.ArrayList;
import java.util.Scanner;

public class VectorImplementation<T> {
    private int capacity;
    private int size;
    private ArrayList<T> vector;
    private static final int INCREMENT_FACTOR = 5;

    public VectorImplementation(int size) {
        this.size = size;
        this.capacity = size + INCREMENT_FACTOR;
        vector = new ArrayList<T>();
    }

    public void store(int index, T value) {
        try {
            vector.set(index, value);

        } catch (IndexOutOfBoundsException indexOutBounds) {
            if (index >= 0 && (index < size)) {
                vector.add(index, value);
            }
            if (index >= 0 && (index >= size && index < capacity)) {
                vector.add(index, value);
                size = index + 1;
                if (size == capacity)
                    capacity = capacity + INCREMENT_FACTOR;
            }
            if (index >= capacity) {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    public T get(int index) {
        try {
            return vector.get(index);
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {

        }
        return null;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public static void main(String[] args) {
        int size;
        int num;
        int value;
        Scanner sc = new Scanner(System.in);
        System.out.println("Entre the initial size of the vector:");
        size = sc.nextInt();
        VectorImplementation<Integer> vector = new VectorImplementation<>(size);
        System.out.println("Enter the numbers of Element:");
        num = sc.nextInt();
        System.out.println("Enter the Values");
        for (int i = 0; i < num; i++) {
            value = sc.nextInt();
            vector.store(i, value);
        }
        System.out.println("The Enter value are:");
        for (int i = 0; i < vector.getSize(); i++) {
            System.out.print(vector.get(i) + " ");
        }
        System.out.println();
        System.out.println("The size of the vector is:" + vector.getSize());
        System.out.println("Th capacity of the vector is :" + vector.getCapacity());

        sc.close();
    }
}
