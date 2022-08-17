package BEGGINING.Stack;

import java.io.IOException;
import java.util.*;

class ourStack {
    private int max;
    private int[] arr;
    private int top;

    public ourStack(int s) {
        max = s;
        arr = new int[max];
        top = -1;
    }

    public void push(int j) {
        arr[++top] = j;
    }

    public int pop() {
        return (--top);
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == max - 1);
    }
}

class stackImplementation {
