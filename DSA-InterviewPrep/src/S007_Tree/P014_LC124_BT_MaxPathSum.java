package S007_Tree;

public class P014_LC124_BT_MaxPathSum {
    public static void main(String[] args){
        //call from here...
    }


    private static int maxi = Integer.MIN_VALUE;
    //Approach 1 - using all the scenarios
    public static int maxPathSum(TreeNode root) {
        dfs(root);
        return maxi;
    }

    private static int dfs(TreeNode root){
        if(root == null)    return 0;

        int leftGain = Math.max(0, dfs(root.left));
        int rightGain = Math.max(0, dfs(root.right));

        maxi = Math.max(
                maxi,
                root.val + leftGain + rightGain
        );

        return root.val + Math.max(leftGain, rightGain);
    }
}
