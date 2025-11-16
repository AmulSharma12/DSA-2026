package S002_Recursion;
import java.util.List;
import java.util.ArrayList;

public class P025_LC131_PalindromePartition {
    public static void main(String[] args){
        //call from here...
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        palindromePartition(0, new ArrayList<>(), result, s, s.length());
        return result;
    }

    private static void palindromePartition(int index, List<String> path, List<List<String>> result, String inputString, int length){
        //base case
        if(index == length){
            result.add(new ArrayList<>(path));
            return;
        }

        //trying out all possible parition from index - if its valid palindrome partition
        for(int i = index; i<length; i++){
            if(isValidPalindrome(inputString, index, i)){
                path.add(inputString.substring(index, i+1));
                palindromePartition(i+1, path, result, inputString, length);
                path.remove(path.size() - 1);
            }
        }
    }


    private static boolean isValidPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--))    return false;
        }

        return true;
    }
}
