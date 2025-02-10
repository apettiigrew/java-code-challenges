package linkedlist;

public class Node<T>{
    T data;
    Node nextNode;

    public Node(T data){
        this.data = data;
        this.nextNode = null;
    }
}