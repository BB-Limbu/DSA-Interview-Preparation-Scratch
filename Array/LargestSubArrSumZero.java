

public class LargestSubArrSumZero {
    /*
    Optimal Approach
    Time Complexity O(n)
    Space Complexity O(1)
     */
    public static int largestSubArrSumZero(int[] arr){
        int sum = 0;
        int len = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0; i < arr.length; i++){
            sum += arr[i];
            if(map.containsKey(sum)){
                len = Math.max(len, i - map.get(sum));
            }else
                map.put(sum, i);
        }
        return len;
    }
    public static void main(String[] args){
        int arr[] = {15, -2,2,-8,1,7,10,23};
        System.out.println(largestSubArrSumZero(arr));
    }
}

