package S007_Tree;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;




public class P010_PrePostInOrderTraversalUsingSingleStack {
    static List<Integer> preOrderList ;
    static List<Integer> inOrderList ;
    static List<Integer> postOrderList;


    public static void main(String[] args){
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(3);

        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);

        constructDFSTraversals(root);

        System.out.println("Preorder : " + preOrderList);
        System.out.println("Inorder  : " + inOrderList);
        System.out.println("Postorder: " + postOrderList);
    }

    static class Pair{
        TreeNode node;
        int num;

        public Pair(TreeNode node, int num){
            this.node = node;
            this.num = num;
        }
    }

    private static void constructDFSTraversals(TreeNode root){
        if(root == null)    return;
       preOrderList = new ArrayList<>();
        inOrderList = new ArrayList<>();
        postOrderList = new ArrayList<>();

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));
        while(!st.isEmpty()){
            Pair pair = st.pop();

            if(pair.num == 1){
                preOrderList.add(pair.node.val);
                pair.num++;
                st.push(pair);

                if(pair.node.left != null)  st.push(new Pair(pair.node.left, 1));
            }

            else if(pair.num == 2){
                inOrderList.add(pair.node.val);
                pair.num++;
                st.push(pair);

                if(pair.node.right != null) st.push(new Pair(pair.node.right, 1));
            }else{
                postOrderList.add(pair.node.val);
            }
        }


    }

}
