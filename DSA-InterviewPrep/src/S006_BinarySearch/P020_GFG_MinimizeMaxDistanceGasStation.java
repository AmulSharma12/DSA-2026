package S006_BinarySearch;
import java.util.PriorityQueue;
//https://www.geeksforgeeks.org/problems/minimize-max-distance-to-gas-station/1
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



     static class  Pair{
        double value;
        int ind;

        public Pair(double value, int ind){
            this.value = value;
            this.ind = ind;
        }
    }


    //Approach 2-using priority queue
    public static double minMaxDistUsinPQ(int[] stations, int k) {
        int n = stations.length;
        if(n == 1)  return 0.0;
        int[] howMany = new int[n-1];

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a,b) -> Double.compare(b.value, a.value)
        );

        for(int ind = 0; ind < n-1; ind++){
            pq.offer(new Pair(stations[ind+1]-stations[ind], ind));
        }

        for(int ind = 1; ind <= k; ind++){
            Pair maxPair = pq.poll();
            int sectionInd = maxPair.ind;
            howMany[sectionInd]++;
            double diff = stations[sectionInd+1] - stations[sectionInd];
            double sectionLength = diff/(double)(howMany[sectionInd]+1);
            pq.offer(new Pair(sectionLength, sectionInd));
        }

        return pq.peek().value;
    }
}
