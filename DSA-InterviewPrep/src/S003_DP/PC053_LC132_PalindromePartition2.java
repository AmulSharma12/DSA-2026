package S003_DP;
//https://leetcode.com/problems/palindrome-partitioning-ii/
public class PC053_LC132_PalindromePartition2 {
    public static void main(String[] args){
        //call from here...
    }

    //recursive solution
    public static int minCutR(String s) {
        int n = s.length();
        return minCutRecursive(0, n, s) - 1;
    }

    private static boolean isPalindrome(int i, int j, String s){
        while(i < j)    {
            if(s.charAt(i) != s.charAt(j))  return false;
            i++;
            j--;
        }

        return true;
    }

    private static int minCutRecursive(int ind, int n, String s){
        if(ind == n)    return 0;

        int minCost = Integer.MAX_VALUE;

        for(int j = ind; j < n; j++){
            if(isPalindrome(ind,j, s)){
                int cost = 1 + minCutRecursive(j+1, n, s);
                minCost = Math.min(minCost, cost);
            }
        }

        return minCost;
    }
}
