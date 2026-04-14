package S005_Stack_Queue;
import java.util.Stack;

public class P003_SQ3_PostFixToInfix {
    public static void main(String[] args){
        //call from here...
        String postFix = "AB-DE+F*/";
        System.out.println(convertPostFixToInfix(postFix));
    }


    private static boolean isOperand(Character ch){
        return (ch>='A' && ch <= 'Z')  || (ch >= 'a' && ch <= 'z')  || (ch >= '0' && ch <= '9');
    }

    private static String convertPostFixToInfix(String s){
        int n = s.length();
        Stack<String> st = new Stack<>();

        for(int ind = 0; ind < n; ind++){
            char ch = s.charAt(ind);

            if(isOperand(ch))   st.push(Character.toString(ch));
            else{
                String charA = st.peek();
                st.pop();
                String charB = st.peek();
                st.pop();

                String newString = '(' + charB + ch + charA + ')';
                st.push(newString);
            }
        }

        return st.peek();
    }


}
