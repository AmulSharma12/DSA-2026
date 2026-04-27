package S005_Stack_Queue;
import java.util.Deque;
import java.util.ArrayDeque;
//https://leetcode.com/problems/sliding-window-maximum/description/
public class P016_LC239_SlidingWindowMaximum {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - tracking max for every k window from very starting to very end
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];

        for(int ind = 0; ind <= n-k; ind++){
            int maxi = nums[ind];
            for(int j = ind; j<ind+k; j++){
                maxi = Math.max(maxi, nums[j]);
            }

            result[ind] = maxi;
        }

        return result;
    }


    //Approach 2 - using montonic stack decreasing order
    //so that from the front i will be having the largest element and followed by the lesser element from them
    //remove unneccessary elements if required
    public static int[] maxSlidingWindowOptimized(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        int i = 0;
        Deque<Integer> q = new ArrayDeque<>();

        for(int ind = 0; ind < n; ind++){
            //removing out of boundary from the front
            if(!q.isEmpty() && q.peek() == ind-k)  q.poll();

            //removing all lesser elements
            while(!q.isEmpty() && nums[q.peekLast()] < nums[ind]) q.pollLast();

            q.offer(ind);
            if(ind >= k-1)    result[i++] = nums[q.peek()];
        }


        return result;
    }
}
