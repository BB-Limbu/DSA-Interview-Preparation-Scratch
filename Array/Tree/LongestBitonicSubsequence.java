
public class LongestBitonicSubsequence {
    public static int longestBSub(int arr[]){
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i = 0; i < n; i++){
            for(int prev = 0; prev <i; prev++){
                if(arr[prev] < arr[i] && 1 + dp[prev] > dp[i]){
                    dp[i] = 1 + dp[prev];
                }
            }
        }
        int maxi = 0;
        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);
        for(int i = n-1; i >= 0; i--){
            for(int prev = n-1; prev > i; prev--){
                if(arr[prev] < arr[i] && 1 + dp1[prev] > dp1[i]){
                    dp1[i] = 1 + dp[prev];
                }
            }
            maxi = Math.max(maxi, dp[i] + dp1[i] - 1);
        }
        return maxi;
    }
}

