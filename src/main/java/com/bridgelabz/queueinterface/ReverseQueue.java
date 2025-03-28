package com.bridgelabz.queueinterface;

import java.util.*;

public class ReverseQueue {
    // Method to reverse the queue
    public static <T> void reverseQueue(Queue<T> queue) {
        if (queue == null) {
            throw new IllegalArgumentException("Queue cannot be null");
        }

        Stack<T> stack = new Stack<>(); // Temporary stack

        // Remove all elements from the queue and push them onto the stack
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        // Pop all elements from the stack and add them back to the queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the number of elements in the queue:");
            int n = scanner.nextInt();

            Queue<Integer> queue = new LinkedList<>();
            System.out.println("Enter the elements of the queue:");
            for (int i = 0; i < n; i++) {
                queue.add(scanner.nextInt());
            }

            // Display original queue
            System.out.println("Original Queue: " + queue);

            // Reverse the queue
            reverseQueue(queue);

            // Display reversed queue
            System.out.println("Reversed Queue: " + queue);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

