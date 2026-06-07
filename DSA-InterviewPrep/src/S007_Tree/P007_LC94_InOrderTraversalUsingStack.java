package S007_Tree;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/binary-tree-inorder-traversal/description/
public class P007_LC94_InOrderTraversalUsingStack {
    public static void main(String[] arsg){
        //call from here...
    }


    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrderList = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while(true){
            if(node != null){
                st.push(node);
                node = node.left;
            }else{
                if(st.isEmpty())    break;
                TreeNode popNode = st.pop();
                inOrderList.add(popNode.val);
                node = popNode.right;
            }
        }

        return inOrderList;
    }
}
