package S007_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/binary-tree-postorder-traversal/description/
public class P008_LC145_PostOrderTraversalUsingStack {
    public static void main(String[] args){
        //call from here...
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrder = new ArrayList<>();
        if(root == null)    return postOrder;

        Stack<TreeNode> st1 = new Stack<>();
        st1.push(root);
        Stack<TreeNode> st2 = new Stack<>();
        while(!st1.isEmpty()){
            TreeNode node = st1.pop();
            if(node.left != null)   st1.push(node.left);
            if(node.right != null)  st1.push(node.right);
            st2.push(node);

        }


        while(!st2.isEmpty()){
            postOrder.add(st2.pop().val);
        }

        return postOrder;
    }
}
