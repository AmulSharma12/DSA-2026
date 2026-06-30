package S007_Tree;
//https://leetcode.com/problems/root-equals-sum-of-children/
public class P026_LC2236_RootEqualSumOFChild {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using recursive logic approach
    public static boolean checkTree(TreeNode root) {
        return root.val == (root.left.val + root.right.val);
    }
}
