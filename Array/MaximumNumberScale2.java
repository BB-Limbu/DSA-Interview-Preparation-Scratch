class MaximumNumberScale2{
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int[] factor = new int[n];
        int[] price = new int[n];

        for (int i = 0; i < n; i++) {
            factor[i] = items[i][0];
            price[i] = items[i][1];
        }

        // g[i] = number of distinct free-copy opportunities
        int[] g = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && factor[j] % factor[i] == 0) {
                    g[i]++;
                }
            }
        }

        long[] dp = new long[budget + 1];
        Arrays.fill(dp, Long.MIN_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {

            // ---------- bounded part ----------
            int cnt = g[i];
            int p = price[i];

            int take = 1;

            while (cnt > 0) {
                int cur = Math.min(take, cnt);

                int cost = cur * p;
                long value = 2L * cur;

                for (int b = budget; b >= cost; b--) {
                    if (dp[b - cost] != Long.MIN_VALUE) {
                        dp[b] = Math.max(dp[b],
                                dp[b - cost] + value);
                    }
                }

                cnt -= cur;
                take <<= 1;
            }

            // ---------- unbounded part ----------
            for (int b = p; b <= budget; b++) {
                if (dp[b - p] != Long.MIN_VALUE) {
                    dp[b] = Math.max(dp[b],
                            dp[b - p] + 1);
                }
            }
        }

        long ans = 0;

        for (int b = 0; b <= budget; b++) {
            ans = Math.max(ans, dp[b]);
        }

        return (int) ans;
    }
}