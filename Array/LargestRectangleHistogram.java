

public class LargestRectangleHistogram {
    /*
    Q. Largest Rectangle in Histogram
    Brute Force
    Time Complexity O(n^2)
    Space Complexity O(n)
     */
    public static int largestArea(int[] arr){
        int maxArea = 0;
        for(int i = 0 ; i < arr.length; i++){
            int minHeight = Integer.MAX_VALUE;
            for(int j = i; j < arr.length; j++){
                minHeight = Math.min(minHeight, arr[j]);

                int area = minHeight * (j-i + 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
    /*
    Optimal Approach
    Time Complexity O(n)
    Space Complexity O(n)
     */

    public static int largestRectangleArea(int[] heights){
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            leftSmall[i] = st.isEmpty() ? 0 : st.peek() + 1;
            st.push(i);
        }
        st.clear();

        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            rightSmall[i] = st.isEmpty() ? n-1 : st.peek() - 1;
            st.push(i);
        }
        int maxArea = 0;
        for(int i = 0; i < n; i++){
            int width = rightSmall[i] - leftSmall[i]+1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }
        return maxArea;

    }

    /*
    Optimal Approach
    Time Complexity O(n)
    Space Complexity O(n)
     */

    public static int hologram(int[] heights){
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && (i == n || heights[st.peek()] >= (i < n ? heights[i] : 0))){
                int ht = heights[st.pop()];

                int width;
                if(st.isEmpty()){
                    width = i;
                }else{
                    width = i - st.peek()-1;
                }
                maxArea = Math.max(maxArea,ht * width);
            }
            st.push(i);
        }
        return maxArea;
    }
}
