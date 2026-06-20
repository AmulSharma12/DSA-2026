package S007_Tree;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Queue;
import java.util.LinkedList;

//https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1

public class P020_GFG_BottomViewBT {
    public static void main(String[] args){
        //call from here...
    }

    static class Pair{
        Node node;
        int col;

        public Pair(Node node, int col){
            this.node = node;
            this.col = col;
        }
    }

    public static  ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> bottomView = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        queue.offer(new Pair(root, 0));

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            Node node = pair.node;
            int col = pair.col;

            map.put(col, node.data);

            if(node.left != null)
                queue.offer(new Pair(node.left, col-1));

            if(node.right != null)
                queue.offer(new Pair(node.right, col+1));
        }


        //traversing the treemap
        for(Integer val : map.values())
            bottomView.add(val);


        return bottomView;

    }
}
