package S005_Stack_Queue;
import java.util.Stack;

//Approach 2 - using optimisation and mathematical logic
//when you are about to update the minimum
//on stack you will push 2*val - mini
//and mini will be update to the value

//on pop if its one with the updated mini having top elemnet as well
//so pop the elmenet from stack also check if it is that updated mini of mathematical formul
//then udpate mini as well with logic mini = 2* mini - st.peek() elmenet
class MinStack {
    public Stack<Long> st;
    long mini;
    public MinStack() {
        st = new Stack<>();
    }

    public void push(int element) {
        long val = element;
        if(st.isEmpty()){
            st.push(val);
            mini = val;
        }else{
            if(mini > val){
                st.push(2 * val - mini);
                mini = val;
            }else{
                st.push(val);
            }
        }
    }

    public void pop() {
        if (st.isEmpty()) return;

        // Get the top
        long x = st.pop();

        // If the modified value was added to stack
        if (x < mini) {
            // Update the minimum
            mini = 2 * mini - x;
        }
    }

    public int top() {
        // Base case
        if (st.isEmpty()) return -1;

        // Get the top
        long x = st.peek();

        // Return top if minimum is less than the top
        if (mini < x) return (int)x;

        // Otherwise return mini
        return (int)mini;
    }

    public int getMin() {
        return (int)mini;
    }
}

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
