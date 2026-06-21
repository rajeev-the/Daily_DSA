class Solution {
    public int characterReplacement(String s, int k) {
        
        int[] Alph = new int[26];

        int left = 0;

        int n = s.length();

        int feq = 0;

        int max = 0;

        for(int i =0 ; i < n ; i++){
             
             int ch = s.charAt(i)-'A';

             Alph[ch]++;

             feq = Math.max(feq,Alph[ch]);

             while( (i-left+1) - feq  > k ){
                
                int ch1 = s.charAt(left)-'A';
                Alph[ch1]--;
                
                left++;
             }
          
        max = Math.max(max,i-left+1);

        }

        return max;
    }
}