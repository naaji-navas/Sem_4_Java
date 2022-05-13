
import java.util.*;

import javax.lang.model.util.ElementScanner14;

class Link {
    public int data;
    public Link next;

    public void displayLink() {
        System.out.println(data);
    }
}

class LinkedList {
    private Link first;
    private int size;

    public LinkedList() {
        this.first = null;
        this.size = 0;

    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int d) {
        Link nl = new Link();
        nl.data = d;
        nl.next = first;
        first = nl;
        size++;
    }

    public void insertLast(int d) {
        Link nl = new Link();
        nl.data = d;
        Link current = first;
        if (first == null) {
            first = nl;
            first.next = null;
            size = 1;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = nl;
            nl.next = null;
            size++;
        }

    }

    public void insertNth(int d, int pos) {
        Link nl = new Link();
        nl.data = d;
        Link current = first;
        if (first != null && pos <= size) {
            for (int i = 1; i < pos; i++) {
                current = current.next;
            }
            nl.next = current.next;
            current.next = nl;
            size++;
        } else {
            System.out.println("Exceede the linked list size Current size = " + size);
        }
    }

    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public Link deleteLast() {
        Link current = first;
        Link temp;
        if (size == 1) {
            temp = first;
            first = null;
            size = 0;
        } else {
            Link prev = null;
            while (current.next != null) {
                prev = current;
                current = current.next;
            }
            temp = prev.next;
            prev.next = null;
            size--;
        }
        return temp;

    }

    public void deleteNth(int pos) {
        if (pos <= size && first != null) {
            Link current = first;
            Link prev = null;
            for (int i = 0; i < pos; i++) {
                prev = current;
                current = current.next;
            }
            prev.next = current.next;
            size--;
        } else {
            System.out.println("No node exist at location: " + pos);
        }
    }

    public int find(int key) {
        Link current = first;
        boolean found = false;
        int pos = 0;
        for (int i = 0; i < size; i++) {
            if (current.data == key) {
                System.out.println("Item" + key + "was found at location " + i + "in the linked list");
                found = true;
                pos = i;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("Item " + key + " NOT found in the linked list");
        }
        return pos;
    }

    public void printNodes() {
        System.out.println("Linked List elements:");
        System.out.println("`````````````````````");
        if (size < 1) {
            System.out.println("The Linked list is Empty");
        } else {
            Link current = first;
            for (int i = 1; i <= size; i++) {
                System.out.println("Node " + current.data + " is at location  " + i);
                current = current.next;
            }
        }
    }

    public void getAverage() {
        Link current = first;
        if (size % 2 != 0) {
            for (int i = 1; i < size / 2; i++) {
                current = current.next;
            }
            System.out.println(" The average element is " + current.data);
        } else {
            for (int i = 1; i < (size + 1) / 2; i++) {
                current = current.next;
            }
            float average = (current.data + current.next.data) / 2;

            System.out.println("The average element is " + average);
        }
    }

    public int getSize() {
        return size;
    }
}

public class MyLink {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        int opt;
        do {
            System.out.println("             Menu           ");
            System.out.println("````````````````````````````");
            System.out.println("1.Insert First ");
            System.out.println("2.Insert Last ");
            System.out.println("3.Insert At Nth Position ");
            System.out.println("4.Delete First ");
            System.out.println("5.Delete Last");
            System.out.println("6.Find average");
            System.out.println("7.Find Size Of the linked list");
            System.out.println("8.Print the Elements of the linked list");
            System.out.println("9.Search for a KEY");
            System.out.println("10.Is Empty or Not?");
            /*
             * System.out.println("11.Insert Before a KEY");
             * System.out.println("12.Insert After a KEY");
             * System.out.println("13.Delete  At Nth Position ");
             * System.out.println("14.Delete  a KEY ");
             */
            System.out.println("11.Exit");

            System.out.println("Select an option :");
            Scanner in = new Scanner(System.in);
            opt = in.nextInt();

            switch (opt) {
                case 1:
                    System.out.println("Enter the element: ");
                    int element = in.nextInt();
                    list.insertFirst(element);
                    list.printNodes();
                    break;
                case 2:
                    System.out.println("Enter the element: ");
                    int lastelement = in.nextInt();
                    list.insertLast(lastelement);
                    list.printNodes();
                    break;
                case 3:
                    System.out.println("Enter the element: ");
                    int nthelement = in.nextInt();
                    System.out.println("Enter the position: ");
                    int position = in.nextInt();
                    list.insertNth(nthelement, position + 1);
                    list.printNodes();
                    break;
                case 4:
                    list.deleteFirst();
                    list.printNodes();
                    break;
                case 5:
                    list.deleteLast();
                    list.printNodes();
                    break;
                case 6:
                    list.printNodes();
                    list.getAverage();
                    break;
                case 7:
                    System.out.println(list.getSize());
                    break;
                case 8:
                    System.out.println("The elements are :");
                    list.printNodes();
                    break;
                case 9:
                    System.out.println("Enter the key to be searched: ");
                    int key = in.nextInt();
                    list.find(key);
                    break;
                case 10:
                    if (!list.isEmpty()) {
                        System.out.println("The linked list is not Empty");
                    } else {
                        System.out.println("The linked list is Empty");
                    }
                    break;
                /*
                 * case 11:
                 * System.out.println("Enter the key  ");
                 * int key1 = in.nextInt();
                 * list.find(key)
                 */
                case 11:
                    System.out.println("Thankyou!");
                    System.exit(0);
                default:
                    System.out.println("Enter a valid option ");

            }
        }while(opt!= 11);

    }
}