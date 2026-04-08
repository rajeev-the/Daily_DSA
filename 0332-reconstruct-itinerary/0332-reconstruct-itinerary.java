class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
       Map<String, PriorityQueue<String>> adj = new HashMap<>();

            for (List<String> sp : tickets) {
                String from = sp.get(0);  // first key
                String to = sp.get(1);    // destination

                adj.putIfAbsent(from, new PriorityQueue<>());
                adj.get(from).offer(to);
            }

        List<String> res = new ArrayList<>();
       
       dfs("JFK", adj ,res);
        
        return res;

    }
    public void dfs(String src, Map<String, PriorityQueue<String>> adj , List<String> res){

        PriorityQueue<String> pq =  adj.get(src);

        while(pq != null && !pq.isEmpty()){
            String next = pq.poll();
            dfs(next,adj ,res);
        }

        res.add(0,src);
    }
}