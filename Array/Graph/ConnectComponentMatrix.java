

public class ConnectComponentMatrix {
    public int  countComponent(int v, int[][] edges){


        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < v; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean[] visit = new boolean[v];
        int countComponent = 0;

        for(int i = 0; i < v; i++){
            if(!visit[i]) {
                countComponent++;


                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                visit[i] = true;

                while (!q.isEmpty()) {
                    int curr = q.poll();

                    for (int nbr : adjList.get(curr)) {
                        if (!visit[curr]) {
                            visit[nbr] = true;
                            q.offer(nbr);
                        }
                    }

                }
            }
        }
        return countComponent;
    }
    public static void main(String[] args){
        // Number of vertices
        int v = 5;

        // List of undirected edges
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};

        // Create solution object
        ConnectComponentMatrix sol = new ConnectComponentMatrix();

        // Print the number of connected components
        System.out.println("Number of Connected Components: " + sol.countComponent(v,edges));

    }
}

