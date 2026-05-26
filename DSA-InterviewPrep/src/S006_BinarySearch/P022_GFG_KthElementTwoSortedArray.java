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
}
