package S007_Tree;
import java.util.List;
import java.util.ArrayList;
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

public class P024_LC236_LCA_BT {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using root to node path and storing both path in separte datastructure and returning the last matched node
    public static TreeNode lowestCommonAncestorBrute(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pNodePath = new ArrayList<>();
        List<TreeNode> qNodePath = new ArrayList<>();

        generatePath(root, p, pNodePath);
        generatePath(root, q, qNodePath);

        TreeNode lca = root;
        int psize = pNodePath.size();
        int qsize = qNodePath.size();
        int pInd = 0;
        int qInd = 0;


        while(pInd < psize ){
            System.out.print(pNodePath.get(pInd).val + " ");

            pInd++;

        }

        System.out.println();
        while(qInd < qsize){

            System.out.print(qNodePath.get(qInd).val + " ");

            qInd++;
        }

        pInd = 0;
        qInd = 0;

        while(pInd < psize && qInd < qsize){
            if(pNodePath.get(pInd).val != qNodePath.get(qInd).val)  break;
            lca = pNodePath.get(pInd);
            pInd++;
            qInd++;
        }


        return lca;
    }


    private static boolean generatePath(TreeNode root, TreeNode target, List<TreeNode> path) {

        if (root == null)
            return false;

        path.add(root);

        if (root == target)
            return true;

        if (generatePath(root.left, target, path))
            return true;

        if (generatePath(root.right, target, path))
            return true;

        path.remove(path.size() - 1);

        return false;
    }


    //Approach 2 - using optimization technique
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)    return root;
        if(root == p || root == q)  return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);

        if(left != null && right != null)   return root;

        return left == null ? right : left;
    }
}
