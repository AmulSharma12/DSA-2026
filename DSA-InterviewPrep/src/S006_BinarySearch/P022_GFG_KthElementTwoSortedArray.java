package S006_BinarySearch;
import java.util.Arrays;
//https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1
public class P022_GFG_KthElementTwoSortedArray {
    public static void main(String[] args){
        //call from here...
    }


    //Approach 1 - using naive approach
    public static int kthElementUsingNaiveApproach(int a[], int b[], int k) {
        int n1 = a.length;
        int n2 = b.length;
        int n = n1 + n2;
        int[] result = new int[n];
        int currInd = 0;
        for(int ind = 0; ind < n1; ind++){
            result[currInd++] = a[ind];
        }

        for(int ind = 0; ind < n2; ind++){
            result[currInd++] = b[ind];
        }


        Arrays.sort(result);
        return result[k-1];
    }


    //Approach 2 - using merge sort approach
    public static int kthElementUsingMergeSortApproach(int a[], int b[], int k) {
        int n1 = a.length;
        int n2 = b.length;
        int n = n1 + n2;
        int ind = 0;
        int ind1 = 0;
        int ind2 = 0;
        int[] result = new int[n];
        while(ind1 < n1 && ind2 < n2){
            if(a[ind1] < b[ind2])
                result[ind++] = a[ind1++];
            else
                result[ind++] = b[ind2++];

        }


        while(ind1 < n1) result[ind++] = a[ind1++];
        while(ind2 < n2) result[ind++] = b[ind2++];

        return result[k-1];
    }


    //Approach 3 - using binary search approach - partition.
    public static int kthElementUsingBinarySearchApproac(int a[], int b[], int k) {
        int n1 = a.length;
        int n2 = b.length;
        int n = n1 + n2;
        if(n2 < n1) return kthElementUsingBinarySearchApproac(b,a, k);

        int low = Math.max(0, k - n2);
        int high = Math.min(k, n1);

        while(low <= high){
            int mid1 = low + (high-low)/2;
            int mid2 = k - mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if(mid1 < n1)   r1 = a[mid1];
            if(mid2 < n2)   r2 = b[mid2];
            if(mid1-1 >= 0) l1 = a[mid1-1];
            if(mid2-1 >= 0) l2 = b[mid2-1];

            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1, l2);
            }
            else if(l1 > r2){
                high = mid1 - 1;
            }else{
                low = mid1 + 1;
            }
        }

        return 0;
    }
}
