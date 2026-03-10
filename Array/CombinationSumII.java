

public class CombinationSumII {

    /*
    optimal Approach
    Time Complexity O(2^n * k)
    Space Complexity O(k*x)
     */
    public static void backtrack(int idx, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds){
        // Base case: If the target becomes 0, we found a valid combination
        if(target == 0){
            ans.add(new ArrayList(ds)); // Add the current combination to the result
        }
        // Loop through the elements starting from index 'ind'
        for(int i = idx; i < arr.length; i++){
            // Skip duplicates to avoid repeating combinations
            if(i > idx && arr[i] == arr[i-1]){ // checking repeated element
                continue;
            }

            // If the current element is greater than the remaining target, break the loop
            if(arr[i] > target){
                break;
            }
            // Include the current element in the combination
            ds.add(arr[i]);
            // Recur with the updated target and next index (i + 1 to avoid repetition)
            backtrack(i+1, arr, target-arr[i], ans, ds);
            // Backtrack by removing the last added element
            ds.remove(ds.size()-1);
        }
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target){
        List<List<Integer>> ans = new ArrayList<>();// To store the final answer
        Arrays.sort(candidates); // Sort the candidates to handle duplicates
        backtrack(0, candidates,target,ans,new ArrayList<>());
        return ans; // Return all valid combinations
    }
    public static void main(String[] args){
        CombinationSumII obj = new CombinationSumII();
        int[] v = {10, 1, 2, 7, 6, 1, 5};  // Example input
        int target = 8;  // Target sum

        // Get all combinations that sum up to 8
        List<List<Integer>> comb = obj.combinationSum2(v, target);

        // Output the combinations
        System.out.print("[ ");
        for (List<Integer> combination : comb) {
            System.out.print("[ ");
            for (int num : combination) {
                System.out.print(num + " ");
            }
            System.out.print("]");
        }
        System.out.println(" ]");
    }
}
