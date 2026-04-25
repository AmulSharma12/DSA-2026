package S005_Stack_Queue;
import java.util.Stack;
//https://leetcode.com/problems/asteroid-collision/description/
public class P011_LC735_AsteroidCollision {
    public static void main(String[] args){
        //call from here...
    }

    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();

        for(int ind = 0; ind < n; ind++){
            int element = asteroids[ind];
            if(element > 0) st.push(element);
            else{
                //removing all stack element if the current negative elmenet is greater as they will collide
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(element)) st.pop();

                if(!st.isEmpty() && st.peek() == Math.abs(element)) st.pop();
                else if(st.isEmpty() || st.peek()  < 0) st.push(element);
            }
        }

        int size = st.size();
        int currInd = size-1;
        int[] nums = new int[size];

        System.out.println(size);
        while(currInd >= 0){
            nums[currInd] = st.pop();
            currInd--;
        }
        return nums;
    }
}
