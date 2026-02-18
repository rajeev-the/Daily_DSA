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
    Map<Integer,TreeNode> map = new HashMap<>();
    Set<Integer>  leaves = new HashSet<>();
    public TreeNode canMerge(List<TreeNode> trees) {
        

        /// stored the all the tree in map
        for(TreeNode  root : trees){
            map.put(root.val,root);

        }

        /// collect leaf values

        for(TreeNode  root : trees){
             
             if(root.left != null){
                leaves.add(root.left.val);
             }
             if(root.right != null){
                leaves.add(root.right.val);
             }
        }

        //  find finalroot val  val

        TreeNode finalroot = null;

        for(TreeNode node : trees){
            if(!leaves.contains(node.val)){
                finalroot = node;
                break;
            }
        }

        if(finalroot == null ) return null;

        map.remove(finalroot.val);

       
       if(!dfs(finalroot,Long.MIN_VALUE,Long.MAX_VALUE)){
        return null;
       }

       if(!map.isEmpty()){
        return null;
       }
        

       return finalroot;

    }

    public boolean dfs(TreeNode node , long min , long max){
         
         if(node == null) return true;

         if(node.val <=  min || node.val >= max){
            return false;
         }
         if(node.left == null && node.right == null && map.containsKey(node.val)){
            TreeNode mergetree = map.get(node.val);
            node.left = mergetree.left;
            node.right = mergetree.right;
            map.remove(node.val);
         }

         return dfs(node.left, min,node.val) && dfs(node.right,node.val,max);
    }
}