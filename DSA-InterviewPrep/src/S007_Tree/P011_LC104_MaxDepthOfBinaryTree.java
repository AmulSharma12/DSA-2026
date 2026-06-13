package S007_Tree;
//https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
public class P011_LC104_MaxDepthOfBinaryTree {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using recursive approach
    public static int maxDepth(TreeNode root) {
        if(root == null)    return 0;

        int leftDepth = 0;
        int rightDepth = 0;

        if(root.left != null)
            leftDepth = maxDepth(root.left);
        if(root.right != null)
            rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}
