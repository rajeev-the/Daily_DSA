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
    List<Integer>  res;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer>  res1 = new ArrayList<>();
         List<Integer>  res2 = new ArrayList<>();
          created(root1,res1);
          created(root2,res2);
          if(res1.size() !=  res2.size()) return false;


          return res1.equals(res2) ;       
    }
    public void created(TreeNode root, List<Integer> list ){
           
           if(root.left == null && root.right == null){
                list.add(root.val);
           }

           if(root.left != null) created(root.left,list);
           if(root.right != null) created(root.right,list);
    }

}