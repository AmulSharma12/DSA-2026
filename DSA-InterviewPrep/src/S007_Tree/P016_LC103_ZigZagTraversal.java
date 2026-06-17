package S007_Tree;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Collections;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

public class P016_LC103_ZigZagTraversal {
    public static void main(String[] args){
        //call from here...
    }

    //Approach 1 - using queue level order traversal
    public  static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigZagList = new ArrayList<>();
        if(root == null)    return zigZagList;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int flag = 0;  //for left to right denotion and if flag == 1 then it means right to left
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelOrderList = new ArrayList<>();

            for(int ind = 0; ind < size; ind++){
                TreeNode node = queue.poll();
                if(node.left != null)   queue.add(node.left);
                if(node.right != null)  queue.add(node.right);
                levelOrderList.add(node.val);
            }

            //if flag == 1 then must reverse the list
            if(flag == 1)
                Collections.reverse(levelOrderList);
            // make sure to update the flag to 1 if 0 exist and 0 if flag 1 exist
            flag = flag == 0 ? 1 : 0;

            //update the result
            zigZagList.add(new ArrayList<>(levelOrderList));
        }

        return zigZagList;
    }
}
