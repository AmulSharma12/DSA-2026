package S006_BinarySearch;
import java.util.Arrays;
//https://www.geeksforgeeks.org/problems/aggressive-cows/1
public class P017_GFG_AggressiveCows {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using linear search approach
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int minDistance = 1;
        int n = stalls.length;
        int maxDistance = stalls[n-1] - stalls[0];

        while(minDistance <= maxDistance){
            if(!isPossible(stalls, minDistance, k)){
                return minDistance-1;
            }else{

                minDistance++;
            }
        }

        return maxDistance;

    }


    private static boolean isPossible(int[] stalls, int minDistance, int k){
        int n = stalls.length;
        int cowAssigned = 1;
        int lastCow = stalls[0];

        for(int ind = 1; ind < n; ind++){
            if(stalls[ind] - lastCow >= minDistance) {
                cowAssigned++;
                lastCow = stalls[ind];
            }
            if(cowAssigned > k) return false;
            if(cowAssigned == k)    return true;
        }


        return false;
    }
}
