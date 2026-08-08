

public class FindEventualSafeState {
    public static List<Integer> eventualSafeNodes(int[][] graph){
        int n = graph.length;

        List<List<Integer>> reverseGraph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            reverseGraph.add(new ArrayList<>());
        }

        //Number of outgoing Edge

        int[] outDegree = new int[n];

        for(int i = 0; i < n; i++){
            outDegree[i] = graph[i].length;

            for(int nbr : graph[i]){
                reverseGraph.get(nbr).add(i);
            }
        }

        Queue<Integer> q =  new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(outDegree[i] == 0){
                q.offer(i);

            }
        }

        boolean[] safe = new boolean[n];
        while(!q.isEmpty()){
            int node = q.poll();
            safe[node] = true;

            for(int prev : reverseGraph.get(node)){
                outDegree[prev]--;

                if(outDegree[prev] == 0){
                    q.offer(prev);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(safe[i]){
                ans.get(i);
            }
        }
        return ans;
    }
}

