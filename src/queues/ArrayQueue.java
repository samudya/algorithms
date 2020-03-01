package queues;

import java.util.NoSuchElementException;

public class ArrayQueue {
    private int[] arr;
    private int front = -1, rear = -1;

    public ArrayQueue(int size) {
        this.arr = new int[size];
    }

    /**
     * Puts item in the queue
     * @param item the queue item
     */
    public void enqueue(int item) {

        if (isEmpty()) {
            front = 0;
        }

        if (rear <= arr.length) {
            arr[++rear] = item;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Removes item from the queue
     * @return item
     */
    public int dequeue() {

        //if queue is empty.
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        //store before shifting the array value
        int temp = arr[front];
        rear--;

        //shift the array
        for (int i = 0; i <= rear; i++) {
            arr[i] = arr[i + 1];
        }
        return temp;
    }

    /**
     * Whether queue is empty or not
     * @return true if queue is empty else false.
     */
    public boolean isEmpty() {
        return front == -1 || rear == -1;
    }

    /**
     * Returns size of the queue.
     * @return size
     */
    public int qsize() {
        return rear + 1;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue(12);
        queue.enqueue(14);
        queue.enqueue(13);
        queue.enqueue(10);
        queue.enqueue(11);

        // Queue site exceeded, should throw exception
        queue.enqueue(11);

        System.out.println("No of items in queue =" + queue.qsize());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        //exception testing
        System.out.println(queue.dequeue());


    }
}
