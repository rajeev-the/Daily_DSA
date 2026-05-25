class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

       Set<List<Integer>> res = new HashSet<>();

        int n = nums.length;
          
        boolean[] vis = new boolean[n];

        solve(res,vis,nums,new ArrayList<>());

        List<List<Integer>> result = new ArrayList<>(res);


        return result;

    }

    public void solve(Set<List<Integer>> res ,boolean[] vis , int[] num , List<Integer> curr  ){
          
          if(curr.size() == num.length){
            res.add(new ArrayList<>(curr));
            return;
          }

          for(int i =0 ; i < num.length ; i++){
             
             if(vis[i]) continue;

             vis[i] = true;
             curr.add(num[i]);

             solve(res,vis,num,curr);

             curr.remove(curr.size()-1);
             vis[i] = false;

          }

    }
}