

public class CourseSchedule_I {
    //BFS Method
    public static boolean finOrder(int numCourses, int[][] prerequisites){
        List<List<Integer>> adjList = new ArrayList<>();

        // Build in-degree array
        int[] inDegree =  new int[numCourses];

        // Initialize adjacency list
        for(int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }


        // Fill adjacency and in-degree
        for(int[] pre : prerequisites){
            int a = pre[0];
            int b = pre[1];

            adjList.get(b).add(a);
            inDegree[a]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }

        //Count process node
        int count = 0;

        while(!q.isEmpty()){
            int node = q.poll();
            count++;

            // Reduce in-degree of neighbors
            for(int nbr : adjList.get(node)){
                inDegree[nbr]--;
                if(inDegree[nbr] == 0){
                    q.offer(nbr);
                }
            }
        }
        return count == numCourses;
    }


    //DFS
    public static boolean courseSchedule(int numCourses, int[][] prerequisites){
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i =0 ;i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        //building graph
        for(int[] pre : prerequisites){
            int a = pre[0];
            int b = pre[1];
            adjList.get(b).add(a);
        }

        int[] visit = new int[numCourses];
        int[] pathVisit = new int[numCourses];

        //Check EveryNode

        for(int i = 0; i < numCourses; i++){
            if(visit[i] == 0){
                if(dfs(i,adjList, visit, pathVisit)){
                    return false;
                }

            }
        }
        return true;
    }

    private static boolean dfs(int node, List<List<Integer>> adjList, int[] visit, int[] pathVisit){
        visit[node] = 1;
        pathVisit[node] = 1;

        for(int nbr : adjList.get(node)){
            if(visit[nbr] == 0){
                if(dfs(nbr, adjList, visit, pathVisit)){
                    return true;
                }
            }
            else if(pathVisit[nbr] == 1){
                return true;
            }
        }
        pathVisit[node] = 0;
        return false;
    }
    public static void main(String[] args){
        int courses = 2;
        int[][] preReq = {{1,0}};
        System.out.println(finOrder(courses,preReq));
        System.out.println(courseSchedule(courses,preReq));
    }
}
