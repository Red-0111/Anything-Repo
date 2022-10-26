import java.util.*;

public class DoublyLL {
    int size;
    Node head;
    Node tail;

    //head, tail, prev, next are by default initialized as "null"

    DoublyLL() {
        this.size = 0;
    }

    static class Node {
        int data;
        Node prev;
        Node next;

        Node() {
            this.data = 0;
        }

        Node(int data) {
            this.data = data;
        }
    }

    void insertFirst(int x) {   //size = 0, creation()
        if (head == null) {
            head = new Node(x);
            tail = head;
            size++;
            return;
        }
        Node node = new Node(x);
        node.next = head;
        head.prev = node;
        head = node;
        size++;
    }

    void insertLast(int x) {
        if (head == null) {
            insertFirst(x);
            return;
        }
        Node node = new Node(x);
        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
    }

    void insert(int ind, int x) {
        if(ind == 0) { insertFirst(x); return; }
        if(ind == size - 1) { insertLast(x); return; }

        Node node = new Node(x);
        Node prevNode = getNode(ind - 1);
        node.prev = prevNode;       //no-
        node.next = prevNode.next;  //de
        prevNode.next.prev = node;  //prevnode
        prevNode.next = node;       //nextnode
        size++;
    }

    Node getNode(int ind) {
        Node temp = head;
        int i = 0;
        while(i != ind) {
            temp = temp.next;
            i++;
        }
        return temp;
    }

    void deleteFirst() {
        head = head.next;
        if(head == null) {  //cond. if there was 1 element (head = tail) before
            tail = null;
        }
        size--;
    }

    void deleteLast() {
        if(head == tail) { deleteFirst(); return; }
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    void delete(int ind) {
        if(ind == 0) { deleteFirst(); return; }
        if(ind == size - 1) { deleteLast(); return; }

        Node prevNode = getNode(ind - 1);
        prevNode.next = prevNode.next.next;
        prevNode.next.next.prev = prevNode;
        size--;
    }

    void createList() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of your linked list : ");
        size = sc.nextInt();
        System.out.println("\nEnter it's elements :-");
        for(int i = 0; i < size; i++) {
            insertLast(sc.nextInt());
            size--; //to keep size same
        }
    }

    void display() {
        if(head == null) {
            System.out.println("Your linked list is empty");
            return;
        }
        Node temp = head;
        while(temp.next != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.data);   //tail.data
    }
}
