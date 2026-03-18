

public class JobScheduling {
    static class Job{
        char job_id;
        int deadline;
        int profit;

        Job(char job_id, int deadline, int profit){

            this.deadline = deadline;
            this.job_id = job_id;
            this.profit = profit;
        }
    }

    public static void jobScheduling(ArrayList<Job> arr){
        int n = arr.size();
        Collections.sort(arr,(a,b) -> {return a.deadline-b.deadline;
        });
        ArrayList<Job> res = new ArrayList<>();
        PriorityQueue<Job> maxHeap = new PriorityQueue<>((a,b) -> {
            return b.profit-a.profit;
        });

        for(int i = n -1; i > -1; i--){
            int slot_available;
            if(i == 0){
                slot_available = arr.get(i).deadline;
            }
            else{
                slot_available = arr.get(i).deadline - arr.get(i-1).deadline;
            }
            maxHeap.add(arr.get(i));
            while(slot_available > 0 && maxHeap.size() > 0){
                Job job = maxHeap.remove();
                slot_available--;
                res.add(job);
            }
        }
        Collections.sort(res,(a,b) -> {return a.deadline - b.deadline;
        });
        for(Job job : res){
            System.out.print(job.job_id+" ");
        }
        System.out.println();
    }
}
