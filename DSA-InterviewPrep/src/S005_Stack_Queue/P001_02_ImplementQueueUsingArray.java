package S005_Stack_Queue;

import java.util.Arrays;

class QueueUsingArray{
    int size = 10;
    int currSize = 0;
    int[] queue = new int[size];
    int start = -1;
    int end = -1;

    void push(int element){
        if(currSize == size)    System.out.println("Queue is full");
        if(start == -1){
            start++;
            end++;
        }else{
            end = (end+1)%size;
        }

        System.out.println("Queue pushed " + element+ " at ind " + end);
        currSize++;
        queue[end] = element;
    }

    void pop(){
        if(currSize == 0)   System.out.println("Queue is empty");
        System.out.println("Popped element" + queue[start] + " from ind " + start);
        start = (start+1)%size;
        currSize--;
    }

    int top(){
        if(currSize == 0)   System.out.println("Queue is empty");
        System.out.println("top element " + queue[end] + " at ind " + end);
        return queue[end];
    }

    int size(){
        System.out.println("Current size " + currSize + Arrays.toString(queue));
        return currSize;
    }
}

public class P001_02_ImplementQueueUsingArray {
    public static void main(String[] args){
        QueueUsingArray q = new QueueUsingArray();
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
