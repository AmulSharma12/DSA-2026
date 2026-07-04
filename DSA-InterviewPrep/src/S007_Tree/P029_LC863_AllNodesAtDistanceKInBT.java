package S007_Tree;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
public class P029_LC863_AllNodesAtDistanceKInBT {
    public static void main(String[] args){
        //call from here...
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, null, parentMap);
        List<Integer> nodeList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        int distance = 0;
        visited.add(target);

        while(!queue.isEmpty()){
            int size = queue.size();
            if(distance == k)   break;

            for(int ind = 0; ind < size; ind++){
                TreeNode node = queue.poll();

                TreeNode parent = parentMap.get(node);
                if(parent != null && !visited.contains(parent)){
                    visited.add(parent);
                    queue.offer(parent);
                }


                if(node.left != null && !visited.contains(node.left)){
                    visited.add(node.left);
                    queue.offer(node.left);
                }

                if(node.right != null && !visited.contains(node.right)){
                    visited.add(node.right);
                    queue.offer(node.right);
                }
            }

            distance++;
        }

        while(!queue.isEmpty()){
            nodeList.add(queue.poll().val);
        }


        return nodeList;
    }

    private static void buildParentMap(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap){
        if(node == null)    return;

        parentMap.put(node, parent);

        buildParentMap(node.left, node, parentMap);
        buildParentMap(node.right, node, parentMap);
    }
}
