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

    //Approach 2 - elimination pattern
    //If A knows B - A can't be celebrity
    //IF A don't know B - B can't be celebrity
    public static int celebrityOptimized(int mat[][]) {
        int n = mat.length;
        int top = 0;
        int down = n-1;

        while(top < down){
            if(mat[top][down] == 1)
                top++;
            else if(mat[down][top] == 1)
                down--;
            else{
                top++;
                down--;
            }
        }

        if(top > down)  return -1;

        for(int ind = 0; ind <n; ind++){
            if(ind == top)  continue;

            if(mat[top][ind] == 0 && mat[ind][top] == 1){}
            else return -1;
        }

        return top;

    }
}
