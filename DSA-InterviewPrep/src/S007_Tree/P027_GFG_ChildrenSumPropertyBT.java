package S007_Tree;
//https://www.geeksforgeeks.org/problems/children-sum-parent/1
public class P027_GFG_ChildrenSumPropertyBT {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - tracking for each node left and right if all good check for left/right subtree
    public static boolean isSumProperty(Node root) {
        return isSumPropertyValid(root);
    }

    private static boolean isSumPropertyValid(Node node){
        if(node == null)    return true;
        if(node.left == null && node.right == null)    return true;

        //checking root value and left and right child values
        int leftValue = node.left == null ? 0 : node.left.data;
        int rightValue = node.right == null ? 0 : node.right.data;

        if(node.data != (leftValue + rightValue))   return false;

        return isSumPropertyValid(node.left) && isSumPropertyValid(node.right);
    }
}
