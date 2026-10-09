class Solution {
    public boolean checkInclusion(String s1, String s2) {
         

        int n = s1.length();
        int m = s2.length();


        if(n > m) return false;


         int[] count = new int[26];

         for(int i =0 ; i < n ;i++){
            count[s1.charAt(i)-'a']++;
            count[s2.charAt(i)-'a']--;

         }

         if(iszero(count)) return true;


         for(int right = n ; right < m ; right++){
                 
                 char entering = s2.charAt(right);
                 char leaving = s2.charAt(right-n);

                 count[entering-'a']--;
                 count[leaving-'a']++;

                 if (iszero(count)) return true;
         }


        return false;      

    }
    public boolean iszero(int[] count){
         
         for(int value : count){
              
              if(value != 0) return  false;
         }
         return true;
    }
}