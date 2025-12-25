
import java.util.*;
public class Sort_Color {
    public static void sortColor(int[] nums){
        int left = 0, mid = 0, right = nums.length - 1;

        while(mid <= right){
            if(nums[mid] == 0){
                int temp = nums[left];
                nums[left] = nums[mid];
                nums[mid] = temp;
                left++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                int temp = nums[mid];
                nums[mid] = nums[right];
                nums[right] = temp;
                right--;
            }
        }
    }
    public static void main(String args[]){
        int[] nums = {2,0,2,1,1,0};
        int[] nums1 = {2,0,1};
        sortColor(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}
