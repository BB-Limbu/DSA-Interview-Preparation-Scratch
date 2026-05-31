
public class MaximumNumberScale1 {
    public int maxCopies(int[][] items, int budget) {
        int n = items.length;

        int[] factors = new int[n];
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            factors[i] = items[i][0];
            prices[i] = items[i][1];
        }

        // g[i] = number of free copies unlocked by item i
        int[] g = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && factors[j] % factors[i] == 0) {
                    g[i]++;
                }
            }
        }

        int[] value = new int[n];
        int cheapest = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            value[i] = g[i] + 1; // purchased copy + free copies
            cheapest = Math.min(cheapest, prices[i]);
        }

        long[] dp = new long[budget + 1];
        Arrays.fill(dp, Long.MIN_VALUE);
        dp[0] = 0;

        // 0/1 Knapsack
        for (int i = 0; i < n; i++) {
            int cost = prices[i];
            int val = value[i];

            for (int c = budget; c >= cost; c--) {
                if (dp[c - cost] != Long.MIN_VALUE) {
                    dp[c] = Math.max(dp[c], dp[c - cost] + val);
                }
            }
        }

        long answer = 0;

        for (int cost = 0; cost <= budget; cost++) {
            if (dp[cost] != Long.MIN_VALUE) {
                long extraCopies = (budget - cost) / cheapest;
                answer = Math.max(answer, dp[cost] + extraCopies);
            }
        }

        return (int) answer;
    }
}
