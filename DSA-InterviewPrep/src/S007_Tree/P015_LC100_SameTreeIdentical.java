package S007_Tree;
//https://leetcode.com/problems/same-tree/description/

public class P015_LC100_SameTreeIdentical {
    public static void main(String[] args){
        //call from here...
    }


    //Approach 1 - visiting each node at the same time and checking
    public static  boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)  return true;
        if((p == null && q != null)  || (p != null && q == null))   return false;
        if(p.val != q.val)  return false;
        boolean leftIdentical = isSameTree(p.left, q.left);
        boolean rightIdentical = isSameTree(p.right, q.right);

        return leftIdentical && rightIdentical;

    }
}
