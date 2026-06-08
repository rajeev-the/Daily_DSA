/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(root == p || root == q) return root;

       TreeNode lcaright = lowestCommonAncestor(root.left,p,q);
       TreeNode  lcaleft = lowestCommonAncestor(root.right,p,q);
         
         if(lcaright != null && lcaleft != null){
            return root;
         }
         else if(lcaright != null){
            return lcaright;
         }
         else{
           return  lcaleft;
         }
    }
}