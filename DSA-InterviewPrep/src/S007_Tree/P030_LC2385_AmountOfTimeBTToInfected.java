package S007_Tree;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
public class P030_LC2385_AmountOfTimeBTToInfected {
    public static void main(String[] args){
        //call from here...
    }

    public static int amountOfTime(TreeNode root, int start) {
        Map<Integer , List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        buildGraph(root, null, map);

        queue.offer(start);
        visited.add(start);
        int minTime = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int ind = 0; ind < size; ind++){
                int neighbour = queue.poll();

                for(Integer node: map.getOrDefault(neighbour , new ArrayList<>())){
                    if(!visited.contains(node)){
                        visited.add(node);
                        queue.offer(node);
                    }
                }
            }

            if(!queue.isEmpty())
                minTime++;
        }


        return minTime;
    }


    private static void buildGraph(TreeNode node, TreeNode parent, Map<Integer, List<Integer>> map){
        if(node == null)    return;

        if(parent != null){
            map.computeIfAbsent(node.val , k -> new ArrayList<>()).add(parent.val);
            map.computeIfAbsent(parent.val , k -> new ArrayList<>()).add(node.val);
        }

        buildGraph(node.left, node, map);
        buildGraph(node.right, node, map);
    }
}
