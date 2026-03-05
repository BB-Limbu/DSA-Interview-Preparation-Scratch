

public class NonNegativewithoutConsecutiveOnes {
    /*
    Optimal Approach
    Time Complexity O(log n)
    Space Complexity O(1)
     */
    public static int findInteger(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int prevBit = 0;
        int result = 0;

        for (int i = n - 1; i >= 0; i--) {
            if ((n & (1 << i)) != 0) {
                result += dp[i];
                if (prevBit == 1) {
                    return result;
                }
                prevBit = 1;

            } else {
                prevBit = 0;
            }
        }
        return result + 1;

    }
}

