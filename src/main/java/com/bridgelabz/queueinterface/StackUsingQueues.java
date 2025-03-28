package com.bridgelabz.queueinterface;

import java.util.*;

public class StackUsingQueues {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    // Push operation
    public void push(int x) {
        queue2.add(x); // Add new element to queue2
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove()); // Transfer elements from queue1 to queue2
        }

        // Swap names of queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Pop operation
    public int pop() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.remove(); // Remove the top element
    }

    // Top operation
    public int top() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.peek(); // Peek the top element
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackUsingQueues stack = new StackUsingQueues();

        try {
            System.out.println("Enter the number of operations:");
            int n = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < n; i++) {
                System.out.println("Enter operation (push <number>, pop, or top):");
                String operation = scanner.nextLine();

                if (operation.startsWith("push")) {
                    int value = Integer.parseInt(operation.split(" ")[1]);
                    stack.push(value);
                    System.out.println(value + " pushed onto stack");
                } else if (operation.equals("pop")) {
                    System.out.println("Popped element: " + stack.pop());
                } else if (operation.equals("top")) {
                    System.out.println("Top element: " + stack.top());
                } else {
                    System.out.println("Invalid operation");
                }
            }
        } catch (IllegalStateException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

