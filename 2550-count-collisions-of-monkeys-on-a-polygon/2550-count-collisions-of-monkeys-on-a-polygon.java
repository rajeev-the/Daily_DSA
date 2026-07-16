class Solution {
     int MOD = 1_000_000_007;
    public int monkeyMove(int n) {
          

          long  ans = power(2,n);
          ans = (ans-2+MOD) % MOD;

          return (int) ans;

    }
    public long power(long base , int exp){
        long result = 1; 

        while(exp >0){
              
              if((exp & 1) == 1){
                result = (result*base) % MOD;
              }
              base = (base * base) % MOD;
              exp >>= 1;

        }
        return result;
    }
   
}