package S002_Recursion;

public class P009_Basic_StringPalindromeOrNot {
    public static void main(String[] args){
        String inputString = "maxxam";
        System.out.println(isPalindromeOrNot(inputString, 0, inputString.length())? "String is  Palindrome" : "String is not palindrome");
    }


    private static boolean isPalindromeOrNot(String inputString, int currInd, int size){
        if(currInd >= size/2)   return true;
        if(inputString.charAt(currInd) != inputString.charAt(size-1-currInd))   return false;
        return isPalindromeOrNot(inputString, currInd+1, size);
    }
}
