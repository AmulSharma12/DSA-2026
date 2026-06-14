package S007_Tree;

public class P013_LC543_DiameterOfBT {

    public static void main(String[] args){
        //call from here...
    }

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
