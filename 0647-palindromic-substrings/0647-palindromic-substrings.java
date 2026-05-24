class Solution {
    public int countSubstrings(String s) {
         
         int n = s.length();
      
     int dp[][] = new int[n][n];
       
       for(int[] sp : dp){
        Arrays.fill(sp,-1);
       }

      return solve(s,0,0,dp);
        
    }

    public int solve(String s , int start , int end ,int[][] dp ){
          
          if(start == s.length() ){
            return 0;
          }
          if(end == s.length() ){
            return solve(s,start+1,start+1,dp);

          }

          if(dp[start][end] != -1){
            return dp[start][end];
          }

          int count = 0;

          if(isValid(s,start,end)){
            count =1;
          }
      return dp[start][end] = count + solve(s,start,end+1,dp);

    }


    public boolean isValid(String s, int start, int end) {

        while (start < end) {

            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

}