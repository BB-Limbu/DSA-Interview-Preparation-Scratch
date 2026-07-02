public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        int[] dp = new int[n];
        dp[0] = 1;

        int[] idx = new int[m];
        long[] val = new long[m];

        for(int i = 0; i < m; i++){
            val[i] = primes[i];
        }

        for(int i = 1; i < n; i++){
            long next = val[0];

            for(int j = 1; j < m; j++){
                next =Math.min(next, val[j]);
            }
            dp[i] = (int) next;
            for (int j = 0; j < m; j++) {
                if (val[j] == next) {
                    idx[j]++;
                    val[j] = (long) dp[idx[j]] * primes[j];
                }
            }
        }
        return dp[n-1];
    }
}
