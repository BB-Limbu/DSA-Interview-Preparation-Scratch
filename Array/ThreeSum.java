

public class ThreeSum {
    /*
    Q.3Sum
    Time Complexity O(n^3 * log(no.of unique triplet)
    Space Complexity O(2n)
     */
    public static List<List<Integer>> threeSum(int[] nums){
        int  n = nums.length;
        Set<List<Integer>> st  = new HashSet<>();

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                for(int k = j + 1; k < n; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer>  temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        temp.sort(null);
                        st.add(temp);
                    }
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
    /*
    Better Approach
    Time Complexity
    Space Compleity
     */

    public static List<List<Integer>> threeSum1(int[] nums){
        int n = nums.length;
        Set<List<Integer>> st = new HashSet<>();

        for(int i = 0; i < n; i++){
            Set<Integer> hashSet = new HashSet<>();
            for(int j = i + 1; j < n; j++){
                int sum = - (nums[i] + nums[j]);

                if(hashSet.contains(sum)){
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], sum);
                    temp.sort(null);
                    st.add(temp);
                }

                hashSet.add(nums[j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }

    /*
    Optimal Approach
    Time complexity O(nlogn)+O(n2),
    Space Complexity O(n)
     */

    public static List<List<Integer>> threeSum2(int[] nums){
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < n; i++){
            if(i != 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;
            int k = n - 1;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0){
                    j++;
                }
                else if(sum > 0){
                    k--;
                }
                else{
                    List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k]);
                    ans.add(temp);
                    j++;
                    k--;


                    while(j < k && nums[j] == nums[j -1]) j++;
                    while(j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }

        return ans;
    }
    public static void main(String[] args){
        int[] nums = {-1, 0, 1, 2, -1,-4};
        List<List<Integer>> ans = threeSum2(nums);
        for(List<Integer> it : ans){
            System.out.print("[");
            for(Integer i : it){
                System.out.print(i + " ");
            }
            System.out.print("]");
        }
        System.out.println();

    }
}
