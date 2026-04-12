package S005_Stack_Queue;

class QueueUsingLinkedList{
    Node start = null;
    Node end = null;
    int currSize = 0;

    //push method
    void push(int element){
        Node temp = new Node(element);

        if(start == null){
            start = end = temp;
        }
        else{
            end.next  = temp;
            end = temp;
        }
        System.out.println("Push the element " + end.data);
        currSize++;
    }

    //pop method
    void pop(){
        if(start == null && end == null)   System.out.println("Queue is empty");
        System.out.println("Popped out " + start.data);

        if(start == end){
            start = end = null;
        }else{
            start = start.next;
        }
        currSize--;
    }

    //top method
    int top() {
        if(start == null)   System.out.println("Queue is empty");
        System.out.println("top elementt in queue " + end.data);
        return end.data;
    }

    //size method
    int size() {
        System.out.println("size " + currSize);
        return currSize;
    }
}

public class P001_04_ImplementQueueUsingLinkedList {
    public static void main(String[] args){
        QueueUsingLinkedList q = new QueueUsingLinkedList();
        q.push(2);
        q.push(1);
        q.push(3);
        q.push(4);
        q.pop();
        q.top();
        q.pop();
        q.top();
        q.push(7);
        q.top();
        q.size();
    }
}
