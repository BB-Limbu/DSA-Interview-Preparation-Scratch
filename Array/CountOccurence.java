

public class CountOccurence {
    /*
    Better Approach
    Time Complexity O(n)
    Space Complexity O(1)
     */
    public static int[] firstAndLast(int[] nums, int x){
        int n = nums.length;
        int first = -1, last = -1;

        for(int i = 0; i < n; i++){
            if(nums[i] == x){
                if(first == -1){
                    first = i;
                }
                last = i;
            }
        }
        return new int[] {first, last};
    }

    /*
    Optimal Approach
    Time Complexity
    Space Complexity
     */

    public static int firstOccurence(int[] nums, int k){
        int n = nums.length;
        int low = 0, high = n -1;
        int ans = -1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == k){
                ans = mid;
                high = mid - 1;
            }
            else if(nums[mid] < k){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int lastOccurence(int[] nums, int k){
        int n = nums.length;
        int low = 0, high = n - 1;
        int ans = -1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == k){
                ans = mid;
                low = mid + 1;
            }
            else if(nums[mid] < k){
                low = mid + 1;
            }
            else{
                high = mid -1;;
            }
        }
        return ans;
    }
    private static int[] firstAndLastOccurence(int[] nums, int target){
        int first = firstOccurence(nums, target);
        if(first == -1) return new int[] {-1,-1};
        int last  = lastOccurence(nums,target);
        return new int[] {first, last};
    }
}

