package queues;

import java.util.NoSuchElementException;

public class LinkedQueue {
    private static class QueueNode {
        private String data;
        private QueueNode next;

        public QueueNode(String data) {
            this.data = data;
        }
    }

    private QueueNode first;
    private QueueNode last;

    public void enqueue(String item) {
        QueueNode t = new QueueNode(item);

        if (last != null) {
            last.next = t;
        }
        last = t;
        if (first == null) {
            first = last;
        }

    }

    public String dequeue() {
        if (first == null) throw new NoSuchElementException();
        String item = first.data;
        first = first.next;
        if (first == null)
            last = null;
        return item;
    }

    public static void main(String[] args) {
        LinkedQueue queue= new LinkedQueue();
        queue.enqueue("Samu");
        queue.enqueue("kshiti");
        queue.enqueue("nidhi");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }
}

