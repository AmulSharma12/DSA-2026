package S007_Tree;
//https://leetcode.com/problems/balanced-binary-tree/description/
public class P012_LC110_HeightBalancedBT {
    public static void main(String[] args){
        // call from here...
    }

    //Approach 1- Brute force approach
    public boolean isBalancedBrute(TreeNode root) {
        if(root == null)    return true;

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1)  return false;
        boolean leftCall = isBalancedBrute(root.left);
        boolean rightCall = isBalancedBrute(root.right);

        if(!leftCall || !rightCall) return false;
        return true;

    }

    private int findHeight(TreeNode root){
        if(root == null)    return 0;

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }


    //Approach 2 - using depth of binary tree
    public boolean isBalanced(TreeNode root) {
        return checkHeightBalanced(root) != -1;
    }

    private static int checkHeightBalanced(TreeNode root){
        if(root == null)    return 0;

        int leftDepth = checkHeightBalanced(root.left);
        int rightDepth = checkHeightBalanced(root.right);

        if(leftDepth == -1 || rightDepth == -1) return -1;
        if(Math.abs(leftDepth - rightDepth) > 1) return -1;

        return 1 + Math.max(leftDepth, rightDepth);
    }
}
