public class Main {

    public static void main(String[] args) {
        LL list = new LL();
        list.createList();
        list.removeDuplicates();
        list.insert(1,1000);
        list.deleteInd(1);
        list.deleteNodes(0);
        list.display();
        System.out.println(list.size);
    }
}

//list.head.data initially is not going to even exist since head is null


