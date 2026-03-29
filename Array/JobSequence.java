import java.util.*;

public class JobSequence {
    static class Job{
        int deadline;
        int profit;
        int id;

        public Job(int i, int d, int p){
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static List<Integer> maxProfit(int[][] nums){
        ArrayList<Job> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            list.add(new Job(i,nums[i][0], nums[i][1]));
        }
        //Applying sorting on object
        Collections.sort(list, (obj1, obj2) -> obj2.profit - obj1.profit);//descending order in profit

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for(int i = 0; i< list.size(); i++){
            Job curr = list.get(i);
            if(curr.deadline > time){
                seq.add(curr.id);
                time++;
            }
        }
        return seq;
    }
}
