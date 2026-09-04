

public class BellmanFordAlgo {
    public static int[] bellmanFord( int V, int[][] edges, int S){

        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[S]  = 0;

        for(int i = 0; i < V-1; i++){
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];


                if(dist[u] != 1e9 && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if(dist[u] != 1e9 && dist[u] + wt < dist[v]){
                return new int[]{-1};
            }
        }
        return dist;

    }
    public static void main(String[] args){
        int V = 5;

        int[][] edges = {
                {0, 1, 5},
                {1, 2, 3},
                {2, 3, 1},
                {3, 4, 2},
                {0, 2, 10}
        };

        int S = 0;

        int[] result = bellmanFord(V, edges, S);

        if (result.length == 1 && result[0] == -1) {
            System.out.println("Negative cycle detected");
        } else {
            System.out.println("Shortest distances:");

            for (int i = 0; i < result.length; i++) {
                System.out.println("Node " + i + " = " + result[i]);
            }
        }
    }
}

