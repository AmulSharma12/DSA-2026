package S007_Tree;
//https://leetcode.com/problems/count-complete-tree-nodes/description/
public class P031_LC222_CountCompleteTreeNodes {
    public static void main(String[] args){
        //call from here...
    }

    public static int countNodes(TreeNode root) {
        if(root == null)    return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
