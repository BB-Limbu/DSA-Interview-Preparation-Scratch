import java.util.*;

public class SumSubArrMinimum {
    /*
    Q. Sum of Sub array Minimums
    Brute Force
    Time Complexity O(n^2)
    Space Complexity O(n)
     */
    public static int sumSubArrMin(int[] arr){
        int mod = (int)1e9 + 7;
        int sum = 0;

        for(int i = 0; i < arr.length; i++){
            int min = arr[i];

            for(int j = i; j < arr.length; j++){
                min = Math.min(min, arr[j]);

                sum = (sum + min) % mod;
            }
        }
        return sum;

    }
    /*
    Optimal Approach
    Time Complexity O(5n)
    Space Complexity O(5n)
     */
    public static int[] nextSmallerEle(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = n-1 ; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            ans[i] = !st.isEmpty() ? st.peek() : n;
            st.push(i);
        }
        return ans;
    }

    public static int[] prevSmallerEle(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : -1;
            st.push(i);
        }
        return ans;
    }
    public static int sumSubArrMinimum(int[] arr) {
        int n = arr.length;
        int[] nse = nextSmallerEle(arr);// Next Smaller Element
        int[] psee = prevSmallerEle(arr); // prev  smaller element equal(psee)

        int mod = (int) 1e9 + 7;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;

            long freq = left * right * 1L;
            int val = (int) ((freq * arr[i]) % mod);
            sum = (sum + val) % mod;

        }
        return sum;
    }
}
