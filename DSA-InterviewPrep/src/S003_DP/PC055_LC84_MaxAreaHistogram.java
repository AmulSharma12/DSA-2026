package S003_DP;
//https://leetcode.com/problems/largest-rectangle-in-histogram/description/
public class PC055_LC84_MaxAreaHistogram {
    public static void main(String[] args){
        //call from here...
    }

    //Naive solution
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = Integer.MIN_VALUE;
        for(int ind = 0; ind < n; ind++){

            int height = heights[ind];
            int nsl = ind - 1;
            while(nsl >= 0 && heights[ind] <= heights[nsl])  nsl--;
            int nsr = ind + 1;
            while(nsr < n && heights[ind] <= heights[nsr]) nsr++;

            int width = nsr - nsl - 1;
            int area = width * height;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
