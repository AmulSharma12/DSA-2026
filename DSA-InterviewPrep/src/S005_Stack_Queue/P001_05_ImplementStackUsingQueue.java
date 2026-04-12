package S005_Stack_Queue;

import java.util.Queue;
import java.util.LinkedList;

class StackUsingQueue{
    Queue<Integer> queue = new LinkedList<>();

    void push(int element){
        int size = queue.size();
        queue.add(element);
        System.out.println("Pushing element " + element);
        for(int i = 0; i<size; i++) queue.add(queue.remove());
    }

    protected   int pop(){
        System.out.println("Popped " + queue.peek());
        return queue.remove();
    }

    protected  int top(){
        System.out.println("top " + queue.peek());
        return queue.peek();
    }

    protected int size(){
        System.out.println("Size " + queue.size());
        return queue.size();
    }
}
public class P001_05_ImplementStackUsingQueue {
    public static void main(String[] args){
        StackUsingQueue stack = new StackUsingQueue();
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
