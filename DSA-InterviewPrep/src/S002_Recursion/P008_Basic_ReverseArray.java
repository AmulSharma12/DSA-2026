package S002_Recursion;
import java.util.Arrays;
public class P008_Basic_ReverseArray {
    public static void main(String[] args){
        int[] arr = new int[]{4,5,3,6,1};
        reverseArrayUsingRecursion(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverseArrayUsingRecursion(int[] nums,int currentInd, int size)
    {
        if(currentInd >= size/2) return;
        swap(nums, currentInd, size-1-currentInd);
        reverseArrayUsingRecursion(nums, currentInd+1, size);
    }

    private static void swap(int[] nums, int curr, int backInd){
        int temp = nums[curr];
        nums[curr] = nums[backInd];
        nums[backInd] = temp;
    }
}
