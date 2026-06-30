

public class CatalanNumber {
    //Recursive Approach
    public static int catalanRec(int n){
        //Base Case
        if(n == 0 || n == 1){
            return 1;
        }
        int ans = 0;

        for(int i = 0; i < n; i++){
            ans += catalanRec(i) * catalanRec(n-i-1);
        }
        return ans;
    }

    //Memoization Approach
    public static int catalanMemoization(int n){
        //Base Case
        if(n == 0 || n == 1){
            return 1;
        }

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        if(dp[n] != -1){
            return dp[n];
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans += catalanMemoization(i) * catalanMemoization(n-i-1);
        }
        return dp[n] = ans;
    }

    //Tabulation Approach (Iteration Approach)
    public static int catalanTabulation(int n){

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;

        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static void main(String[] args){
        int n = 4;
        System.out.println(catalanRec(n));
        System.out.println(catalanMemoization(n));
        System.out.println(catalanTabulation(n));
    }
}

