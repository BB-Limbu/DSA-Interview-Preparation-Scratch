public class MagnificentSets {
    public int magnificentSets(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int[] color = new int[n + 1];
        Arrays.fill(color, -1);

        int answer = 0;

        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {

            if (visited[i]) continue;

            // Collect nodes in this connected component
            List<Integer> component = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            visited[i] = true;

            while (!q.isEmpty()) {
                int node = q.poll();
                component.add(node);

                for (int next : graph[node]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }

            // Check bipartite
            for (int node : component) {
                if (color[node] == -1) {
                    if (!dfs(node, 0, color, graph))
                        return -1;
                }
            }

            // Find maximum BFS depth
            int best = 0;

            for (int node : component) {
                best = Math.max(best, bfs(node, graph, n));
            }

            answer += best;
        }

        return answer;
    }

    boolean dfs(int node, int c, int[] color, List<Integer>[] graph) {
        color[node] = c;

        for (int next : graph[node]) {
            if (color[next] == -1) {
                if (!dfs(next, 1 - c, color, graph))
                    return false;
            } else if (color[next] == c) {
                return false;
            }
        }
        return true;
    }

    int bfs(int start, List<Integer>[] graph, int n) {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n + 1];

        Arrays.fill(dist, -1);

        q.offer(start);
        dist[start] = 1;

        int max = 1;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int next : graph[node]) {
                if (dist[next] == -1) {
                    dist[next] = dist[node] + 1;
                    max = Math.max(max, dist[next]);
                    q.offer(next);
                }
            }
        }

        return max;
    }
}
