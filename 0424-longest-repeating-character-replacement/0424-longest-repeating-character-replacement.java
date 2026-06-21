class Solution {
    public int characterReplacement(String s, int k) {
        
        int n = s.length();

        int[] Aph = new int[26];

        int frq = 0;

        int max =0;
        int left = 0;

        for(int i= 0 ; i < n ;i++){

            char word = s.charAt(i);

            Aph[word-'A']++;

            frq = Math.max(frq, Aph[word-'A']);
              
              while( (i-left+1) - frq > k   ){

                    char inner = s.charAt(left);
                    Aph[inner-'A']--;

                  left++;
              }

             max = Math.max(max,i-left+1);
        }

        return max;

    }
}