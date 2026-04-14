

public class FindPeakEle {
    /*
    Q.Find Peak Element
    Better approach(Linear Search)
    Time Complexity O(n)
    Space Complexity O(1)
     */
    public static int peakEle(int[] arr){
        for(int i = 1; i < arr.length; i++){
            if(arr[i] >  arr[i-1] && arr[i] > arr[i+1]){
                return i;
            }
        }
        return -1;
    }
    public static int peakElement(int[] arr){
        int maxVal = Integer.MIN_VALUE;
        int ans = 0;

        for(int i = 0; i < arr.length; i++){
            maxVal = Math.max(maxVal, arr[i]);
            if(maxVal == arr[i])
                ans = i;
        }
        return ans;
    }

/*
Toward left from mid
Optimal Approach
Time Complexity O(log n)
Space Complexity O(1)
 */

    public static int findPeakEle(int[] arr){

        int left = 0;
        int right = arr.length -1;
        while(left < right){
            int mid = left + (right - left+1) / 2;

            if(arr[mid] > arr[mid + 1]){ // Moving toward left from mid
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
    /*
    Toward right from mid
     */

    public static int findPeakEleRight(int[] arr){
        int left = 0;
        int right = arr.length-1;

        while(left < right){
            int mid = left + (right - left + 1) / 2;
            if(arr[mid] > arr[mid -1]){
                left = mid;
            }
            else{
                right = mid -1;
            }
        }
        return left;
    }
}

