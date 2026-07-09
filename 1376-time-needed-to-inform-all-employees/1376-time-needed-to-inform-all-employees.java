class Solution {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
          
          List<List<Integer>> adj = new ArrayList<>();
           int time= 0;
           
           for(int i =0 ; i < n ; i++){
             adj.add(new ArrayList<>());
           }

           for (int i = 0; i < n; i++) {
                if (manager[i] != -1) {
                    adj.get(manager[i]).add(i);
                }
            }
          return solve(headID,informTime,adj);

    }

    public int solve(int curr  , int[] informTime , List<List<Integer>> res ){
            
            int maxTime =0;
            
           for(int next : res.get(curr)){
       
            maxTime = Math.max(maxTime , informTime[curr] + solve(next,informTime,res));
           }

            return maxTime;
    }


}