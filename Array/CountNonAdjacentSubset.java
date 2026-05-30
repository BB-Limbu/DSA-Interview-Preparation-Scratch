import java.util.*;

public class Solution {

    static final long MOD = 1_000_000_007L;

    static List<Integer>[] tree;
    static int[] nums;
    static int k;

    static class Pair {
        long[] dp0;
        long[] dp1;

        Pair(int k) {
            dp0 = new long[k];
            dp1 = new long[k];
        }
    }

    public int countValidSubsets(int[] parent, int[] nums, int k) {
        int n = parent.length;

        this.nums = nums;
        Solution.k = k;

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        Pair root = dfs(0);

        long ans = (root.dp0[0] + root.dp1[0]) % MOD;

        // remove empty subset
        ans = (ans - 1 + MOD) % MOD;

        return (int) ans;
    }

    private Pair dfs(int u) {

        Pair cur = new Pair(k);

        cur.dp0[0] = 1;
        cur.dp1[nums[u] % k] = 1;

        for (int v : tree[u]) {

            Pair child = dfs(v);

            long[] ndp0 = new long[k];
            long[] ndp1 = new long[k];

            // u not selected
            for (int i = 0; i < k; i++) {
                if (cur.dp0[i] == 0) continue;

                for (int j = 0; j < k; j++) {

                    long ways =
                            (child.dp0[j] + child.dp1[j]) % MOD;

                    if (ways == 0) continue;

                    ndp0[(i + j) % k] =
                            (ndp0[(i + j) % k]
                                    + cur.dp0[i] * ways) % MOD;
                }
            }

            // u selected
            for (int i = 0; i < k; i++) {
                if (cur.dp1[i] == 0) continue;

                for (int j = 0; j < k; j++) {
                    if (child.dp0[j] == 0) continue;

                    ndp1[(i + j) % k] =
                            (ndp1[(i + j) % k]
                                    + cur.dp1[i] * child.dp0[j]) % MOD;
                }
            }

            cur.dp0 = ndp0;
            cur.dp1 = ndp1;
        }

        return cur;
    }
}