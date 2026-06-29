package S007_Tree;
import java.util.LinkedList;
import java.util.Queue;
//https://leetcode.com/problems/maximum-width-of-binary-tree/description/

public class P025_LC662_MaxWidthOfBT {
    public static void main(String[] args){
        //call from here...
    }


    static class Pair{
        TreeNode node;
        int index;

        public Pair(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }

    //Approach 1 - using level order traversal
    public static int widthOfBinaryTree(TreeNode root) {
        if(root == null)    return 0;
        int maxWidth = Integer.MIN_VALUE;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while(!queue.isEmpty()){
            int size = queue.size();
            int left = 0;
            int right = 0;
            int min = queue.peek().index;

            for(int ind = 0; ind < size; ind++){
                Pair pair = queue.poll();
                int currId = pair.index - min;
                TreeNode node = pair.node;

                if(ind == 0)    left = pair.index;
                if(ind == size-1) right = pair.index;

                if(node.left != null)
                    queue.offer(new Pair(node.left, 2*currId+1));

                if(node.right != null)
                    queue.offer(new Pair(node.right, 2*currId+2));
            }


            maxWidth = Math.max(maxWidth, right -left + 1);
        }

        return maxWidth;
    }
}
