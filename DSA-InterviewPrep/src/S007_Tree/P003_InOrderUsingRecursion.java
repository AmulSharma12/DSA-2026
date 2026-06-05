package S007_Tree;

public class P003_InOrderUsingRecursion {
    public static void main(String[] args){
        Node rootNode = constrcutTree();
        inOrderTraversal(rootNode);
    }

    private static void inOrderTraversal(Node rootNode){
        if(rootNode == null)    return;

        inOrderTraversal(rootNode.left);
        System.out.print(rootNode.data + " ");
        inOrderTraversal(rootNode.right);
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
