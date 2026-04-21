

public class DailyTemperatures {
    /*
    Q. Daily Temperature
    Brute Force Approach
    Time Complexity O(n^2)
    Space Complexity O(1)
     */
    public static int[] dailyTemp(int[] temp){
        int n = temp.length;
        int[] ans = new int[n];

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(temp[j] > temp[i]){
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }
    /*
    Optimal Approach
    Time Complexity O(n) + O(n)
    Space Complexity O(n) + O(n)
     */
    public static int[] dailyTemperature(int[] temperatures){
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int idx = st.pop();
                ans[idx] = i - idx;
            }
            st.push(i);
        }
        return ans;
    }
}

