class Solution {
    public int minMaxWeight(int n, int[][] edges, int threshold) {

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int high = 0;

        for (int[] edge : edges) {
            high = Math.max(high, edge[2]);
        }

        for (int i = 0; i < edges.length; i++) {

            int a = edges[i][0];
            int b = edges[i][1];
            int w = edges[i][2];

            adj.get(b).add(new int[] { a, w });
        }

        int ans = -1;
        int low = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (reached(adj, mid)) {
                ans = mid;
                high = mid - 1; // Try to find a smaller maximum weight
            } else {
                low = mid + 1; // Need to allow larger weights
            }
        }

        return ans;

    }

    public boolean reached(List<List<int[]>> adj, int limit) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[adj.size()];

        q.add(0);
        vis[0] = true;
        int count = 1;

        while (!q.isEmpty()) {

            int temp = q.poll();

            for (int[] fp : adj.get(temp)) {

                int next = fp[0];

                if (fp[1] > limit)
                    continue;

                if (!vis[next]) {
                    vis[next] = true;
                    count++;
                    q.offer(next);
                }
               
            }

        }

        return count == adj.size();
    }
}