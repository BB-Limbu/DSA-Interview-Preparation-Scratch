

public class CourseSchedule_II {
    public static int[] courseScheduleTwo(int numCourses, int[][] prerequisites){
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int a = pre[0];
            int b = pre[1];

            adjList.get(b).add(a);
        }

        int[] visit = new int[numCourses];
        int[] pathVisit = new int[numCourses];

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < numCourses; i++){
            if(visit[i] == 0){
                if(dfs(i, adjList, visit, pathVisit,st)){
                    return new int[0]; //cycle exist
                }
            }
        }

        int[] ans = new int[numCourses];
        int idx = 0;
        while(!st.isEmpty()){
            ans[idx++] = st.pop();
        }
        return ans;
    }

    private static boolean dfs(int node, List<List<Integer>> adjList, int[] visit, int[] pathVisit, Stack<Integer> st){
        visit[node] = 1;
        pathVisit[node] = 1;

        for(int nbr : adjList.get(node)){
            if(visit[nbr] == 0){
                if(dfs(nbr, adjList, visit, pathVisit, st)){
                    return true;
                }
            }
            else if(pathVisit[nbr] == 1){
                return true;
            }
        }

        pathVisit[node] = 0;
        st.push(node);
        return false;
    }
    public static void main(String[] args){
        int num = 2;
        int[][] preReq = {{1,0}};
        int[] ans = courseScheduleTwo(num, preReq);
        for(int i = 0; i < ans.length; i++){
            System.out.print(ans[i] +" ");
        }
        System.out.println();
    }
}

