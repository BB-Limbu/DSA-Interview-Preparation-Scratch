import java.util.ArrayList;
import java.util.List;

public class NumberInversion {
    /*
    Q.Count Inversion (inversion means pair)
    Time Comlexity O(n^2)
    Space Complexity O(1)
     */
    public static int numberInvasion(int[] nums){
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(nums[i] > nums[j]){
                    count++;
                }
            }
        }
        return count;
    }
    /*
    Optimal Solution
    Time Complexity O(n*logn)
    Space Complexity O(n)
     */
    public static int numberInvasion1(int[] nums, int low,int mid, int high){
        List<Integer> temp = new ArrayList<>();

        int left = low;
        int right = mid + 1;
        int count = 0;

        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp.add(nums[left]);
                left++;
            }
            else{
                temp.add(nums[right]);
                count += (mid - left + 1);
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
        return count;
    }

    public static int merge(int[] nums, int low, int high){
        int count = 0;
        if(low >= high) return count;
        int mid = (low + high) / 2;
        count += merge(nums, low, mid);
        count += merge(nums, mid + 1, high);
        count += numberInvasion1(nums, low,mid,high);

        return count;
    }

    public static int numberOfInversion(int[] nums){
        return merge(nums, 0, nums.length-1);
    }
    public static void main(String[] args){
        int[] nums = {5, 4, 3, 2, 1};
        int ans = numberOfInversion(nums);
        System.out.print("Number of pair is: " + ans);
    }
}

