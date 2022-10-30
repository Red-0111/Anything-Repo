import java.util.*;

class CircularLL {
    Node head;
    Node tail;
    int size;

    static class Node {
        int data;
        Node next;

        Node() {
            this.data = 0;
            this.next = null;
        }
        Node(int x) {
            this.data = x;
            this.next = null;
        }
    }

    void create_List() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size for your Circular Linked List -> ");
        size = sc.nextInt();
        System.out.println("Enter it's elements : ");
        for(int i = 0; i < size; i++) {
            insertLast(sc.nextInt());
        }
    }

    void insertFirst(int x) {
        Node node = new Node(x);
        node.next = head;
        head = node;
        if(tail == null) {
            tail = head;    //one element
        }
        tail.next = head;   //extra in CLL
    }

    void insertLast(int x) {
        if(head == null) { insertFirst(x); return; }

        Node node = new Node(x);
        tail.next = node;
        tail = node;
        tail.next = head;
    }

    void display() {
        if(head == null) {
            System.out.println("Your Circular Linked List is empty ");
            return;
        }

        Node temp = head;
        while(temp.next != head) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.data);  //or tail.data
    }
}
