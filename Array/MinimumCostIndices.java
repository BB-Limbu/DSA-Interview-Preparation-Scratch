public class MinimumCostIndices {

        public int[] minCost(int[] nums, int[][] queries) {
            int n = nums.length;
            long[] v1 = new long[n];
            long[] v2 = new long[n];

            for (int i = 0; i < n - 1; i++) {
                if (i == 0 || nums[i] - nums[i - 1] > nums[i + 1] - nums[i]) {
                    v1[i + 1] = v1[i] + 1;
                } else {
                    v1[i + 1] = v1[i] + nums[i + 1] - nums[i];
                }
            }

            for (int i = 1; i < n; i++) {
                if (i == n - 1 || nums[i] - nums[i - 1] <= nums[i + 1] - nums[i]) {
                    v2[i] = v2[i - 1] + 1;
                } else {
                    v2[i] = v2[i - 1] + nums[i] - nums[i - 1];
                }
            }

            int[] res = new int[queries.length];
            for (int k = 0; k < queries.length; k++) {
                int l = queries[k][0];
                int r = queries[k][1];
                if (l < r) {
                    res[k] = (int)(v1[r] - v1[l]);
                } else {
                    res[k] = (int)(v2[l] - v2[r]);
                }
            }
            return res;
        }
    }
