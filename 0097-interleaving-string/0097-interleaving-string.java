class Solution {
    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        
        if(s1.length() + s2.length() != s3.length())
            return false;

       dp = new Boolean[s1.length()+1][s2.length()+1];
        

        return solve(s1,s2,s3,0,0);
    }
    public boolean solve(String s1 , String s2 , String s3 , int i , int j ){
        
        if(s1.length() <= i  && j >= s2.length()){
            return true;
        }
        
        if(dp[i][j] != null ){
            return dp[i][j];
        }

         int k = i + j;

        boolean  take_s1 = false;
        boolean  take_s2 = false;

       if(  i < s1.length() &&  s1.charAt(i) == s3.charAt(k)){
          take_s1 = solve(s1,s2,s3,i+1,j);
       }
        if( j < s2.length() &&  s2.charAt(j) == s3.charAt(k)){
         take_s2 = solve(s1,s2,s3,i,j+1);
       }
       
  
        return dp[i][j] =  take_s1 || take_s2  ;
    }
}