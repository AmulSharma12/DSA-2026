package S005_Stack_Queue;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class StackUsingLinkedList{
    Node top = null;
    int currSize = 0;


    //push method
    void push(int data) {
        Node temp = new Node(data);
        temp.next = top;
        top = temp;
        System.out.println("Pushing element " + top.data);
        currSize++;
    }

    //pop method
    void pop() {
        if(top == null) System.out.println("Stack is empty");
        System.out.println("Popped outt elementt " + top.data);
        Node temp = top;
        top = temp.next;
        temp = null;
        currSize--;

    }

    //top element
    int top(){
        if(top == null) System.out.println("Stack is empty ");
        System.out.println("top element " + top.data);
        return top.data;
    }

    //size
    int size(){
        System.out.println("Current size " + currSize);
        return currSize;
    }


}

public class P001_03_ImplementStackUsingLinkedList {
    public static void main(String[] args){
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(1);
        stack.pop();
        stack.top();
        stack.top();
        stack.pop();
        stack.push(5);
        stack.top();
        stack.size();
    }
}
