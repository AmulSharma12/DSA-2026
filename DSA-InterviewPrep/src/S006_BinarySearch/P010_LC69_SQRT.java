package S006_BinarySearch;
//https://leetcode.com/problems/sqrtx/description/
public class P010_LC69_SQRT {
    public static void main(String[] args){
        //call from here...
    }

    //Approach  1 - using linear search approach
    public static int mySqrtUsingLinearApproach(int x) {
        if(x == 0)  return 0;
        int num = 1;
        while(num <= x){
            if(num * num  > x)  return num -1;
            if(num * num == x)  return num;
            num++;
        }

        return -1;
    }


    //Approach 2 - using binary search approach
    public int mySqrt(int x) {
        if(x == 0)  return 0;

        int low = 1;
        int high = x;
        int ans = 1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if((long)mid * mid == x)  return mid;
            else if((long)mid * mid > x)  high = mid - 1;
            else{
                ans = mid;
                low = mid + 1;
            }
        }

        return ans;
    }
}
