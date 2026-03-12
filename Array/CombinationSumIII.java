

public class CombinationSumIII {
    /*
    Optimal Approach
    Time Complexity O(2^9 * k)
    Space Complexity O(K)
     */
    private static void helper(int sum, int last, List<Integer> ds, int k, List<List<Integer>> ans){
        // If the sum is zero and the number of elements is k
        if(sum == 0 && ds.size() == k){
            // Add the current combination to the answer
            ans.add(new ArrayList<>(ds));
            return;
        }
        // If the sum is less than or equal to zero or the number of elements exceeds k
        if(sum <= 0 || ds.size() > k){
            return;
        }

        for(int i = last; i <= 9; i++){
            if(i <= sum){
                ds.add(i);
                helper(sum-i, i +1, ds, k ,ans);
                ds.remove(ds.size()-1);
            }else{
                break;
            }
        }

    }
}

