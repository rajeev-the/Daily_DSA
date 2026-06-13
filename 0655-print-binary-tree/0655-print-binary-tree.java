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
    class Pair {
        TreeNode node;
        int row ;
        int col;
          public Pair(TreeNode node , int row , int col){
               this.node = node;
               this.row = row;
               this.col = col;
          }
    }
    public List<List<String>> printTree(TreeNode root) {
        
        List<List<String>> res = new ArrayList<>();

        int height = Height(root) -1;

        Queue<Pair> q = new LinkedList<>();

         int col = (int) Math.pow(2,height+1)-1; //col
         int row = height+1; //row
         
         List<String> sp = new ArrayList<>();

         for(int i =0 ; i< col ; i++){
            sp.add("");
         }

         for(int i =0 ; i< row ;i++){
            res.add(new ArrayList<>(sp));
         }


        q.offer(new  Pair(root,0,(col-1)/2));
       

        while(!q.isEmpty()){
             
             int size = q.size();

             for(int i =0 ; i < size ; i++){
                  
                  Pair curr = q.poll();

                  TreeNode node = curr.node;
                  int r = curr.row;
                  int c = curr.col;

                  res.get(r).set(c,String.valueOf(node.val));

                  int gap = (int)Math.pow(2, height - r - 1);

                  if(node.left != null){
                    q.offer(new Pair(node.left,r+1,c-gap));       
                  }
                  if(node.right != null){
                   q.offer(new Pair(node.right,r+1,c+gap));     
                  }
             }
             
        }
         

     return res;
       
    }
    public int Height(TreeNode root){
        if(root == null) return  0;

        int height_left = Height(root.left);
        int height_right = Height(root.right);

        return Math.max(height_left,height_right)+1;
    }

}