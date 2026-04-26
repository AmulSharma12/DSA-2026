package S005_Stack_Queue;
import java.util.Stack;
//https://leetcode.com/problems/remove-k-digits/
public class P014_LC402_RemoveKDigits {
    public static void main(String[] args){
        //call from here...
    }

    public static String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> st = new Stack<>();

        for(int ind = 0; ind < n; ind++){
            while(!st.isEmpty() && k > 0 && st.peek() - '0' > num.charAt(ind) - '0') {
                st.pop();
                k--;
            }

            st.push(num.charAt(ind));
        }


        //there can be still element not popped out and still k left to remvoe some elements
        while(k > 0){
            st.pop();
            k--;
        }

        //when the stack becomes empty means all element get removed
        if(st.isEmpty())    return "0";

        //now building the string and removing leading zero and reverse it
        StringBuilder result = new StringBuilder();
        while(!st.isEmpty()){
            result.append(st.peek());
            st.pop();
        }

        while(result.length() >0 &&  result.charAt(result.length() - 1) == '0'){
            result.deleteCharAt(result.length() - 1);
        }

        if(result.length() == 0)    return "0";

        //reverse the string and return it
        return result.reverse().toString();

    }
}
