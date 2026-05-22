package S006_BinarySearch;
//https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/1
public class P019_GFG_PainterPartition {
    public static void main(String[] args){
        //call from here...
    }


    //Approach 1 - using linear search approach
    public static int minTime(int[] arr, int k) {
        int minTime = Integer.MIN_VALUE;
        int maxTime = 0;
        int n = arr.length;

        for(int ind = 0; ind < n; ind++){
            minTime = Math.max(minTime, arr[ind]);
            maxTime += arr[ind];
        }

        for(int time = minTime; time <= maxTime; time++){
            if(isPossibleToPaintBoard(arr, time, k))     return time;
        }


        return -1;
    }

    private static boolean isPossibleToPaintBoard(int[] arr, int time,int painterCount){
        int n = arr.length;
        int painter = 1;
        int currTime = 0;
        for(int ind = 0; ind < n; ind++){
            if(currTime + arr[ind] <= time)
                currTime += arr[ind];
            else{
                painter++;
                currTime = arr[ind];
            }
        }

        return painter <= painterCount;
    }
}
