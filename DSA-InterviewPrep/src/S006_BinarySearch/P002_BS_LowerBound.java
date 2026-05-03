package S006_BinarySearch;
//https://www.geeksforgeeks.org/problems/implement-lower-bound/0
public class P002_BS_LowerBound {
    public static void main(String[] args){
        //call from here...
    }


    //Approach 1 - Linear search approach
    public static int lowerBound(int[] arr, int target) {
        int n = arr.length;
        int targetInd = n;

        for(int ind = 0; ind < n; ind++){
            if(arr[ind] >= target)  return ind;
        }

        return targetInd;
    }


    //Approach 2 - using binary search variant
    int lowerBoundBinarySearch(int[] arr, int target) {
        // code here
        int n = arr.length;
        int low = 0;
        int high = n-1;

        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] >= target)  high = mid - 1;
            else low = mid + 1;
        }


        return low;
    }
}
