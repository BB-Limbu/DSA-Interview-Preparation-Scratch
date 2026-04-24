

public class OnlineStockSpan {
    /*
    Q.Stock Span Problem
    Brute Force
    Time Complexity O(n^2)
    Space Complexity O(n)
     */
    public static int[] stockSpan(int[] arr){
        int n = arr.length;

        int[] ans = new int[n];

        for(int i = 0; i < n; i++){
            int currSpan = 0;
            for(int j = i; j >= 0; j--){
                if(arr[j] <= arr[i]){
                    currSpan++;
                }
                else{
                    break;
                }
            }
            ans[i] = currSpan;
        }
        return ans;
    }

    /*
    Optimal Approach
    Time Complexity O(n)
    Space Complexity O(n)
     */

    public static int[] findPGE(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){
            int currEle = arr[i];
            while(!st.isEmpty() && arr[st.peek()] <= currEle){
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
    public static int[] stockSpans(int[] arr){
        int[] pge = findPGE(arr);
        int[] ans = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            ans[i] = i - pge[i];
        }
        return ans;
    }
}

