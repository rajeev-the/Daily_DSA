class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;
        int[] dist = new int[n];
        boolean[] vis = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int ans = 0;
        dist[0] = 0;
        for(int i =0 ; i < n ; i++){
            int u = -1;
             
             for(int j =0 ; j < n ; j++){
                if(!vis[j] && (u == -1 || dist[j] < dist[u]))  u = j ;
             }

             ans += dist[u];
             vis[u] = true;

             for(int  v =0 ; v < n ;v++){
                int x = Math.abs(points[u][0] - points[v][0]);
                int y = Math.abs(points[u][1] - points[v][1]);
                if(!vis[v]) dist[v] = Math.min(dist[v],x+y);
             }
        }
        return ans;
    }
}