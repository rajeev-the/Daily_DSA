class Solution {
   class  Pair{
        int node;
        int weight;
        public Pair(int node , int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for(int i =0 ; i <= n ; i++){
            graph.add(new ArrayList<>());
        }

        for(int i =0 ; i < times.length ; i++){
              int u = times[i][0];
              int v = times[i][1];
              int w = times[i][2];
              graph.get(u).add(new Pair(v,w));
        }

        return getshort(graph,n,k);

    }
    public int getshort(ArrayList<ArrayList<Pair>> graph , int n , int k){
        PriorityQueue<Pair> q = new PriorityQueue<>( (a,b)->(a.weight - b.weight));

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0;
        q.offer( new Pair(k,0));

        while(!q.isEmpty()){
            Pair curr = q.poll();

            int u = curr.node;

            for(Pair neigbour : graph.get(u)){

                int v = neigbour.node;
                int w = neigbour.weight;

                if(dist[u]+w < dist[v]){
                    dist[v] = dist[u]+w;
                    q.offer( new Pair(v,dist[v]));
                }
            }
        }

        int max =0 ;

        for(int i =1 ; i <= n ; i++ ){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            max = Math.max(max,dist[i]);
        }

        return max;

    }
}


