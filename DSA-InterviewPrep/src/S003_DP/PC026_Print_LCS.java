package S003_DP;

public class PC026_Print_LCS {
    public static void main(String[] args){
        //call from here...
        StringBuilder subsequence = lcsTabulation("abcde", "bdgek");
        System.out.println(subsequence.toString());
    }

    //tabulation solution
    private static StringBuilder lcsTabulation(String text1, String text2){
        //base case
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];

        //shifted to each at right because negative base cases so 0th index treated as -1 base case  thats why for state N index pick would be index-1

        for(int j = 0; j<=m ; j++)   dp[0][j] = 0;
        for(int i = 0; i<=n; i++)    dp[i][0] = 0;

        //match and not match cases
        for(int ind1 = 1; ind1 <= n; ind1++){
            for(int ind2 = 1; ind2 <= m; ind2++){
                if(text1.charAt(ind1 - 1) == text2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                else
                    dp[ind1][ind2] = Math.max(dp[ind1-1][ind2], dp[ind1][ind2-1]);
            }
        }

        int i = n;
        int j = m;
        int size = dp[n][m];
        StringBuilder result = new StringBuilder("$".repeat(size));
        while(i>0 && j>0){
            if(text1.charAt(i-1) == text2.charAt(j-1)){
                result.setCharAt(size-1, text1.charAt(i-1));
                size--;
                i--;
                j--;
            }else{
                if(dp[i-1][j] > dp[i][j-1]) i--;
                else j--;
            }
        }

        return result;
    }

}
