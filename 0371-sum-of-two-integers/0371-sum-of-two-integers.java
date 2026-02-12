class Solution {
    public int getSum(int a, int b) {
        
        while(b!=0){
          
          int carry = (a&b) << 1;
          a = a^b;
          b = carry;
        }

        return a;
    }
}

// 0 ^ 0  =0
// 0 ^ 1 = 1
// 1 ^1 = 0 (carry is ignore);
// for carry we use the And(&)
// (1&1) = 1 carry is generted