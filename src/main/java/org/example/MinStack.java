package org.example;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    public int minimum;
    public Node head;

    public MinStack(){
        this.head = null;
    }

    public void push(int val){
        Node newNode = new Node(val);
        if(head == null){
            this.head = newNode;
            this.minimum = val;
        } else {
            Node headNode = this.head;
            newNode.next = headNode;
            this.head = newNode;
            if(val < this.minimum){
                this.minimum = val;
            }
        }
    }

    public void pop(){
        if(this.head != null){
            this.head = this.head.next;
        }
    }

    public int top(){
        if(this.head != null) {
            return (int) this.head.data;
        }

        return 0;
    }

    public int getMin(){
        return this.minimum;
    }

    public String printStack(){
        String print = "";
        if(this.head != null){
            Node curr = this.head;
            while(curr != null){
                int val = (int) curr.data;
                print +=val+" ";
                curr = curr.next;
            }
        }

        return print;
    }

}

class Node<T> {
    T data;
    Node<T> next;

    public Node(T value) {
        this.data = value;
    }
}
