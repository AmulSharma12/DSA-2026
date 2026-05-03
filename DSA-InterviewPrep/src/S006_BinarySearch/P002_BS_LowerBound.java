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
}
