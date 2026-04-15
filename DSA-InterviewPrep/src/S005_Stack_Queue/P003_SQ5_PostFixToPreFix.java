package S005_Stack_Queue;
import java.util.Stack;
public class P003_SQ5_PostFixToPreFix {
    public static void main(String[] args){
        String postfix = "AB-DE+F*/";
        ///-AB*+DEF
        System.out.println(convertPostfixToPrefix(postfix));
    }

    private static boolean isOperand(char ch){
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }

    private static String convertPostfixToPrefix(String postfix){
        int n = postfix.length();
        Stack<String> st = new Stack<>();

        for(int ind = 0; ind < n ; ind++){
            char ch = postfix.charAt(ind);
            if(isOperand(ch)) st.push(Character.toString(ch));
            else{
                String top1 = st.peek();
                st.pop();
                String top2 = st.peek();
                st.pop();
                String newString = ch + top2 + top1;
                st.push(newString);
            }
        }

        return st.peek();
    }
}
