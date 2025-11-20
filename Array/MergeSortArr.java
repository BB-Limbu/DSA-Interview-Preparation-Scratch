public class MergeSortArr {
    /*
    Q.Merge two sorted arrays without extra space
    Time Complexity O(n + m) + O(n + m)
    Space Complexity O(n + m)
     */
    public static void mergeSortArr(int[] nums1, int[] nums2, int m , int n){
        int[] nums3 = new int[m + n];
        int left = 0;
        int right = 0;
        int idx = 0;
        while(left < m && right < m){
            if(nums1[left] <= nums2[right]){
                nums3[idx] = nums1[left];
                left++;
                idx++;
            }
            else{
                nums3[idx] = nums2[right];
                right++;
                idx++;
            }
        }
        while(left < m){
            nums3[idx] = nums1[left];
        }
        while(right < n){
            nums2[idx] = nums2[right];
        }
        for(int i = 0; i < m + n; i++){
            if(i < m) {
                nums1[i] = nums3[i];
            }
            else
                nums2[i - n] = nums3[i];
        }

    }

    /*
    optimal Approch 1
    Time Compolexity O(n + m)
    Space Complexity O(1)
     */

    public static void  mergeSortArr1(int[] nums1, int[] nums2, int m, int n){
        int ptr1 = m - 1;
        int ptr2 = n -1;
        int idx = m + n -1;

        while(ptr1 >= 0 &&  ptr2 >= 0){
            if(nums1[ptr1] > nums2[ptr2]){
                nums1[idx--] = nums1[ptr1--];
            }
            else{
                nums1[idx--] = nums2[ptr2--];
            }
        }
        while(ptr2 >= 0){
            nums1[idx--] = nums2[ptr2--];
        }

    }

    /*
    Optimal Approch 2
    Time Complexity O(log2(n + m)) + O(n+M)
    Space Complexity O(1)
     */

    public static void mergeSortArr2(int[] nums1, int[] nums2){
        int n = nums1.length;
        int m = nums2.length;
        int len = n + m;
        int gap = (len / 2) + (len % 2);
        while(gap > 0){
            int left = 0;
            int right = left + gap;

            while(right < len){
                if(left < n && right >= n){
                    swap(nums1, nums2, left, right - n);
                }
                else if(left >= n){
                    swap(nums2, nums2, left -n, right -n);
                }
                else{
                    swap(nums1, nums1, left, right);
                }
                left++;
                right++;
            }
            if(gap == 1)break;
            gap = (gap / 2) + (gap % 2);
        }

    }
    public static void swap(int[] nums1, int[] nums2, int idx1, int idx2){
        if(nums1[idx1] > nums2[idx2]){
            int temp = nums1[idx1];
            nums1[idx1] = nums2[idx2];
            nums2[idx2] = temp;
        }
    }
}
