package S007_Tree;
//https://leetcode.com/problems/binary-tree-preorder-traversal/description/
class Node{
    int data;
    Node left;
    Node right;

    public Node(int value){
        this.data = value;
    }
}


public class P002_LC144_PreOrderUsingRecursion{
    public static void main(String[] args){
        Node rootNode = constrcutTree();
        preOrder(rootNode);
    }

    private static void preOrder(Node rootNode){
        if(rootNode == null)    return;
        System.out.print(rootNode.data + " ");

        preOrder(rootNode.left);
        preOrder(rootNode.right);
    }

    private static Node constrcutTree(){
        Node rootNode = new Node(5);
        Node leftNode = new Node(4);
        Node rightNode = new Node(6);

        rootNode.left = leftNode;
        rootNode.right = rightNode;
        return rootNode;
    }
}