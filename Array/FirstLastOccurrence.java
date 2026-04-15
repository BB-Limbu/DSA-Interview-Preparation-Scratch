

public class FirstLastOccurrence {
    /*
    Q. Find First and Last Occurrence
    Better Approach
    Time Complexity O(n)
    Space Complexity (1)
     */
    public static int[] firstLastOccurrence(int[] arr, int target){
        int first = -1;
        int last = -1;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target){
                if(first == -1){
                    first = i;
                }
                last = i;
            }
        }
        return new int[] {first, last};
    }
    /*
    Optimal Approach
    Time Complexity O(log2n) + O(log2n)
    Space Complexity O(1)
     */
    public static int[] firstLastOccurrences(int[] arr, int target){
        int first = findFirst(arr,target);
        int last = findLast(arr, target);

        return new int[] {first, last};
    }

    public static int findFirst(int[] arr, int target){
        int ans = -1;
        int left = 0;
        int right = arr.length-1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(arr[mid] == target){
                ans = mid;
                right = mid -1;

            }
            else if(arr[mid] < target){
                left = mid+1;
            }
            else{
                right = mid -1;
            }
        }
        return ans;
    }

    public static int findLast(int[] arr, int target){
        int ans = -1;
        int left = 0;
        int right = arr.length-1;

        while(left <=  right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == target){
                ans = mid;
                left = mid + 1;
            }
            else if(arr[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid -1;
            }
        }
        return ans;
    }
}

