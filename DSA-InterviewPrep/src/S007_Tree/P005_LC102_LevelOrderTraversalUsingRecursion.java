package S007_Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-level-order-traversal/description/
public class P005_LC102_LevelOrderTraversalUsingRecursion {
    public static void main(String[] args){
        //call from here...
    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levelOrderList = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        if(root == null)    return levelOrderList;
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int ind = 0; ind < size; ind++){
                if(queue.peek().left != null)   queue.offer(queue.peek().left);
                if(queue.peek().right != null)  queue.offer(queue.peek().right);
                list.add(queue.poll().data);
            }
            levelOrderList.add(new ArrayList<>(list));
        }

        return levelOrderList;
    }
}
