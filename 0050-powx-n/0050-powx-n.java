class Solution {
    public double myPow(double x, int n) {
        
        long e = n ;
        if(e < 0 ){
           x = 1.0/x;
            e = -e;
        }

        return getpow(x,e);
    }
    public double getpow(double x , long n){

        if( n == 0 ){
            return 1.0;
        }

        double half =getpow(x,n/2);
        double res = half*half; 
     
      if(n % 2 ==1 ){
         res = res*x;
      }

      return res;

    }
}