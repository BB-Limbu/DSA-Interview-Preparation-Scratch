

public class NextGreaterElementII {
    public static int[] nextGreaterElement(int[] nums){
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums.length];

        for(int i = 2*n-1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() <= nums[i % n]){
                st.pop();
            }

            if(i < n){
                ans[i] = st.isEmpty() ?  -1 : st.peek();
            }
            st.push(nums[i % n]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        int[] ans = nextGreaterElement(nums);

        for(int i = 0; i < ans.length; i++){
            System.out.print(ans[i] +" ");
        }
    }
}

