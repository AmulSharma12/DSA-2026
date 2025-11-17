package S002_Recursion;
import java.util.List;
import java.util.ArrayList;

public class P028_LC60_PermutationSequence {
    public static void main(String[] args){
        //call from here...
    }

    public static String getPermutation(int n, int k) {
        List<String> result = new ArrayList<>();
        boolean[] isVisited = new boolean[n];
        generateAllPermutations(0, new StringBuilder(), isVisited, result, n);
        return result.get(k-1);
    }

    private static void generateAllPermutations(int index, StringBuilder sb,boolean[] isVisited ,List<String> result, int size){
        if(sb.length() == size){
            // System.out.println(sb.toString());
            result.add(sb.toString());
            return;
        }

        for(int i = 0; i < size; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                sb.append(i+1);
                generateAllPermutations(index+1, sb,isVisited, result, size);
                sb.deleteCharAt(sb.length() - 1);
                isVisited[i] = false;
            }
        }
    }
}
