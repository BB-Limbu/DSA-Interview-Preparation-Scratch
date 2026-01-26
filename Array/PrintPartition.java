public class PrintPartition {
    /*
    Brute Force Approach
    Time Complexity O(n*(sum(arr[])-max(arr[])+1)
    Space Complexity o(1)
     */
    public static int countPartition(int[] boards, int k){
        int board = 1;
        int totalBoard = 0;

        for(int i = 0; i < boards.length; i++){
            if(totalBoard + boards[i] <= k){
                totalBoard += boards[i];
            }
            else{
                board++;
                totalBoard = boards[i];
            }
        }
        return board;
    }
    public static int printPartition(int[] arr, int k){
        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();

        for(int time = low; time <= high; time++){
            if(countPartition(arr, time) <= k){
                return time;
            }
        }
        return low;
    }
    /*
    Brute Force Approach
    Time Complexity O(n * log(sum(arr[])-max(arr[])+1))
    Space complexity O(1)
     */

    public static int partion1(int[] boards, int k){
        int partition = 1;
        int totalPar = 0;

        for(int i = 0; i < boards.length; i++){
            if(totalPar + boards[i] <= k){
                totalPar += boards[i];
            }
            else{
                partition++;
                totalPar = boards[i];
            }
        }
        return partition;
    }

    public static int print_partion(int[] nums, int k){
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();

        while(low <= high) {
            int mid = (low + high)/2;
            if(partion1(nums, mid) > k){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }
}
