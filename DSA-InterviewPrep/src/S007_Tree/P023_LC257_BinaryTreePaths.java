package S007_Tree;
import java.util.List;
import java.util.ArrayList;

//https://leetcode.com/problems/binary-tree-paths/description/

public class P023_LC257_BinaryTreePaths {
    public static void main(String[] args){
        //call from here...
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> treePath = new ArrayList<>();
        findPath(root, new StringBuilder(), treePath);
        return treePath;
    }

    private static boolean isLeafNode(TreeNode node){
        if(node.left == null && node.right == null) return true;
        return false;
    }

    private static void findPath(TreeNode node, StringBuilder path, List<String> treePath){
        if(node == null) return;
        int length = path.length();
        path.append(node.val);

        if(isLeafNode(node))
            treePath.add(path.toString());
        else{
            path.append("->");
            findPath(node.left, path, treePath);
            findPath(node.right, path, treePath);
        }

        path.setLength(length);
    }
}
