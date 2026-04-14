package S005_Stack_Queue;
import java.util.Stack;
public class P003_SQ4_PrefixToInfix {
    public static void main(String[] args){
        String prefix = "*+PQ-MN";
        System.out.println(convertPrefixToInfix(prefix));
    }

    private static boolean isOperand(char ch){
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }

    private static String convertPrefixToInfix(String prefix){
        int n = prefix.length();
        Stack<String> st = new Stack<>();

        for(int ind = n-1; ind >= 0; ind--){
            char ch = prefix.charAt(ind);
            if(isOperand(ch))   st.push(Character.toString(ch));
            else{
                String top1 = st.peek();
                st.pop();
                String top2 = st.peek();
                st.pop();

                String newString = '(' + top1 + ch + top2 + ')';
                st.push(newString);
            }
        }

        return st.peek();
    }
}
