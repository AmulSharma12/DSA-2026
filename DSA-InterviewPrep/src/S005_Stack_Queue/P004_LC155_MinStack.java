package S005_Stack_Queue;
import java.util.Stack;

//https://leetcode.com/problems/min-stack/description/
public class P004_LC155_MinStack {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using pair and push into the stack (element that pushed, till now what's the min)
    class Pair{
        public int element;
        public int min;

        public Pair(int element,int  min){
            this.element = element;
            this.min = min;
        }
    }
    class MinStack {
        private Stack<Pair> st;
        public MinStack() {
            st = new Stack<>();
        }

        public void push(int val) {
            if(st.isEmpty())
                st.push(new Pair(val, val));
            else
                st.push(new Pair(val, Math.min(val, st.peek().min)));
        }

        public void pop() {
            st.pop();
        }

        public int top() {
            return st.peek().element;
        }

        public int getMin() {
            return st.peek().min;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
