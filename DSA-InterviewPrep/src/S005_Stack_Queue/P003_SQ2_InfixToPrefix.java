package S005_Stack_Queue;
import java.util.Stack;
public class P003_SQ2_InfixToPrefix {
    public static void main(String[] args){
        String infix = "a+b*(c^d-e)";
        //postfix expression - abcd^e-*+
        System.out.println(convertInfixToPrefix(infix));
    }

    public static String reverseAndSwap(String s) {
        StringBuilder res = new StringBuilder();

        // traverse from end (reverse)
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == '(') {
                res.append(')');
            } else if (ch == ')') {
                res.append('(');
            } else {
                res.append(ch);
            }
        }

        return res.toString();
    }

    private static int priority(Character ch){
        if(ch == '^')   return 3;
        else if(ch == '*' || ch == '/') return 2;
        else if(ch == '+' || ch == '-') return 1;
        return -1;
    }

    private static String convertInfixToPrefix(String s){
        StringBuilder prefix = new StringBuilder();
        //1. reversing the infix string and also replacing '(' with ')' and ')' with '('
        String infix = reverseAndSwap(s);

        int n = infix.length();
        Stack<Character> st = new Stack<>();

        //2. converting infix to postfix expression
        for(int ind = 0; ind < n; ind++){
            char ch = infix.charAt(ind);

            if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))
                prefix.append(ch);
            else if(ch == '(')
                st.push(ch);
            else if(ch == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    prefix.append(st.peek());
                    st.pop();
                }
                st.pop();
            }
            else{
                //if its operator
                if(ch == '^'){
                    while(!st.isEmpty() && priority(ch) <= priority(st.peek())){
                        prefix.append(st.peek());
                        st.pop();
                    }
                }else{
                    while(!st.isEmpty() && priority(ch) < priority(st.peek())){
                        prefix.append(st.peek());
                        st.pop();
                    }
                }

                st.push(ch);
            }

        }

        //leftover element in stack need to be added to result string
        while(!st.isEmpty()){
            prefix.append(st.peek());
            st.pop();
        }

        //3. reversing again the result
        prefix.reverse();
        return prefix.toString();
    }
}
