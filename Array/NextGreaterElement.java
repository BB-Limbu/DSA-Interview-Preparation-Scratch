

public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] nums){
        int n = nums.length;
        int[] res = new int[n];

        for(int i = 0; i < n; i++){
            res[i] = -1;
            for(int j = i + 1; j < n; j++){
                if(nums[j] > nums[i]){
                    res[i] = nums[j];
                    break;
                }
            }
        }
        return res;
    }
    /*
    Optima Approach
    Time Complexity O(n)
    Space Complexity O(n)
     */
    public static int[] nextGreaterElements(int[] nums){
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() <= nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = st.peek();
            }
            st.push(nums[i]);
        }
        return ans;
    }
}


