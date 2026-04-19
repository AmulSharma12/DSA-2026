package S005_Stack_Queue;
import java.util.Stack;
import java.util.ArrayList;

public class P007_GFG_PreviousSmallerElement {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using brute/naive approach - Lead to TLE
    public static ArrayList<Integer> prevSmallerBrute(int[] arr) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;

        for(int ind = 0; ind <n; ind++){
            boolean isFound = false;
            for(int j = ind-1; j >= 0; j--){
                if(arr[j] < arr[ind]){
                    isFound = true;
                    result.add(arr[j]);
                    break;
                }
            }

            if(!isFound) result.add(-1);
        }

        return result;
    }

    //Approach 2 - using Optimization monotonic stack
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for(int ind = 0; ind <n; ind++){
            while(!st.isEmpty() && st.peek() >= arr[ind])   st.pop();
            int element = st.isEmpty() ? -1 : st.peek();
            list.add(element);

            st.push(arr[ind]);
        }

        return list;
    }
}
