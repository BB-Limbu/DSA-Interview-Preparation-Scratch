public class MaximumMexArr {
        public int[] maximumMEX(int[] nums) {
            ArrayList<Integer> list = new ArrayList<>();
            int maxi = 0, n = nums.length;
            for (int i = 0; i < n; ++i) {
                maxi = Math.max(maxi, nums[i]);
            }
            int[] freq = new int[maxi + 2];
            int[] Mex = new int[maxi + 2];
            for (int num : nums) {
                ++freq[num];
            }
            int target = 0;

            for (int i = 0; i < n; ++i) {
                while (Mex[target] == 1) {
                    ++target;
                }
                if (freq[target] == 0) {
                    list.add(target);
                    while (target > 0) {
                        Mex[target--] = 0;
                    }
                    Mex[target] = 0;
                }

                Mex[nums[i]] = 1;
                --freq[nums[i]];
            }
            while (Mex[target] == 1) {
                ++target;
            }
            if (list.size() < n)
                list.add(target);
            int[] ans = new int[list.size()];
            for (int i = 0; i < list.size(); ++i) {
                ans[i] = list.get(i);
            }
            return ans;
        }
}
