
public class BinarySearch{
    /*Iterative Implementation
    Time Complexity O(log n)
    Space Complexity O(1)
     */
    public static int binarySearch(int[] nums, int target){
        int n = nums.length;
        int ptr1 =0, ptr2 = n -1;
        while(ptr1 <= ptr2){
            int mid = (ptr1 + ptr2) / 2;
            if(target == nums[mid]){
                return mid;
            }
            else if(target > nums[mid]){
                ptr1 = mid + 1;
            }
            else{
                ptr2 = mid -1;
            }
        }
        return -1;
    }

    /*Recursive Approach
    Time Complexity O(log n)
    Space Complexity o(1)
     */


    public static int binarySearch1(int[] nums, int ptr1, int ptr2, int target){
        if(ptr1 > ptr2)
            return -1;

        while(ptr1 < ptr2){
            int mid = (ptr1 + ptr2) / 2;

            if(nums[mid] == target)
                return mid;

            else if(target > nums[mid]){
                return  binarySearch1(nums, mid + 1, ptr2, target);
            }

            return binarySearch1(nums, ptr1, mid -1, target);
        }
        return -1;
    }
}
