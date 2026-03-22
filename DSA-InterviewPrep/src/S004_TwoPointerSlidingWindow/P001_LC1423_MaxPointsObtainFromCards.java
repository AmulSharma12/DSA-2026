package S004_TwoPointerSlidingWindow;
//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
public class P001_LC1423_MaxPointsObtainFromCards {
    public static void main(String[] args){
        //call from here...
    }


    private static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int leftSum = 0;
        int rightSum = 0;
        int rightInd = n-1;
        for(int ind = 0; ind < k; ind++){
            leftSum += cardPoints[ind];
        }

        int maxPoints = leftSum;
        for(int leftInd = k-1; leftInd >= 0; leftInd--){
            leftSum -= cardPoints[leftInd];
            rightSum += cardPoints[rightInd];
            rightInd--;
            maxPoints = Math.max(maxPoints, leftSum + rightSum);
        }

        return maxPoints;
    }
}
