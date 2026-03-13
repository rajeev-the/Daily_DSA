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
    public void flatten(TreeNode root) {
        
        List<TreeNode> list = new ArrayList<>();
        preorder(list,root);

        for(int i =0 ; i < list.size() -1 ; i++){
            TreeNode curr = list.get(i);
            curr.left = null;
            curr.right = list.get(i+1);
        }

    }
    public void preorder(List<TreeNode> list , TreeNode root){
        if(root == null) return ;
        list.add(root);
        preorder(list,root.left);
        preorder(list,root.right);

    }
}