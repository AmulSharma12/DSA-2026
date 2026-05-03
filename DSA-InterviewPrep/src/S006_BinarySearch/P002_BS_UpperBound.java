package S006_BinarySearch;
//https://www.geeksforgeeks.org/problems/implement-upper-bound/1
public class P002_BS_UpperBound {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using linear search
    public static int upperBound(int[] arr, int target) {
        int n = arr.length;

        for(int ind = 0; ind < n; ind++){
            if(arr[ind] > target) return ind;
        }

        return n;
    }

    //Approach 2 - using binary search
    public static int upperBoundBinarySearch(int[] arr, int target) {
        int n = arr.length;
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] > target)    high = mid -1;
            else low = mid + 1;
        }


        return low;

    }
}
