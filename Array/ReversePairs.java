

public class ReversePairs {
    /*
    Q.Reverse Pair
    Time Complexity O(n^2)
    Space Complexity O(1)
     */

    public static int reversePair(int[] nums){
        int n = nums.length;
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(nums[i] > 2 * nums[j])
                    count++;
            }
        }
        return count;
    }

    /*
    Optimal Approach
    Time  Complexity O(n log n)
    Space Complexity O(n)
     */

    public static void merge(int[] nums, int low, int mid, int high){
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp.add(nums[left]);
                left++;
            }
            else{
                temp.add(nums[right]);
                right++;
            }
        }
        while(left <= mid){
            temp.add(nums[left]);
            left++;
        }
        while(right <= high){
            temp.add(nums[right]);
            right++;
        }
        for(int i = low; i <= high; i++){
            nums[i] = temp.get(i - low);
        }
    }


    public static int reversePair1(int[] nums, int low, int mid, int high){
        int n = nums.length;
        int count =0;
        int right = mid + 1;

        for(int i = low; i <= mid; i++){
            while( right <= high && (long) nums[i] > 2L * nums[right]){
                right++;
            }
            count += (right - (mid + 1));

        }
        return count;
    }

    public static int mergeSort(int[] nums, int low, int high){
        int n = nums.length;
        int count =0;

        if(low >= high) return count;
        int mid = (low + high) / 2;
        count += mergeSort(nums, low, mid);
        count +=  mergeSort(nums, mid + 1, high);
        count += reversePair1(nums, low, mid, high);
        merge(nums,low,mid,high);
        return count;
    }

    public static int reverse_pairs(int[] nums){
        return mergeSort(nums, 0, nums.length-1);
    }
}
