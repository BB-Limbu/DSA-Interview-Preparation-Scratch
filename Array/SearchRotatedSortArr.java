

public class SearchRotatedSortArr {
    /*
    Q. Search with Rotated Sorted Array
    Better Approach(Linear Approach)
    Time Complexity O(n)
    Space Complexity O(1)
     */
    public static int searchRotatedSortArray(int[] arr, int target){
        if(arr.length == 0){
            return -1;
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
    /*
    Optimal Approach
    Time Complexity O(log n)
    Space Complexity O(1)
     */
    public static int searchRotatedSortArr(int[] arr, int target){

        int left = 0;
        int right = arr.length-1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid] >= arr[left]){ //left sorted arr from mid
                if(arr[left] <= target && target < arr[mid]){
                    right = mid-1;
                }else{
                    left = mid + 1;
                }
            }else{//right sorted arr from mid
                if(arr[mid] < target && target <= arr[right]){
                    left = mid + 1;
                }
                else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }

}

