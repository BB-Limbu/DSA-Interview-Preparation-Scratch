

public class MajorityElement {
    /*Majority Element (> n/3)
    Brute force Approach
    Time Complexity O(n^2)
    Space Complexity o(1)
    */
    public static List<Integer> majorityElement1(int[] nums){
        int n = nums.length;

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(ans.size() == 0 || ans.get(0) != nums[i]){
                int count = 0;
                for(int j = 0; j < n; j++){
                    if(nums[j] == nums[i]){
                        count++;
                    }
                }

                if(count > (n /3)){
                    ans.add(nums[i]);
                }
                if(ans.size() == 2) break;

            }
        }

        return ans;

    }


    /* Better Approach
    Time Complexity O(N*logN)
    Space Complexity O(n)
     */
    public static List<Integer> majorityElement2(int[] nums){
        int n = nums.length;
        List<Integer> res = new ArrayList<>();

        HashMap<Integer, Integer> mpp = new HashMap();

        int mini = (int)(n/3) + 1;

        for(int i = 0; i < n; i++){
            int val = mpp.getOrDefault(nums[1], 0);
            mpp.put(nums[i], val + 1);

            if(mpp.get(nums[i]) == mini){
                res.add(nums[i]);

            }
            if(res.size() == 2) break;
        }
        return res;

    }

    /*
    Optimal Approach
    Time Complexity O(n) + O(n)
    Space Complexity O(n)

     */
    public static List<Integer> majorityElement3(int[] nums){
        int n = nums.length;
        int count1 = 0, count2 = 0;
        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            if(count1 == 0 && element2 != nums[i]){
                count1 = 1;
                element1 = nums[i];
            }
            else if(count2 == 0 && element1 != nums[i]){
                count2 = 1;
                element2 = nums[i];
            }
            else if( nums[i] == element1) count1++;
            else if(nums[i] == element2) count2++;

            else{
                count1--;
                count2--;
            }
        }
        List<Integer> ans = new ArrayList<>();

        count1 = 0;
        count2 = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == element1) count1++;
            if(nums[i] == element2) count2++;
        }
        int min = (int) (n /3) + 1;
        if(count1 >= min) ans.add(element1);
        if(count2 >= min) ans.add(element2);

        return ans;

    }

    public static void main(String[] args){
        int[] arr = { 33, 33,11, 11, 33, 11};
        List<Integer> ans = majorityElement3(arr);
        System.out.println(ans);

    }
}

