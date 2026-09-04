package Graph;



public class CheapestFlight {
    public static int cheapestFlight(int n, int[][] flights, int src, int dest, int k){
        List<List<int[]>> adjList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        //Build graph;
        for(int[] flight : flights){
            adjList.get(flight[0]).add(new int[] {flight[1], flight[2]});

        }

        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);

        dist[src] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, src, 0});

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int stops = curr[0];
            int node = curr[1];
            int costs = curr[2];

            if(stops > k){
                continue;
            }

            for(int[] adjNode : adjList.get(node)){
                int nextNode = adjNode[0]; // next Destination
                int edw = adjNode[1]; //Cost of the flight to the next destination

                if(costs + edw < dist[nextNode] && stops <= k){
                    dist[nextNode] = costs + edw;
                    q.offer(new int[]{stops+1, nextNode, costs + edw});
                }

            }
        }
        return dist[dest] == (int) 1e9 ? -1 : dist[dest];
    }
    public static void main(String[] args){
        int n = 4, src = 0, dst = 3, K = 1;

        // Flight routes and their costs
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600},
                {2, 3, 200}};


        // Call the method to find the cheapest flight
        int ans = cheapestFlight(n, flights, src, dst, K);

        // Output the result
        System.out.println(ans);
    }
}
