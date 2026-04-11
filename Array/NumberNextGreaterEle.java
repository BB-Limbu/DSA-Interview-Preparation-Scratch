
public class NumberNextGreaterEle {
    /* Q. Number of great Element to the right
    Time Complexity O(n^2)
    Space Complexity O(n)
     */
    public static int[] numNextGreaterEle(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for(int i = 0; i < n; i++){
            int curr = nums[i];
            for(int j = i+1; j < n; j++){
                if( nums[j] > curr){
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
    public static int[] numNextGrtEle(int[] nums){
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for(int i = n-1; i>= 0; i--){
            int currEle = nums[i];
            while(!st.isEmpty() && st.peek() <= currEle){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = st.peek();
            }
            st.push(currEle);
        }
        return ans;
    }
}

