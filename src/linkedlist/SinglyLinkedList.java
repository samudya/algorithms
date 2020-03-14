package linkedlist;

import java.util.Scanner;

public class SinglyLinkedList {
    Node head = null;
    int size = 0;

    SinglyLinkedList() {
        head = null;
    }

    SinglyLinkedList(int x) {
        head = new Node(x);
        size++;
    }

    void insertFirst(int a) {
        if (head == null) {
            Node newNode = new Node(a);

        }
        Node newNode = new Node(a);
        newNode.next = head;
        head = newNode;
        size++;

    }

    int deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
        }
        int temp = head.data;
        head = head.next;
        return temp;

    }

    Node search(int ele) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == ele) {

                temp = temp.next;
                return temp;
            } else {
                System.out.println("Element not found");
                return null;
            }

        }
        return temp;
    }


    int insertAfter(int ele1, int ele2) {
        if (head == null) {
            head = new Node();
        } else {
            Node t = new Node(ele2);

            head = t;
            size++;

        }
        return 0;
    }


    public int deleteLast() {
        Node curr = head;
        Node prev = null;
        if (head == null) {
            System.out.println("List is empty");
        } else {

            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
        }
        size--;

        return curr.data;
    }

    void insertLast(int a) {
        Node newNode = new Node(a);
        if (head == null) {
            head = newNode;
            return;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        size++;
    }


    public void display() {
        Node t = head;
        StringBuilder sb = new StringBuilder();
        while (t != null) {
            sb.append(t.data);
            sb.append(" -> ");
            t = t.next;
        }
        sb.append("null");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        int x;
        do {
            System.out.println("1.InsertFirst 2.DeleteFirst 3.Display 4.Search 5.DeleteNode 6.insertEnd 7.Exit ");
            Scanner sc = new Scanner(System.in);
            x = sc.nextInt();

            switch (x) {
                case 1:
                    System.out.println("Enter your elements");
                    int ele = sc.nextInt();
                    linkedList.insertFirst(ele);
                    linkedList.display();
                    break;
                case 2:
                    linkedList.display();
                    System.out.println(linkedList.deleteFirst());
                    linkedList.display();
                case 3:
                    linkedList.display();
                    break;

                case 4:
                    System.out.println("Enter the elements you want to search");
                    int e = sc.nextInt();
                    Node t = linkedList.search(e);
                    System.out.println(e + "at address" + t);
                    linkedList.display();
                    break;

                case 5:
                    System.out.println("Enter the value of the node you want to delete");
                    int x1 = sc.nextInt();
                    linkedList.display();
                    break;

                case 6:
                    System.out.println("Enter the item to be inserted");
                    int x2 = sc.nextInt();
                    Node t1 = new Node(x2);
                    linkedList.insertLast(x2);
                    linkedList.display();
                    break;
                case 7:
                    break;


            }


        } while (x != 7);
    }

}