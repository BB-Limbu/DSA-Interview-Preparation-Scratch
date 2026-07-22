public class IsBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            if (color[i] != -1)
                continue;

            q.offer(i);
            color[i] = 0;

            while (!q.isEmpty()) {
                int node = q.poll();

                for (int next : graph[node]) {

                    if (color[next] == -1) {
                        color[next] = 1 - color[node];
                        q.offer(next);
                    } else if (color[next] == color[node]) {
                        return false;
                    }
                }
            }
        }

        return true;

    }
}
