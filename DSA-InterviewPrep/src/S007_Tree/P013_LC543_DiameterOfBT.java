package S007_Tree;

public class P013_LC543_DiameterOfBT {

    public static void main(String[] args){
        //call from here...
    }

    static int maxi = 0;
    //Approach 1 - Brute force approach
    public static int diameterOfBinaryTreeBrute(TreeNode root) {
        if(root == null)    return 0;

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        diameterOfBinaryTreeBrute(root.left);
        diameterOfBinaryTreeBrute(root.right);
        return maxi = Math.max(maxi, leftHeight+rightHeight);
    }

    private static int findHeight(TreeNode root){
        if(root == null)    return 0;

        int leftDepth = findHeight(root.left);
        int rightDepth = findHeight(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }

    //Approach 2 - using single traversal
    public static int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        findMax(root, diameter);
        return diameter[0];
    }

    private static int findMax(TreeNode root, int[] diameter){
        if(root == null)    return 0;

        int leftHeight = findMax(root.left, diameter);
        int rightHeight = findMax(root.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
