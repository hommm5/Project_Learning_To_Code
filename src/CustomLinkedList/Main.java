package CustomLinkedList;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();



        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        System.out.println(list.removeAt(4));


        System.out.println();

    }
}
