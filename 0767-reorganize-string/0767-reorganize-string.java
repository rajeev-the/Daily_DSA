class Solution {
    public String reorganizeString(String s) {
        
        Map<Character,Integer> count  = new HashMap<>();

        for(char ch : s.toCharArray()){
            count.put(ch , count.getOrDefault(ch,0)+1);
        }

        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a,b)->b[1]-a[1]);

        for(Map.Entry<Character,Integer> entry :count.entrySet()){
            maxheap.offer(new int[]{entry.getKey() , entry.getValue()});
        }

        StringBuilder res = new StringBuilder();

        int[] prev = new int[]{'#',0};

        while(!maxheap.isEmpty()){
             
             int[] curr = maxheap.poll();
             res.append((char)curr[0]);
             
             if(prev[1] > 0){
                maxheap.offer(prev);
             }

             prev = curr;
             curr[1]--;
        }
    
         if(res.length() != s.length()){
            return "";
         } 

        return res.toString();
    }
}