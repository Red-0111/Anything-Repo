import java.util.*;

public class LL {
    Node head;  //by default head & tail are "null" if empty/not created
    Node tail;
    int size;

    LL() {
        this.size = 0;
    }

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

    void createList() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of your linked list : ");
        size = sc.nextInt();
        System.out.println("\nEnter it's elements :-");
        for (int i = 0; i < size; i++) {
            insertLast(sc.nextInt());
            size--;
        }
    }

    void display() {
        if (head == null) {
            System.out.println("Your linked list is empty");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.data);   //tail.data
    }

    //  move ahead (next) from 0/head "index times"
    Node getNode(int ind) {
        Node temp = head;
        while (ind > 0) {
            temp = temp.next;
            ind--;
        }
        return temp;
    }

    //  *size = 0
    void insertFirst(int x) {   //size = 0, creation() , first_node()
        Node node = new Node(x);
        node.next = head;
        head = node;
        if (tail == null) {  //if one element present
            tail = head;
        }
        size++;
    }

    void insertLast(int x) {    //addition()
        if (head == null) { insertFirst(x); return; }

        Node node = new Node(x);
        tail.next = node;
        tail = node;
        size++;
    }

    void insert(int ind, int x) {
        if (ind == 0) { insertFirst(x); return; }
        if (ind == size) { insertLast(x); return; }

        Node prev = getNode(ind - 1);
        Node node = new Node(x);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    //  *size = 1
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

    void deleteNodes(int val) {  //will delete all nodes containing val
        if (head.data == val) { deleteFirst(); deleteNodes(val); return; }  //element may again be head
        if (tail.data == val) { deleteLast(); deleteNodes(val); return; }

        Node prev = head;
        while (prev.next != null) {
            if (prev.next.data == val) {
                prev.next = prev.next.next;
                size--;
            } else {
                prev = prev.next;
            }
        }
    }

    void deleteInd(int ind) {
        if (ind == 0) { deleteFirst(); return; }
        if (ind == size-1) { deleteLast();  return; }

        Node prev = getNode(ind - 1);
        prev.next = prev.next.next;
        size--;
    }

    int getIndex(int x) {
        Node temp = head;
        int i = 0;
        while(temp.data != x) {
            i++;
            temp = temp.next;
        }
        return i;
    }

    int removeKey_nonRec(int key) {
        int count = 0;
        Node prev = head;

        //from 2nd to 2nd last (except head and tail)
        while (prev.next != null && size > 2) {  //tail will not run
            if (prev.next.data == key) {
                prev.next = prev.next.next;
                count++;        //don't move on after deletion, check its next also
            }else {
                prev = prev.next;
            }
        }

        if (head.data == key) { deleteFirst(); count++; }
        if (head != null) {  if(tail.data == key) { deleteLast(); count++; } }

        return count;
    }

    int removeKey_Rec(int key, Node prev) {

        if (head.data == key) {
            deleteFirst();
            prev = head;
            return 1 + removeKey_Rec(key, prev);
        }
        if (tail.data == key) {
            deleteLast();
            return 1 + removeKey_Rec(key, prev);
        }
//      if size <= 1 till here, neither head nor tail is the key
        if (size <= 1 || prev.next.next == null) { return 0; }

        if (prev.next.data == key) {
            prev.next = prev.next.next;
            size--;
            return 1 + removeKey_Rec(key, prev);
        }

        return removeKey_Rec(key, prev.next);
    }

    void removeDuplicates() {
        Node temp = head;
        while (temp.next != null) {   //run till second last, temp ends as tail
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;     //even checks 2nd last and last
                size--;
            } else{
                temp = temp.next;
            }
        }
        tail = temp;
        tail.next = null; //re-assign tail
    }

    void midNode() {
        int mid_ind = size / 2;
        if (size == 0) { System.out.println("List is empty"); return; }
        if (size % 2 != 0) {
            System.out.println(getNode(mid_ind).data);
        } else {
            System.out.println(getNode(mid_ind - 1).data + " , " + getNode(mid_ind).data);
        }
    }

    void reverse() {
        if (size <= 1) return;

        Node prev = head;
        Node temp = prev.next;

        while (temp !=  null) {
            Node forw = temp.next;
            temp.next = prev;
            prev = temp;
            temp =  forw;
        }
        tail = head;
        tail.next = null;
        head = prev;
    }
}


//* -> careful at

//head == null -> size = 0
//tail == null -> size = 0 || perform head == tail (just created 1st element)
//head == tail -> size = 1

