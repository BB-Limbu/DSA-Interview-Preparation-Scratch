import java.util.*;

public class MedianSortedArr {
    /*
    Brute Force Approach
    Time Complexity O(n1 n2)
    Space Complexity O(n)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        ArrayList<Integer>  merged = new ArrayList<>();

        int i = 0, j = 0 ;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                merged.add(nums1[i++]);
            }
            else{
                merged.add(nums2[j++]);
            }
        }

        while(i < nums1.length)
            merged.add(nums1[i++]);

        while(j < nums2.length)
            merged.add(nums2[j++]);

        int n = merged.size();

        if( n % 2 == 1)
            return merged.get(n/2);

        return (merged.get(n / 2 -1) + merged.get(n / 2)) / 2.0;
    }

    /*
    Better Approach
    Time Complexity O(n1 + n2)
    Space Complexity O(1)
     */

    public double findMedianSortedArrays1(int[] a, int[] b){
        int n1 = a.length, n2 = b.length;
        int n = n1 + n2;

        int idx2 = n /2;
        int idx1 = idx2 -1;

        int track = 0, i = 0, j = 0;
        int idx1ele = -1, idx2ele = -1;

        while(i < n1 && j < n2){
            if(a[i] < b[j]){
                if(track == idx1) idx1ele = a[i];
                if(track == idx2) idx2ele = a[i];
                i++;
            }
            else{
                if(track == idx1) idx1ele = b[j];
                if(track == idx2) idx2ele = b[j];
                j++;
            }
            track++;
        }

        while(i < n1){
            if(track == idx1) idx1ele = a[i];
            if(track == idx2) idx2ele = a[i];
            track++;
            i++;
        }
        while(j < n2){
            if(track == idx1) idx1ele = b[j];
            if(track == idx2) idx2ele = b[j];
            track++;
            j++;
        }

        if(n % 2 == 1)
            return (double) idx2ele;

        return  (idx1ele + idx2ele) / 2.0;
    }
    /*
    optimal Approach
    Time Complexity O(log(min(n1,n2))
    Space Complexity O(1)
     */

    public double findMedianSortedArrays2(int[] a, int[] b){
        if(a.length > b.length)
            return findMedianSortedArrays2(b, a);

        int n1 = a.length, n2 = b.length;
        int low = 0, high = n1;

        while(low <= high){
            int count1 = (low + high) / 2;
            int count2 = (n1 + n2 + 1) / 2 - count1;

            int l1 = (count1 == 0) ? Integer.MIN_VALUE: a[count1 - 1];
            int l2 = (count2 == 0) ? Integer.MIN_VALUE : b[count2 - 1];
            int r1 = (count1 == n1) ? Integer.MAX_VALUE : a[count1];
            int r2 = (count2 == n2) ? Integer.MAX_VALUE : b[count2];

            if(l1 <= r2 && l2 <= r1){
                if((n1 + n2) % 2 == 0)
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;

                else
                    return Math.max(l1, l2);
            }
            else if(l1 > r2)
                high = count1 - 1;
            else
                low = count1 + 1;
        }
        return 0.0;
    }
    public static void main(String[] args){
        int[] nums1 = {2,4,5};
        int[] nums2 = {1,3,6};

        MedianSortedArr opt = new MedianSortedArr();
        double ans = opt.findMedianSortedArrays2(nums1, nums2);
        System.out.println("Median is : " + ans);

    }
}
