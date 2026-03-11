

public class SubsetSum {
    /*
    Better Approach
    Time Complexity O(2n * n)+ (2n log(2n))
    Space Complexity  O(2^n)
     */
    public List<Integer> subsetSum(int[] arr){
        int n = arr.length;
        List<Integer> sums = new ArrayList<>();

        // Loop through all possible subsets represented by bitmasks
        for(int mask = 0; mask < (1 << n); mask++){
            int sum = 0; //Sum of current subset
            //check each bit in the mask
            for(int i = 0; i < n; i++){
                //if the i-th bits is set include arr[i] in sum
                if((mask &(1<<i)) != 0){
                    sum += arr[i];
                }
            }
            sums.add(sum);
        }
        Collections.sort(sums);
        return sums;
    }
    /*
    Optimal Approach
    Time Complexity O(2^nlog(2^n))
    Space Complexity O(2^n+n)
     */
    public static void helper(int idx, int sum, int[]  arr, ArrayList<Integer> sumSubset){
        if(idx == arr.length){
            sumSubset.add(sum);
            return;
        }
        //Pick the element
        helper(idx+1, sum + arr[idx], arr, sumSubset);
        //Don't pick the element
        helper(idx+1, sum, arr, sumSubset);
    }
    public List<Integer>  subSetSum(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> sumSubset = new ArrayList<>();
        helper(0, 0, arr, sumSubset);
        //Collections.sort(sumSubset);
        return sumSubset;

    }
}

