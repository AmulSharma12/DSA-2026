package S007_Tree;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/

public class P018_LC987_VerticalOrderTraversalBT {
    public static void main(String[] args){
        //call from here...
    }


    static class Tuple{
        TreeNode node;
        int row;
        int col;

        public Tuple(TreeNode node, int row, int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();

        queue.offer(new Tuple(root, 0, 0));

        while(!queue.isEmpty()){
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int row = tuple.row;
            int col = tuple.col;

            if(!map.containsKey(col))
                map.put(col, new TreeMap<>());

            if(!map.get(col).containsKey(row))
                map.get(col).put(row, new PriorityQueue<>());

            map.get(col).get(row).offer(node.val);


            // left and right if exist put into queue
            if(node.left != null)
                queue.offer(new Tuple(node.left, row+1, col-1));

            if(node.right != null)
                queue.offer(new Tuple(node.right, row+1, col+1));

        }


        //traversing column for each row
        for(TreeMap<Integer, PriorityQueue<Integer>> verticalOrder: map.values()){
            result.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes: verticalOrder.values()){
                while(!nodes.isEmpty()){
                    result.get(result.size()-1).add(nodes.poll());
                }
            }
        }

        return result;
    }
}
