
public class StockSpan {
    /*
    Q. Online Stock Sapn
    Brute Force
    Time Complexity O(n^2)
    Space Complexity O(n)
     */
    public static ArrayList<Integer> stockSpan(int[] arr){
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int count = 1;

            for(int j = i-1;  j >= 0; j--){
                if(arr[j] < arr[i]){
                    count++;
                }else {
                    break;
                }
            }
            ans.add(count);

        }
        return ans;
    }

    /*
    Optimal Approach
    Time Complexity O(n) + O(n)
    Space Complexity O(n)
     */
    public static ArrayList<Integer> onlineStockSpan(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            ans.add(st.isEmpty() ? i + 1 : i - st.peek());
            st.push(i);
        }
        return ans;
    }
}

