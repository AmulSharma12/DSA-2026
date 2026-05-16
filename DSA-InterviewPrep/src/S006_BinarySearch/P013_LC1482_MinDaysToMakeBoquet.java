package S006_BinarySearch;
//https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
public class P013_LC1482_MinDaysToMakeBoquet {
    public static void main(String[] args){
        //call from here...
    }


    //Approach 1- using linear search way
    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        //if exceed more than number of the flowers
        if((long)m*k > n)   return  -1;

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for(int ind = 0; ind < n; ind++){
            minValue = Math.min(minValue, bloomDay[ind]);
            maxValue = Math.max(maxValue, bloomDay[ind]);
        }

        for(int day = minValue; day<= maxValue; day++){
            boolean isPossible = isPossibleToMakeBoquet(day, bloomDay, m, k, bloomDay.length);
            if(isPossible)  return day;
        }


        return -1;
    }


    private static boolean isPossibleToMakeBoquet(int day, int[] bloomDay, int m, int k, int n){
        int numberOfFlowers = 0;
        int numberOfBoquet = 0;

        for(int ind = 0; ind < n; ind++){
            if(bloomDay[ind] <= day)
                numberOfFlowers++;
            else{
                numberOfBoquet += (numberOfFlowers/k);
                numberOfFlowers = 0;
            }
        }


        numberOfBoquet += (numberOfFlowers/k);

        if(numberOfBoquet >= m) return true;
        return false;
    }
}
