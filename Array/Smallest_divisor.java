public class Smallest_divisor {
    /*
    Brute Force Approch
    Time Complexity O(mix * N)
    Space Caomplexity O(1)
     */
    public int smallestDivisor(int[] arr, int threshold){
        int n = arr.length;

        int max = Integer.MIN_VALUE;
        for(int num : arr){
            max = Math.max(max, num);
        }

        for(int day = 1; day <= max; day++){
            int sum = 0;
            for(int i = 0; i < n; i++){
                sum += (int) Math.ceil((double) arr[i] / day);
            }
            if(sum <= threshold){
                return day;
            }
        }
        return -1;

    }

    /*
    Optimal Approach
    Time complixy O(n × log(sum))
    Space Complexity O(1)
     */

    private int sumDay(int[] nums, int day){
        int sum = 0;

        for(int num : nums){
            sum += Math.ceil((double) num / day);
        }
        return sum;
    }
    public int smallestDivisor1(int[] arr, int limit){
        if(arr.length > limit) return -1;
        int low =  1;
        int high = Arrays.stream(arr).max().getAsInt();

        while(low <= high){
            int mid = (low + high) / 2;
            if(sumDay(arr, mid) <= limit){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        int threshold = 8;
        Smallest_divisor obj = new Smallest_divisor();
        int ans = obj.smallestDivisor1(arr, threshold);
        System.out.println("The minimuim divisor is " + ans);
    }
}

