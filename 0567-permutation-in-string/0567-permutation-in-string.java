class Solution {

    public boolean checkInclusion(String s1, String s2) {

        if(s2.length() < s1.length()){
            return false;
        }

        int[] a = new  int[26];

        int[] b = new  int[26];

        for(char s : s1.toCharArray()){
             a[s -'a']++;
        }

        int k = s1.length();

        int n = s2.length();

        int left = 0;

        for(int right = 0 ; right < n ; right++){
               
               b[s2.charAt(right)-'a']++;
                  
                  if(right- left +1 > k){
                     b[s2.charAt(left)-'a']--;
                     left++;
                  }

                  if(Arrays.equals(a,b)){
                    return true;
                  }

        }

       
       return false;

    }
}