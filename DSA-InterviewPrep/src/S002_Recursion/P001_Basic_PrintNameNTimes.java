package S002_Recursion;

public class P001_Basic_PrintNameNTimes {
     public static void main(String[] args){
          //demo call from here to check it out
          printNameNTimes(5);
     }

     //function to print the name n times using recursion
     private static void  printNameNTimes(int n){
          if(n == 0)     return;
          System.out.println("Amul Sharma");
          printNameNTimes(n-1);
     }
}
