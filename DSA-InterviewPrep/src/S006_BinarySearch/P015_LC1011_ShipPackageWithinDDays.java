package S006_BinarySearch;
//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
public class P015_LC1011_ShipPackageWithinDDays {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using linear search approach
    public static int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int maxCapacity = 0;
        int maxWeight = Integer.MIN_VALUE;
        for(int ind = 0; ind < n; ind++){
            maxWeight = Math.max(maxWeight, weights[ind]);
            maxCapacity += weights[ind];
        }

        for(int capacity = maxWeight; capacity<= maxCapacity; capacity++){
            if(isPossibleToShip(weights, capacity, days, n))   return capacity;
        }

        return maxCapacity;
    }


    private static boolean isPossibleToShip(int[] weights, int capacity, int days, int n){
        int currLoad = 0;
        for(int w : weights){
            currLoad += w;

            if(currLoad > capacity){
                currLoad = w;
                days--;
            }

            if(days<= 0)    return false;
        }

        return true;
    }
}
