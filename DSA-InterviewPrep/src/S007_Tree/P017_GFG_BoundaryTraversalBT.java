package S007_Tree;
import java.util.List;
import java.util.ArrayList;

//https://leetcode.com/problems/boundary-of-binary-tree/description/
//https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1

public class P017_GFG_BoundaryTraversalBT {
    public static void main(String[] args){
        //call from here...
    }



    static boolean isLeafNode(Node node){
        if(node.left == null && node.right == null) return true;
        return false;
    }

    static void addRightBoundary(Node node, ArrayList<Integer> result){
        List<Integer> temp = new ArrayList<>();
        while(node != null){
            if(!isLeafNode(node))   temp.add(node.data);
            if(node.right != null)  node = node.right;
            else node = node.left;
        }


        for(int ind = temp.size()-1; ind >= 0; ind--){
            result.add(temp.get(ind));
        }
    }

    static void addLeafNodes(Node node, ArrayList<Integer> result){
        if(isLeafNode(node)){
            result.add(node.data);
            return;
        }

        if(node.left != null)   addLeafNodes(node.left, result);
        if(node.right != null)  addLeafNodes(node.right, result);
    }

    static void addLeftBoundary(Node node, ArrayList<Integer> res){
        while(node != null){
            if(!isLeafNode(node))   res.add(node.data);
            if(node.left != null)   node = node.left;
            else node = node.right;
        }
    }

    static ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(!isLeafNode(root))    result.add(root.data);

        addLeftBoundary(root.left, result);
        addLeafNodes(root, result);
        addRightBoundary(root.right, result);

        return result;
    }

}
