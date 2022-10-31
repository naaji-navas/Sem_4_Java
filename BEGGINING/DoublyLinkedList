import java.util.ArrayList;

public class DoublyLinkedList {

    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void addNode(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }

        tail = newNode;

    }

    public void displayForward() {
        ArrayList<Integer> list = new ArrayList<>();

        Node temp = head;

        if (temp == null) {
            System.out.println("the list is empty");

            return;
        }

        while (temp != null) {

            System.out.println(temp.data);
            list.add(temp.data);
            temp = temp.next;
        }

    }

    public void displayBackward() {

        Node temp = tail;

        if (temp == null) {
            System.out.println("the list is empty");

            return;
        }

        while (temp != null) {

            System.out.println("displaying backward : "+temp.data);
            temp = temp.prev;
        }

    }

    public void removeDuplicate() {

        Node current = head;

        if (current == null) {
            System.out.println("the list is empty");
            return;
        }

        while (current != null) {
            Node next = current.next;
            while (next != null) {

                if (current.data == next.data) {
                    if (next == tail) {
                        tail.prev.next = null;
                        tail = tail.prev;
                        break;
                    }

                    next.prev.next = next.next;
                    next.next.prev = next.prev;
                }

                next = next.next;
            }

            current = current.next;

        }

    }

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.addNode(6);
        list.addNode(5);
        list.addNode(10);
        list.addNode(5);
        list.addNode(5);
        list.addNode(8);
        list.addNode(8);
        list.removeDuplicate();
        list.displayForward();

    }

}
