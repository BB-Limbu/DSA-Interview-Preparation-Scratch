

public class FloorSortedArray {
    /*
    Q. Floor in a Sorted Array
    Better Approach
    Time Complexity O(n)
    Space Complexity O(1)
     */
    public static int findFloorSortArr(int[] arr, int x){
        int ans = -1;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= x){
                ans = i;
            }
        }
        return ans;
    }
    /*
    Optimal Approach
    Time Complexity O(log2n)
    Space Complexity O(1)
     */
    public static int findFloorSortedArr(int[] arr, int x){
        int left = 0;
        int right = arr.length-1;
        int ans = -1;

        while(left <= right){
            int mid = left + (right -left) / 2;

            if(arr[mid] <= x){
                left = mid + 1;
                ans = mid;
            }
            else{
                right = mid -1;
            }
        }
        return ans;
    }
}

