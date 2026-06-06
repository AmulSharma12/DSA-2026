package S007_Tree;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/binary-tree-preorder-traversal/

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }
}

public class P006_LC144_PreOrderUsingStack {
    public static void main(String[] args){
        //call from here...
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrderList = new ArrayList<>();
        if(root == null)    return preOrderList;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            preOrderList.add(node.val);
            if(node.right != null)  st.push(node.right);
            if(node.left != null) st.push(node.left);
        }


        return preOrderList;
    }
}
