package S005_Stack_Queue;
import java.util.Stack;
import java.util.Arrays;
//https://leetcode.com/problems/maximal-rectangle/
public class P013_LC85_MaximalRectangle {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using largestRectangle area and computing height for each row one by one
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] heights = new int[m];
        int maxArea = 0;
        for(int row = 0; row <n; row++){
            for(int col = 0; col < m; col++){
                if(matrix[row][col] == '1')
                    heights[col]++;
                else
                    heights[col] = 0;
                //System.out.println(heights[col]);
            }
            System.out.println(Arrays.toString(heights));
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();

        for(int ind = 0; ind <n; ind++){
            while(!st.isEmpty() && heights[st.peek()] > heights[ind]){
                int element = st.peek();
                st.pop();
                int nse = ind;
                int pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, heights[element] * (nse - pse - 1));
            }

            st.push(ind);
        }

        //leftover element will hypothetical nse that would be size i.e. n
        while(!st.isEmpty()){
            int nse = n;
            int element = st.peek(); st.pop();
            int pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, heights[element] * (nse - pse -1));
        }

        return maxArea;
    }
}
