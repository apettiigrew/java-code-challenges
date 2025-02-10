package linkedlist;

public class SinglyLinkedList<T> {
    public Node head;
    public int size;
    public SinglyLinkedList(){
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.size == 0 || this.head == null;
    }

    public void insertAtHead(T data){
        Node newNode = new Node(data);
        newNode.nextNode = head;
        head = newNode;
        size++;
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = head;
        System.out.print("List : ");
        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.nextNode;
        }
        System.out.println(temp.data.toString() + " -> null");
    }

    public void insertAfter(T data, T previous){

    }
}