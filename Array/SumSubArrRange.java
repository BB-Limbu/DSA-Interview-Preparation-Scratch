

public class SumSubArrRange {
    /*
    Q.Sum of sub Array Range
    Brute Force Approach
    Time Complexity O(n^2)
    Space Complexity O(n)
     */
    public static int sumSubArrRange(int[] arr){
        int n = arr.length;
        int sum  = 0;

        for(int i = 0; i < n; i++){
            int largest = arr[i], smallest = arr[i];

            for(int j = i + 1; j < n; j++){
                largest = Math.max(largest, arr[j]);
                smallest = Math.min(smallest, arr[j]);
                sum += (largest - smallest);
            }
        }
        return sum;
    }
    /*
    Optimal Approach
    Time Complexity O(5n)
    Space Complexity O(5n)
     */

    // Function to find indices of Next Smaller Elements

    public static int[] findNSE(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];

        for(int i = n-1; i >= 0; i-- ){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : n;
            st.push(i);
        }
        return ans;
    }

    // Function to find indices of Next Greater Elements

    public static int[] findNGE(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : n;
            st.push(i);
        }
        return ans;
    }

    // Function to find indices of Previous Smaller or Equal Elements

    public static int[] findPSEE(int[] arr){
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

    // Function to find indices of Previous Greater or Equal Elements

    public static int[] findPGEE(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] < arr[i]){
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : -1;
            st.push(i);
        }
        return ans;
    }

    // Function to compute sum of subarray minimums

    private static long sumSubArrMin(int[] arr){
        int n = arr.length;
        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);
        long sum = 0;
        for(int i = 0; i < n; i++){
            int left = i - psee[i];
            int right = nse[i] - i;
            long freq = left * right * 1L;
            sum += freq * arr[i];
        }
        return sum;
    }

    // Function to compute sum of sub array maximums

    public static long sumSubArrMax(int[] arr){
        int n = arr.length;
        int[] nge = findNGE(arr);
        int[] pgee = findPGEE(arr);
        long sum = 0;
        for(int i = 0; i < n; i++){
            int left = i - pgee[i];
            int right = nge[i] - i;
            long freq = left * right * 1L;
            sum += freq * arr[i];
        }
        return sum;
    }

    // Function to compute total sum of subarray ranges (max - min)

    public static long subArrayRange(int[] arr){
        return sumSubArrMax(arr) - sumSubArrMin(arr);
    }
}

