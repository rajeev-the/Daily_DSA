class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character,Integer> map = new HashMap<>();

        int n = s.length();
        int left = 0;
        int max = 0;

        for(int right =0 ; right < n ; right++){
            char word = s.charAt(right);
            map.put(word,map.getOrDefault(word,0)+1);


            while(map.get(word) > 1 ){
              
            char leftword =  s.charAt(left);

            map.put(leftword ,map.getOrDefault(leftword,0)-1);
              left++;  
            }
            max = Math.max(right-left+1,max);
        }

        return max;
    }
}