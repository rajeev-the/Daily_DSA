class Solution {
    public List<List<Integer>> combine(int n, int k) {

        
        
        List<List<Integer>> res = new ArrayList<>();

        solve(res,new ArrayList<>(),n,k,1);
       
        return res;
    }
    public void solve(List<List<Integer>> res , List<Integer> curr ,int n, int k ,int start){
        
         
         if(curr.size() == k){
             res.add(new ArrayList<>(curr));
             return;
         }
            

            for(int i = start ; i <= n ; i++){

              curr.add(i);
          
               solve(res,curr,n,k,i+1);
            

                curr.remove(curr.size()-1);
            }

         

    }
}