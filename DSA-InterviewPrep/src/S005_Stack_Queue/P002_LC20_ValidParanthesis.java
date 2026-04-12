package S005_Stack_Queue;
import java.util.Stack;
//https://leetcode.com/problems/valid-parentheses/description/
public class P002_LC20_ValidParanthesis {
    public static void main(String[] args){
        //call from here...
    }

    //using stack
    public static boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for(int ind = 0; ind < n; ind++){
            char ch = s.charAt(ind);

            if(ch == '(' || ch == '[' || ch == '{') st.push(ch);
            else{
                if(st.isEmpty())    return false;
                char top = st.peek();
                if((ch == ')' && top == '(')  || (ch == ']' && top == '[') || (ch == '}' && top == '{') ) st.pop();
                else return false;
            }
        }


        return st.isEmpty();
    }
}
