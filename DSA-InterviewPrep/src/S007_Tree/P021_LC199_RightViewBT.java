package S007_Tree;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;

//https://leetcode.com/problems/binary-tree-right-side-view/description/

public class P021_LC199_RightViewBT {
    public static void main(String[] args){
        //call from here...
    }

    static class Pair{
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideView = new ArrayList<>();
        if(root == null)    return rightSideView;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        HashMap<Integer, Integer> map = new HashMap<>();

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int level = pair.level;

            map.put(level, node.val);

            if(node.left != null)
                queue.offer(new Pair(node.left, level+1));
            if(node.right != null)
                queue.offer(new Pair(node.right, level+1));
        }


        //trvaersing map
        for(Integer val: map.values()){
            rightSideView.add(val);
        }

        return rightSideView;
    }



    //Approach 2 - using recursive way
    public static List<Integer> rightSideViewRecursiveApproach(TreeNode root) {
        List<Integer> rightSideView = new ArrayList<>();
        if(root == null)    return rightSideView;

        rsvHelper(root, 0, rightSideView);
        return rightSideView;
    }


    private static void rsvHelper(TreeNode node, int level, List<Integer> rightSideView){
        if(node == null)    return;
        if(level == rightSideView.size())   rightSideView.add(node.val);

        rsvHelper(node.right, level+1, rightSideView);
        rsvHelper(node.left, level+1, rightSideView);
    }
}
