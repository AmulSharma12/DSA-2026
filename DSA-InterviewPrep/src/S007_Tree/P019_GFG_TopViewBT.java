package S007_Tree;
import java.util.Queue;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.ArrayList;
//https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1

public class P019_GFG_TopViewBT {
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

    public static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> topView = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        queue.offer(new Pair(root, 0));

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            Node node = pair.node;
            int col = pair.col;

            if(!map.containsKey(col))
                map.put(col, node.data);

            if(node.left != null)
                queue.offer(new Pair(node.left, col-1));

            if(node.right != null)
                queue.offer(new Pair(node.right, col+1));
        }


        //traversing the TreeMap for finding the col -> and their respective top values
        for(Integer value:map.values()){
            topView.add(value);
        }

        //System.out.println(topView);
        return topView;

    }
}
