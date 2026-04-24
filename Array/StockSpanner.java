

public class StockSpanner {
    private static Stack<int[]> st;

    public StockSpanner(){
        st = new Stack<>();
    }

    public static  int next(int val){
        int idx = 1;

        while(!st.isEmpty() && st.peek()[0] <= val){
            idx += st.pop()[1];
        }
        st.push(new int[] {val, idx});
        return idx;
    }

}

