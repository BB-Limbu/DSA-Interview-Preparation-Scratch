public class NextPermutation {

    /*Q.Next Permutation
    Optimal Aprroch
    Time complexity O(N)+O(N)+O(N) approx O(N^3)
    Spce Complexity O(1) */
    public static void nextPermutation(int[] nums){
        int n = nums.length;
        int idx = -1;
        for(int i = n-2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                idx = i;
                break;
            }
        }
        if( idx == -1){
            reverse(nums, 0, n -1);
            return;
        }
        for(int i = n-1; i > idx; i--){
            if(nums[i] > nums[idx]){
                swap(nums, i, idx);
                break;
            }
        }

        reverse(nums, idx + 1, n -1);
    }
    public static  void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    public static void swap(int[] nums, int i, int j){
        int  temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args){
        int[] nums = {3,1,2};
        NextPermutation sol = new NextPermutation();
        sol.nextPermutation(nums);

        for(int num : nums){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
