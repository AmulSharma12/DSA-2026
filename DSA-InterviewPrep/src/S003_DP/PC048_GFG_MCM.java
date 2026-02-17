package S003_DP;
//https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
public class PC048_GFG_MCM {
    public static void main(String[] args){
        //call from here...
    }

    //Recursive solution
    static int matrixMultiplicationR(int arr[]) {
        int n = arr.length;
        return mcmRecursive(1, n-1, arr);
    }

    private static int mcmRecursive(int i, int j, int[] arr){
        if(i == j)  return 0;


        int mini = Integer.MAX_VALUE;
        for(int k = i; k<j; k++){
            int steps = arr[i-1] * arr[k] * arr[j] + mcmRecursive(i, k, arr) + mcmRecursive(k+1, j, arr);
            mini = Math.min(mini, steps);
        }

        return mini;
    }
}
