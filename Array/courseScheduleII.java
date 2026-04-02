import java.util.*;

public class courseScheduleII {
    public int[] course_scheduleII(int numCourse, int[][] prerequisites){
        List<List<Integer>> graphCourse = new LinkedList<>();
        int[] arrayCourse = new int[numCourse];

        for(int i = 0; i < numCourse; i++){
            graphCourse.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            int course = pre[0], prereq = pre[1];
            graphCourse.get(prereq).add(course);
            arrayCourse[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourse; i++){
            if(arrayCourse[i] == 0){
                queue.offer(i);
            }
        }
        int[] order = new int[numCourse];
        int counter = 0;

        while(!queue.isEmpty()){
            int course = queue.poll();
            order[counter++] = course;

            for(int neighbor : graphCourse.get(course)){
                arrayCourse[neighbor]--;
                if(arrayCourse[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }
        if(counter == numCourse){
            return order;
        }else{
            return new int[0];
        }

    }
}
