

public class BellmanFordAlgo {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));
        graph[1].add(new Edge(1,2,-4));
        graph[2].add(new Edge(2,3,2));
        graph[3].add(new Edge(3,4,4));
        graph[4].add(new Edge(4,1,-1));
    }
    public static void bellmanFord(ArrayList<Edge>[] graph, int src){ //tc  O(V*E)
        int[] dist = new int[graph.length];
        for(int i = 0; i < dist.length; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int V = graph.length;
        //TC - O(V)
        for(int i = 0; i < V-1; i++){
            //Edges --O(E)
            for(int j = 0; j < graph.length; j++){ // taking vertices
                for(int  k = 0; k < graph[j].size(); k++){ // edge of particular vertices
                    Edge e = graph[j].get(k);
                    int  u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    //Relaxation
                    if(dist[u] != Integer.MAX_VALUE && dist[u] +  wt < dist[v]){
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }
        for(int i = 0; i < dist.length; i++){
            System.out.print(dist[i] + " ");
        }
    }

    //ArrayList

    public static void createGraph(ArrayList<Edge> graph){
        graph.add(new Edge(0,1,2));
        graph.add(new Edge(0,2,4));
        graph.add(new Edge(1,2,-4));
        graph.add(new Edge(2,3,2));
        graph.add(new Edge(3,4,4));
        graph.add(new Edge(4,1,-1));
    }

    public static void bellmanFord(ArrayList<Edge> graph, int src, int  V){
        int[] dist =new int[V];
        for(int i = 0; i < dist.length; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // O(V)
        for(int i = 0; i < V-1; i++){
            //Edges -- O(E)
            for(int j = 0; j < graph.size(); j++){
                Edge e = graph.get(j);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }
        for(int i = 0; i < dist.length; i++){
            System.out.print(dist[i] + " ");
        }
    }
    public static  void main(String[] args){
        int v = 5;
        //ArrayList<Edge>[] graph = new ArrayList[v];
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        bellmanFord(edges,0,v );

    }
}
