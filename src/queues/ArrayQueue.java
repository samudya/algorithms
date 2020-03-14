package queues;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ArrayQueue {
    private int[] arr;
    private int front = -1, rear = -1;

    public ArrayQueue(int size) {
        this.arr = new int[size];
    }

    /**
     * Puts item in the queue
     *
     * @param item the queue item
     */
    public void enqueue(int item) {

        if (isEmpty()) {
            front = 0;
        }

        if (rear <= arr.length) {
            arr[++rear] = item;
        } else {
            System.out.println("Full");;
        }
    }

    /**
     * Removes item from the queue
     *
     * @return item
     */
    public int dequeue() {

        //if queue is empty.
        if (isEmpty()) {
            System.out.println("Empty");;
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
     *
     * @return true if queue is empty else false.
     */
    public boolean isEmpty() {
        return front == -1 || rear == -1;
    }

    /**
     * Returns size of the queue.
     *
     * @return size
     */
    public int qsize() {
        return rear + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of the queue");
        int size = sc.nextInt();
        ArrayQueue queue = new ArrayQueue(size);
        System.out.println("Enter the elements with space delimiter eg. 12 24 23 and to terminate with 0");
        while (sc.hasNext()) {
            int x = sc.nextInt();
            if (x == 0)
                break;
            else
                queue.enqueue(x);
        }


        System.out.println("No of items in queue =" + queue.qsize());
        while (!queue.isEmpty())
            System.out.println(queue.dequeue());


    }
}
