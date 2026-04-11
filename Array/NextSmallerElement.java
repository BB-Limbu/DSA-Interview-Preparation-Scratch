

public class NextSmallerElement {
    /*
    Q.Next Smaller Element
    Time Complexity O(n^2)
    Space Complexity O(n)
     */
    public static int[] nextSmallerElement(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for(int i= 0; i < n; i++){
            int curr = nums[i];
            for(int j = i + 1; j < n; j++){
                if(nums[j] < curr){
                    ans[i] = nums[j];
                    break;
                }
            }
        }
        return ans;
    }
    /*
    Optimal Approach
    Time Complexity O(n)
    Space Complexity O(n)
     */
    public static int[] nextSmallerElements(int[] nums){
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] ans  = new int[n];
        Arrays.fill(ans, -1);


        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() >= nums[i]){
                st.pop();
            }

            if(!st.isEmpty()){
                ans[i] = st.peek();
            }
            st.push(nums[i]);

        }
        return ans;
    }
}

