package S005_Stack_Queue;
import java.util.Stack;
public class P003_SQ1_InfixToPostFix {
    public static void main(String[] args){
        String s = "a+b*(c^d-e)";
        //postfix expression - abcd^e-*+
        System.out.println(convertInfixToPostFix(s));
    }

    private static int priority(char ch){
        if(ch == '^')   return 3;
        else if(ch == '*' || ch == '/') return 2;
        else if(ch == '+' || ch == '-') return 1;
        return -1;
    }

    //converting infix to postfix expression
    private static String convertInfixToPostFix(String s){
        StringBuilder postfix = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int ind = 0; ind < n; ind++){
            char ch = s.charAt(ind);
            if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))
                postfix.append(ch);
            else if(ch == '(')
                st.push(ch);
            else if(ch == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    postfix.append(st.peek());
                    st.pop();
                }
                st.pop();
            }else{
                while(!st.isEmpty() && priority(ch) <= priority(st.peek())){
                    postfix.append(st.peek());
                    st.pop();
                }

                st.push(ch);
            }
        }

        while (!st.isEmpty()){
            postfix.append(st.peek());
            st.pop();
        }
        return postfix.toString();
    }
}
