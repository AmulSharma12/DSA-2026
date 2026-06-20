package S007_Tree;

//https://leetcode.com/problems/symmetric-tree/

public class P022_LC101_CheckSymmetricBT {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using invert left subtree and checking left & right subtree is identical or not for symmetric
    public static boolean isSymmetric(TreeNode root) {
        invertTree(root.left);
        return isIdentical(root.left, root.right);
    }

    private static boolean isIdentical(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null)  return true;
        if(node1 == null || node2 == null)  return false;

        if(node1.val != node2.val)  return false;

        return  isIdentical(node1.left, node2.left) &&
                isIdentical(node1.right , node2.right);
    }

    private static void invertTree(TreeNode node){
        if(node == null)    return;
        TreeNode leftNode = node.left;
        TreeNode rightNode = node.right;

        node.left = rightNode;
        node.right = leftNode;

        invertTree(node.left);
        invertTree(node.right);
    }


    //Approach 2 - checking both left/right subtree based on pre-order and reverse pre-order
    public static boolean isSymmetricOptimization(TreeNode root) {
        return checkSymmetry(root.left, root.right);
    }

    private static boolean checkSymmetry(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null)  return true;
        if(node1 == null || node2 == null)  return false;
        if(node1.val != node2.val)  return false;

        return checkSymmetry(node1.left, node2.right) &&
                checkSymmetry(node1.right, node2.left);
    }
}
