

public class LargestRectangle {
    /*
    Q.Maximal Rectangle
    Optimal Approach
    Time Complexity O(N*(M+M))
    Space Complexity O(n)
     */
    public static int largestRectangleArea(int[] heights){
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int[] newHeights = Arrays.copyOf(heights, heights.length+1);
        for(int i  = 0; i < newHeights.length; i++){
            while(!st.isEmpty() && newHeights[i] < newHeights[st.peek()]){
                int height = newHeights[st.pop()];
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            st.push(i);
        }
        return maxArea;
    }

    public static int maximumRectangle(char[][] matrix){
        if(matrix.length == 0){
            return 0;
        }
        int m = matrix[0].length;
        int[] height = new int[m];

        int maxArea = 0;

        //iterate each row
        for(char[] row : matrix){

            //update histogram

            for(int i = 0; i < m; i++){
                if(row[i] == '1'){
                    height[i]++;
                }else{
                    height[i] = 0;
                }
            }
            maxArea = Math.max(maxArea,largestRectangleArea(height));
        }
        return maxArea;
    }
}

