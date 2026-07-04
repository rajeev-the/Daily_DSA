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
    public List<Double> averageOfLevels(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        List<Double> ans = new  ArrayList<>();

        q.offer(root);

        while(!q.isEmpty()){    
              int size = q.size();
                double value = 0.0;
                double count = 0.0;
              for(int i =0 ; i < size ; i++){
                TreeNode curr = q.poll();
                value +=curr.val;
                count++;
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }               
              }
              ans.add(value/count);

        }

        return ans;
        
    }
}