package S007_Tree;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
public class P009_LC145_PostOrderUsingSingleStack {
    public static void main(String[] args){
        //call from here...
    }


    //Approach 3 - using single stack
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrderList = new ArrayList<>();
        if(root == null)    return postOrderList;
        TreeNode curr = root;
        Stack<TreeNode> st = new Stack<>();
        while(curr != null || !st.isEmpty()){
            if(curr != null){
                st.push(curr);
                curr = curr.left;
            }else{
                TreeNode temp = st.peek().right;
                if(temp == null){
                    temp = st.pop();
                    postOrderList.add(temp.val);

                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.pop();
                        postOrderList.add(temp.val);
                    }

                }else{
                    curr = temp;
                }
            }
        }

        return postOrderList;
    }
}
