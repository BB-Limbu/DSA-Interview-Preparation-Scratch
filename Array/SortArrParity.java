public class SortArrParity {
    public static int[] sortArrByParity(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        int left = 0,  right = n-1;

        for(int num : nums){
            if(num % 2 == 0){
                ans[left++]  = num;
            }else{
                 ans[right--] = num;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums = {3,1,2,4};
        int[] ans = sortArrByParity(nums);
        for(int i = 0; i < ans.length; i++){
            System.out.println(ans[i]);
        }
    }
}
