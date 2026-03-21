package S003_DP;
import java.util.Stack;
//https://leetcode.com/problems/maximal-rectangle/description/
public class PC055_LC85_MaximumAreaRectangleWithAllOnes {
    public static void main(String[] args){
        //call from here...
    }

    //finding the maximum area rectangle with all ones
    public static int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        int maxArea = Integer.MIN_VALUE;

        //Looping each row one by one and updating the histogram heights accordingly wrt.'1'
        for(int row = 0; row < n; row ++){
            for(int col = 0; col < m; col++){
                if(matrix[row][col] == '1')     heights[col]++;
                else heights[col] = 0;
            }


            int area = largestRectangleArea(heights);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    //finding the maxArea of histogram
    private static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();

        for(int ind = 0; ind < n; ind++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[ind]){
                int elementInd = st.peek();
                st.pop();
                int nse = ind;
                int pse = st.isEmpty() ? -1 : st.peek();
                int area = heights[elementInd] * (nse-pse-1);
                maxArea = Math.max(area, maxArea);
            }

            st.push(ind);
        }

        //if there element remains in the stack
        while(!st.isEmpty()){
            int elementInd = st.peek();
            st.pop();
            int nse = n;
            int pse = st.isEmpty() ? -1 : st.peek();

            int area = heights[elementInd] * (nse - pse - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
