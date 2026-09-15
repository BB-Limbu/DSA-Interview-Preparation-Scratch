

public class NumLIS {
    public static int numLIS(int[] num){
        int n = num.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] count = new int[n];
        Arrays.fill(count, 1);
        int maxi = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(num[j] < num[i] && dp[j] + 1 > dp[i]){
                    dp[i] = 1 + dp[i];
                    count[i] = count[j];
                }
                else if(num[j] <  num[i] && dp[j] + 1 == dp[i]){
                    count[i] += count[j];
                }
            }
            maxi = Math.max(maxi, dp[i]);

        }
        int countLIS = 0;
        for(int i = 0; i < n; i++){
            if(dp[i] == maxi){
                countLIS += count[i];
            }
        }
        return countLIS;
    }

}
