package S006_BinarySearch;
//https://leetcode.com/problems/kth-missing-positive-number/description/
public class P016_LC1539_KthMissingPositiveInteger {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using linear search approach
    public static int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int ind = 0;
        int missingCnt = 0;

        for(int num = 1; num <= arr[n-1]; num++){
            if(arr[ind] != num){
                missingCnt++;
            }else{
                ind++;
            }

            if(missingCnt == k){
                return num;
            }
        }

        return arr[n-1] + (k-missingCnt);
    }
}
