package S005_Stack_Queue;

class StackUsingArray{
    int size = 10;
    int[] stack = new int[size];
    int top = -1;
    int currSize = 0;

    void push(int element){
        if(currSize == size)    System.out.println("Stttack is already full");

        top++;
        currSize++;
        stack[top] = element;
    }

    void pop(){
        if(currSize == 0)   System.out.println("Stack is empty!");
        System.out.println(stack[top] + " popped from ind "+ top);
        top--;
        currSize--;
    }

    int top(){
        if(top == -1)   System.out.println("Stack is empty");
        System.out.println(stack[top] + " top "+ top);
        return stack[top];
    }

    int size(){
        System.out.println("size " + currSize);
        return currSize;
    }


}

public class P001_01_ImplementStackUsingArray {
    public static void main(String[] args){
        StackUsingArray stack = new StackUsingArray();
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
