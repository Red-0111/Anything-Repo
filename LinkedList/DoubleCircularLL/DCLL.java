import java.util.Scanner;
import java.util.LinkedList;
class DCLL {
    Node head;
    Node tail;
    int size;

    DCLL() {
        this.size = 0;
    }

    static class Node {
        int data;
        Node prev, next;

        Node() {
            this.data = 0;
        }
        Node(int x) {
            this.data = x;
        }
    }
    Node getNode(int pos) {
        Node temp = head;
        while (pos > 1) {
            temp = temp.next;
            pos--;
        }
        return temp;
    }

    void insertFirst(int x) {
        Node node = new Node(x);
        node.next = head;
        head = node;
        if(tail == null) {
            tail = head;    //one element
        }
    }

    void insertLast(int x) {
        if(head == null) { insertFirst(x); return; }

        Node node = new Node(x);
        tail.next = node;
        node.prev = tail;
        tail = node;
        tail.next = null;
    }
    void deleteFirst() {
        head = head.next;
        if (head == null) tail = null;
        size--;
    }

    void deleteLast() {
        if (size <= 1) { deleteFirst(); return; }
        tail = getNode((size - 1) - 1); //second-last
        tail.next = null;
        size--;
    }
    void reverse() {
        Node temp = null;
        Node curr = head;
        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }

    }
    void deletion(int b, int e) {
        Node start = getNode(b-1);
        Node end = getNode(e+1);
        start.next = end;
        end.prev = start;
    }
    void concat(DCLL L2) {
        tail.next = L2.head;
        L2.head.prev = tail;
        tail = L2.tail;
//        L2.head = head;
        size += L2.size;
    }

    void display() {
        if(head == null) {
            System.out.println("Your DCircular Linked List is empty ");
            return;
        }

        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DCLL L = new DCLL();
        int N = sc.nextInt();
        DCLL L2 = new DCLL();
        while (N>0) {

            char ch = sc.next().charAt(0);
            switch(ch) {
                case 'I' :
                    int x = sc.nextInt();
                    if (L.size%2 ==0) { L.insertFirst(x); L.size++; }
                    else { L.insertLast(x); L.size++; }
                    break;

                case 'S' :

                    int beg = sc.nextInt();
                    int end = sc.nextInt();
                    Node pos_beg = L.getNode(beg);
                    Node pos_end = L.getNode(end);
                    Node temp = pos_beg;

                    for (int i = 1; i <= end - beg +1 ; i++) {
                        L2.insertLast(temp.data);
                        L2.size++;
                        temp = temp.next;
                    }
                    L2.insertLast(pos_beg.data);


                    L.deletion(beg,end);
                    L2.reverse();
                    L.concat(L2);
                    for (int i = 0; i< L2.size;i++) {
                        L2.deleteLast();
                    }
                    break;
                case 'D' :
                    L2.display();
                    break;
                default :
                    System.out.println("Try again");
                    break;
            }
            N--;
        }
    }
}

