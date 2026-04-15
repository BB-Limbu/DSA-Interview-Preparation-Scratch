

public class CeilingSortedArray {
    /*
    Q. Ceiling in Sorted Array
    Better Approach (Linear Search)
    Time Complexity O(n)
    Space Complexity O(1)
     */
    public static int findCeilingSortedArray(int[] arr, int x){
        int ans = -1;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= x){
                ans = i;
                break;
            }
        }
        return ans;
    }
    /*
    Optimal Approach (Binary Search)
    Time Complexity O(log2n)
    Space Complexity O(1)
     */

    public static int findCeilingSortedArr(int[] arr, int x){
        int ans = -1;
        int left = 0;
        int right = arr.length-1;

        while(left <= right){
            int mid = left + (right - left) /2;

            if(arr[mid] >= x){
                ans = mid; // mid may be my answer
                right = mid -1; // move toward left
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }
}

