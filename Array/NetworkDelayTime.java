import java.util.HashMap;
import java.util.*;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] edge : times){
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k , 0});

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        boolean[] visited = new boolean[n+1];

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int node = current[0];
            int time = current[1];

            if(visited[node]) continue;
            visited[node] = true;

            if(!graph.containsKey(node)) continue;
            for(int[] neighbor : graph.get(node)){
                int next = neighbor[0];
                int weight = neighbor[1];

                if(!visited[next] && dist[next] > time + weight){
                    dist[next] = time + weight;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }
        int max = 0;
        for(int i =0; i < n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}

