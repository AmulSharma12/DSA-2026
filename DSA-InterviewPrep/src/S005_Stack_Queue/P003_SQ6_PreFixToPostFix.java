package S005_Stack_Queue;
import java.util.Stack;
public class P003_SQ6_PreFixToPostFix {
    public static void main(String[] args){
        String prefix = "/-AB*+DEF";
        //AB-DE+F*/
        System.out.println(convertPrefixToPostfix(prefix));
    }

    private static boolean isOperand(char ch){
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }

    private static String convertPrefixToPostfix(String prefix){
        int n = prefix.length();
        Stack<String> st = new Stack<>();
        int ind = n-1;
        while(ind >= 0){
            char ch = prefix.charAt(ind);
            if(isOperand(ch)) st.push(Character.toString(ch));
            else{
                String op1 = st.pop();
                String op2 = st.pop();
                String expression = op1 + op2 + ch;
                st.push(expression);
            }
            ind--;
        }

        return st.peek();
    }
}
