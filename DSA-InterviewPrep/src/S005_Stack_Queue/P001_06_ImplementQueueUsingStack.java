package S005_Stack_Queue;
import java.util.Stack;

class QueueUsingStack{
    Stack<Integer> st = new Stack<>();
    Stack<Integer> st2 = new Stack<>();
    protected  void push(int element){
        while(!st.isEmpty()){
            st2.push(st.peek());
            st.pop();
        }

        System.out.println("Push " + element);
        st.push(element);

        while(!st2.isEmpty()){
            st.push(st2.peek());
            st2.pop();
        }
    }

    protected int pop(){
        System.out.println("Popped " + st.peek());
        return st.pop();
    }

    protected  int top(){
        System.out.println("top " + st.peek());
        return st.peek();
    }

    protected int size(){
        System.out.println("size " + st.size());
        return st.size();
    }
}
public class P001_06_ImplementQueueUsingStack {
    public static void main(String[] args){
        QueueUsingStack q = new QueueUsingStack();
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
