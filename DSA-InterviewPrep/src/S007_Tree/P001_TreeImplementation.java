package S007_Tree;



public class P001_TreeImplementation {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int value){
            this.data = value;
        }
    }

    public static void main(String[] args){
        constrcutTree();
    }

    private static void constrcutTree(){
        Node rootNode = new Node(5);
        Node leftNode = new Node(4);
        Node rightNode = new Node(6);

        rootNode.left = leftNode;
        rootNode.right = rightNode;
    }
}
