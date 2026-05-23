package S006_BinarySearch;

public class P020_GFG_MinimizeMaxDistanceGasStation {
    public static void main(String[] args){
        //call from here...
    }


    //Approach 1 - using brute force approach
    public static double minMaxDistBruteForceApproach(int[] stations, int k) {
        int n = stations.length;
        if (n == 1) return 0.0;
        int[] howManyStation = new int[n-1];

        for(int station = 1; station <=k ; station++){
            double maxSection = -1;
            int maxInd = -1;

            for(int ind = 0; ind < n-1; ind++){
                double diff = stations[ind+1] - stations[ind];
                double sectionLen = diff/(double)(howManyStation[ind]+1);

                if(sectionLen > maxSection){
                    maxSection = sectionLen;
                    maxInd = ind;
                }
            }

            howManyStation[maxInd]++;

        }


        //scan through each gas station after the placement
        double maxAns = 0;

        for(int ind = 0; ind < n-1; ind++){
            double diff = stations[ind+1] - stations[ind];
            double sectionLen = diff/(double)(howManyStation[ind]+1);
            maxAns = Math.max(maxAns, sectionLen);
        }

        return maxAns;


    }
}
