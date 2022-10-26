import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DoublyLL list = new DoublyLL();
        list.createList();;
        list.display();

        System.out.println("\nEnter :-\n" +
                "(a) Insertion at the beginning. \n" +
                "(b) Insertion at the end. \n" +
                "(c) Insertion at a particular index\n" +
                "(d) Deletion from the beginning. \n" +
                "(e) Deletion from the end. \n" +
                "(f) Deletion at a particular index. \n" +
                "(g) Display all the node values\n" +
                "(h) EXIT" );
        char ch;
        do {
            System.out.print("\nChoice : ");
            ch = sc.next().charAt(0);
            switch (ch) {

                case 'a':
                    System.out.print("Enter Node : ");
                    list.insertFirst(sc.nextInt());
                    break;

                case 'b':
                    System.out.print("Enter Node : ");
                    list.insertLast(sc.nextInt());
                    break;

                case 'c':
                    System.out.print("Enter Index : ");
                    int ind = sc.nextInt();
                    System.out.print("Enter value : ");
                    int value = sc.nextInt();
                    list.insert(ind, value);
                    break;

                case 'd' :
                    list.deleteFirst();
                    break;

                case 'e' :
                    list.deleteLast();
                    break;

                case 'f' :
                    System.out.print("Enter Index where you want to delete : ");
                    list.delete(sc.nextInt());
                    break;

                case 'g' :
                    list.display();
                    break;

                default :
                    if(ch != 'h')
                        System.out.println("Please choose from above mentioned options.");
                    break;

            }
        } while (ch != 'h');
    }
}
