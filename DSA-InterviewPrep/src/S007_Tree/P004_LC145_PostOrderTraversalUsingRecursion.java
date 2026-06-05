package S007_Tree;
import java.util.List;
import java.util.ArrayList;
//https://leetcode.com/problems/binary-tree-postorder-traversal/description/
public class P004_LC145_PostOrderTraversalUsingRecursion {
    public static void main(String[] args){
        Node rootNode = constrcutTree();
        postorderTraversal(rootNode);
    }


    private static Node constrcutTree(){
        Node rootNode = new Node(5);
        Node leftNode = new Node(4);
        Node rightNode = new Node(6);

        rootNode.left = leftNode;
        rootNode.right = rightNode;
        return rootNode;
    }


    public static List<Integer> postorderTraversal(Node root) {
        List<Integer> postOrderList = new ArrayList<>();
        postOrder(root, postOrderList);
        return postOrderList;
    }

    private static void postOrder(Node root, List<Integer> postOrderList){
        if(root == null)    return;
        postOrder(root.left, postOrderList);
        postOrder(root.right, postOrderList);
        postOrderList.add(root.data);
    }
}
