

public class GameCanIWin {
    private static Boolean [] dp;
    private static  int max;
    public static boolean canIWin(int maxChoosableInteger, int desiredTotal){
        if(desiredTotal <= 0){
            return true;
        }

        int sum = maxChoosableInteger * (maxChoosableInteger +1) / 2;
        if(sum < desiredTotal){
            return false;
        }

        max = maxChoosableInteger;
        dp = new Boolean[1 << max];
        return solve(0, desiredTotal);
    }

    public static boolean solve(int mask, int remaining){
        if(dp[mask] != null){
            return dp[mask];
        }

        for(int i = 1; i <= mask; i++){
            int bit = 1 << (i -1);
            if((mask & bit) != 0){
                continue;
            }

            if(i >= remaining){
                return dp[mask] = true;
            }

            if(!solve(mask | bit, remaining - 1)){
                return dp[mask] = true;
            }
        }
        return dp[mask] = false;
    }
}

