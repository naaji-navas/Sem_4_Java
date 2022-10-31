public class CircularQueue {
    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public Node front = null;
    public Node rear = null;

    public void display() {
        Node current = front;
        if (current == null) {
            System.out.println("empty");
            return;
        }
         do{
            System.out.println(current.data);
            current = current.next;
        }while(current != front);

    }

    public void enQueue(int data) {
        Node newNode = new Node(data);

        if (rear == null) {
            rear = front = newNode;
        } else {
            rear.next = newNode;
           newNode.next = front;
           rear = newNode;
        }
    }

    public void deQueue() {
        if (front == null) {
            System.out.println("empty");

        } else {
            front = front.next;
            rear.next = front;

        }

    }




    public static void main(String[] args){
         CircularQueue dick = new CircularQueue();



         dick.enQueue(10);
         dick.enQueue(20);
         dick.enQueue(30);
         dick.enQueue(40);
         dick.enQueue(50);
         dick.deQueue();
         dick.display();
    }
}
