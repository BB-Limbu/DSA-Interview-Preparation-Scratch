class MaximumDetonation {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        // Build graph
        for (int i = 0; i < n; i++) {

            long x1 = bombs[i][0];
            long y1 = bombs[i][1];
            long r = bombs[i][2];

            for (int j = 0; j < n; j++) {

                if (i == j)
                    continue;

                long dx = x1 - bombs[j][0];
                long dy = y1 - bombs[j][1];

                if (dx * dx + dy * dy <= r * r) {
                    graph[i].add(j);
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {

            boolean[] visited = new boolean[n];

            ans = Math.max(ans, dfs(i, graph, visited));
        }

        return ans;
    }

    private int dfs(int node, List<Integer>[] graph, boolean[] visited) {

        visited[node] = true;

        int count = 1;

        for (int next : graph[node]) {
            if (!visited[next]) {
                count += dfs(next, graph, visited);
            }
        }

        return count;
    }
}
