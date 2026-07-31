

public class DetectCycle {
    public static boolean detectCycleDFS(int node, int parentNode, ArrayList<ArrayList<Integer>> adjList, boolean[] visit){
        visit[node] = true;

        for(int neighbour : adjList.get(node)){
            if(!visit[node]){
                if(detectCycleDFS(neighbour, parentNode, adjList, visit)){
                    return true;
                }
            }
            else if(neighbour != parentNode){
                return true;
            }
        }
        return false;
    }

    public static boolean isCycle(int v, ArrayList<ArrayList<Integer>> adjList){
        boolean[] visit = new boolean[v];

        for(int i = 0; i < v; i++){
            if(!visit[i]){
                if(detectCycleDFS(v, -1,adjList, visit)){
                    return true;
                }
            }
        }
        return false;
    }
}

