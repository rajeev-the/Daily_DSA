/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public int widthOfBinaryTree(TreeNode root) {

        if(root == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));

        int midwidth = 0;

        while(!q.isEmpty()){

            int size = q.size();
            int minindex = q.peek().index;

            int first = 0;
            int last = 0;

            for(int i =0 ; i < size ; i++){
                
                Pair p =  q.poll();
                TreeNode node = p.node;
                int index = p.index - minindex;

                if(i == 0) first = index;
                if(i == size -1) last = index;

                if(node.left != null){
                    q.offer(new Pair(node.left,2*index+1));
                }
                if(node.right != null){
                  q.offer(new Pair(node.right,2*index+2));
                }

                
                midwidth = Math.max(midwidth ,last-first+1);
            }
        }

        return midwidth;
        
    }
    class Pair{
        TreeNode node;
        int index ;
         Pair(TreeNode node , int index){
            this.node = node;
            this.index = index;
         }
    }
}

// replace the null to dummy node until the left highest level  
// and then level order traverse at lowest and count the node