package com.bridgelabz.queueinterface;

import java.util.*;

public class CircularBuffer{
    private int[] buffer;
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    private int capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
    }

    // Insert an element into the buffer
    public void insert(int element) {
        buffer[tail] = element; // Add the element at the tail position
        tail = (tail + 1) % capacity; // Move the tail pointer circularly
        if (size < capacity) {
            size++;
        } else {
            head = (head + 1) % capacity; // Overwrite the oldest element
        }
    }

    // Display the elements in the buffer
    public void display() {
        System.out.print("Buffer: [");
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(head + i) % capacity]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the size of the circular buffer:");
            int bufferSize = scanner.nextInt();
            CircularBuffer circularBuffer = new CircularBuffer(bufferSize);

            System.out.println("Enter the number of elements to insert:");
            int numElements = scanner.nextInt();

            // Insert elements into the buffer
            System.out.println("Enter the elements:");
            for (int i = 0; i < numElements; i++) {
                int element = scanner.nextInt();
                circularBuffer.insert(element);
                circularBuffer.display(); // Display buffer after each insertion
            }
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

