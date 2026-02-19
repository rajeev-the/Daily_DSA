class Solution {
    public String minWindow(String s, String t) {
        
        int n = s.length();

        if(t.length() > n  ){
            return "";
        }

        Map<Character,Integer> map = new HashMap<>();

        for(int i =0 ; i < t.length() ; i++ ){
            char curr = t.charAt(i);
            map.put(curr,map.getOrDefault(curr,0)+1);
        }

        int i =0 ; 
        int j = 0;
        int start_i = 0;
        int count = t.length();
        int minlen = Integer.MAX_VALUE;

        
        while(j < n){
             
             char ch = s.charAt(j);

             if(map.containsKey(ch) && map.get(ch) > 0 ){
                count--;
             }

             map.put(ch,map.getOrDefault(ch,0)-1);

             while(count == 0){

                int countcurr = j-i+1;

                if(countcurr < minlen ){
                    minlen = countcurr;
                    start_i = i;
                }
                char startchar = s.charAt(i);

                map.put(startchar , map.getOrDefault(startchar,0)+1);

                 if(map.containsKey(startchar) && map.get(startchar) > 0  ) {
                    count++;
                 }
                 i++;
             }

             j++;
        }

      

     return minlen == Integer.MAX_VALUE ? "" : s.substring(start_i,start_i+minlen);

    }
}