

public class ClimbingStairs {
    //Recursive Code
    //TC O(2^n)
    public static int countWays(int n){
        if(n == 0){ // take 1 jump at 0 stair to go down from zero stair
            return 1;
        }
        if(n < 0){ // handle -ve
            return 0;
        }
        return countWays(n-1) + countWays(n-2);
    }
    //DP Memoization
    //TC O(n)

    public static int countWay(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = countWay(n - 1) + countWays(n - 2);
        return dp[n];
    }
}
