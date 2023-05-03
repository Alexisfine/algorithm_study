package queue;

import java.util.Stack;

public class QueueUsingStack<T> {
    private Stack<T> stackA;
    private Stack<T> stackB;

    public QueueUsingStack() {
        this.stackA = new Stack<T>();
        this.stackB = new Stack<T>();
    }

    public void enqueue(T item) {
        stackA.push(item);
    }

    public T dequeue() {
        if (stackA.size() == 0) return null;
        // move items to stack b
        int size = stackA.size();
        for (int i = 0; i < size; i++) {
            stackB.push(stackA.pop());
        }
        T returnItem = stackB.pop();

        int sizeB = stackB.size();
        for (int i = 0; i < sizeB; i++) {
            stackA.push(stackB.pop());
        }
        return returnItem;
    }

    public static void main(String[] args) {
        QueueUsingStack<Integer> queue = new QueueUsingStack<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        Integer dequeue = queue.dequeue();
        System.out.println(dequeue);
    }
}
