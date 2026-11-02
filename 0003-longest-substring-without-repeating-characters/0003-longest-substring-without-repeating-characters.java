class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> sp = new HashSet<>();

        int start = 0;
        int end = 0;
        int max = 0;

        while(start < s.length()){
               
               if(!(sp.contains(s.charAt(start)))){
                sp.add(s.charAt(start));
                   
               max = Math.max(max,start-end+1);
                start++;
        }
        else{
            sp.remove(s.charAt(end));
            end++;
        }
        
    }

       return max;

    }

}