package S007_Tree;

public class P028_ConvertBTFollowsChildrenSumProperty {
    public static void main(String[] args){
        //call from here...
    }

    private void changeBTFollowChildrenSumProperty(TreeNode node){
        if(node == null)    return;

        //tracking node childSum
        int childSum = 0;
        if(node.left != null)   childSum += node.left.val;
        if(node.right != null)  childSum += node.right.val;

        //maximize for particular node their children's
        if(childSum >= node.val)    node.val = childSum;
        else{
            if(node.left != null)   node.left.val = node.val;
            if(node.right != null)  node.right.val = node.val;
        }

        //checking for left and right
        changeBTFollowChildrenSumProperty(node.left);
        changeBTFollowChildrenSumProperty(node.right);

        int total = 0;
        if(node.left != null)   total += node.left.val;
        if(node.right != null)  total += node.right.val;

        if(node.left != null || node.right != null)  node.val = total;

    }
}
