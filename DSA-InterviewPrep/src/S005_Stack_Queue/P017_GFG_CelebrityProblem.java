package S005_Stack_Queue;
//https://www.geeksforgeeks.org/problems/the-celebrity-problem/1
public class P017_GFG_CelebrityProblem {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using brute and naive approach
    public static int celebrityBrute(int mat[][]) {
        int n = mat.length;
        int[] iKnow = new int[n];
        int[] knowMe = new int[n];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(mat[i][j] == 1){
                    iKnow[i]++;
                    knowMe[j]++;
                }
            }
        }


        //System.out.println(Arrays.toString(iKnow));
        //System.out.println(Arrays.toString(knowMe));
        for(int ind = 0; ind <n; ind++){
            if(iKnow[ind] == 1 && knowMe[ind] == n) return ind;
        }


        return -1;
    }
}
