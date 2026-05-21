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
    public boolean isCompleteTree(TreeNode root) {
        if(root.left == null && root.right == null) return true;
        
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        boolean isfound = false;

        while(!q.isEmpty()){

            TreeNode node = q.poll();

           if( node == null){
             isfound = true;
           }
           else{

            if(isfound){
                return false;
            }
             q.offer(node.left);
            q.offer(node.right);

           }


        }
         

         return true;
    }
}