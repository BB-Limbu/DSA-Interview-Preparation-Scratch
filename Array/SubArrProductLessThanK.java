

public class SubArrProductLessThanK {
    public static int subArrProduct(int[] arr, int k){
        /*
        Brute Force Approach
        Time Complexity O(n^2)
        Space Complexity O(1)
         */
        if(k <= 1){
            return 0;
        }
        int n = arr.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            int product = 1;

            for(int j = i; j >= 0; j--){
                product *= arr[j];
                if(product < k){
                    count++;
                }else{
                    break;
                }
            }
        }
        return count;
    }
    /*
    Optimal Approach
    Time Complexity O(n)
    Space Complexity (1)
     */

    public static int subArrProdK(int[] arr, int k){
        int left = 0;
        int count = 0;
        int product = 1;

        for(int i = 0 ; i < arr.length; i++){
            product *= arr[i];

            while( product >= k){
                product /= arr[left];
                left++;
            }
            count += i  - left + 1;
        }
        return count;
    }
}
