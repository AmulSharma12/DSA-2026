package S006_BinarySearch;
//https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
public class P018_GFG_BookAllocation {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using linear search approach
    public static int findPages(int[] arr, int k) {
        int n = arr.length;
        if(k > n)   return -1;      // when number of students > number of books because atleast one book should be allocated to each student and its not possible in that case


        int maxPage = Integer.MIN_VALUE;
        int totalSum = 0;

        for(int ind = 0; ind < n; ind++){
            maxPage = Math.max(maxPage, arr[ind]);
            totalSum += arr[ind];
        }

        for(int pages = maxPage; pages <= totalSum; pages++){
            if(isPossibleToAllocate(arr, n, pages, k))     return pages;
        }

        return -1;

    }


    private static boolean isPossibleToAllocate(int[] arr, int n, int pages, int k){
        int student = 1;
        int studentPages = 0;

        for(int ind = 0; ind < n; ind++){
            if(studentPages + arr[ind] <= pages){
                studentPages += arr[ind];
            }else{
                student++;
                studentPages = arr[ind];
            }
        }


        return student <= k;
    }

}
