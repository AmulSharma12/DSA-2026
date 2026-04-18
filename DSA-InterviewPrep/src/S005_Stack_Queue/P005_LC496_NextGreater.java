package S005_Stack_Queue;
import java.util.Arrays;
import java.util.Stack;
//https://leetcode.com/problems/next-greater-element-i/description/
public class P005_LC496_NextGreater {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1- using naive approach
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] result = new int[n];
        Arrays.fill(result,-1);
        for(int ind = 0; ind <n; ind++){
            int index = findIndex(nums1[ind], nums2, m);

            for(int j = index+1; j<m; j++){
                if(nums2[j] > nums1[ind]){
                    result[ind] = nums2[j];
                    break;
                }
            }
        }

        return result;
    }

    private static int findIndex(int element, int[] nums, int n){
        for(int ind = 0; ind <n; ind++){
            if(nums[ind] == element)    return ind;
        }

        return -1;
    }


    //Approach 2 - using optimisation of nge
    public static int[] nextGreaterElementOptimisaiton(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] result = new int[n];
        Arrays.fill(result,-1);
        int[] nge  = nextGreaterCompute(nums2, m);
        for(int ind = 0; ind <n; ind++){
            int index = findIndex(nums1[ind], nums2, m);
            result[ind] = nge[index];
        }

        return result;
    }

    private static int[] nextGreaterCompute(int[] nums, int size){
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[size];
        for(int ind = size-1; ind >= 0; ind--){
            while(!st.isEmpty() && st.peek() <= nums[ind]) st.pop();
            if(st.isEmpty())    nge[ind] = -1;
            else nge[ind] = st.peek();
            st.push(nums[ind]);
        }

        return nge;
    }
}
