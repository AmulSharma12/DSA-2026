package S006_BinarySearch;
//https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1
public class P011_GFG_NthRootOfNumber {
    public static void main(String[] args){
        //call from here...
    }


    //Approach 1 - using linear way
    public static int nthRoot(int n, int m) {
        int num = 1;
        if(m == 0)  return 0;

        while(num <= m){
            int ans = power(num, n);
            if(ans == m)  return num;
            if(ans > m) return -1;
            num++;
        }

        return -1;
    }


    private static int power(int num, int power){
        int finalProduct = 1;
        for(int ind = 1; ind <= power; ind++){
            finalProduct *= num;
        }

        return finalProduct;
    }
}
