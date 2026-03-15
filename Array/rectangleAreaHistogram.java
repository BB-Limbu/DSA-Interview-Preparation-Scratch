

public class  rectangleAreaHistogram{
    public static int rectangleHistogram(int[] arr){
        int maxArea = 0;
        int[] smallerLeft = new int[arr.length];
        int[] smallerRight = new int[arr.length];

        Stack<Integer> s = new Stack<>();

        //Next smaller right
        for(int i = arr.length-1; i >= 0; i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.empty()){
                smallerRight[i] = arr.length;
            }else{
                smallerRight[i] = s.peek();
            }
            s.push(i);
        }
        //Next smaller left
        s = new Stack<>();  // already make only making empty
        for(int i = 0; i < arr.length; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                smallerLeft[i] = -1;
            }
            else{
                smallerLeft[i] = s.peek();
            }
            s.push(i);
        }

        for(int i = 0; i < arr.length; i++){
            int height = arr[i];
            int width = smallerRight[i] - smallerLeft[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }
    public static void main(String[] args){
        int height[] = {2,1,5,6,2,3};
        System.out.println(rectangleHistogram(height));
    }
}
