

public class CoinDenomination {
        /*
        Optimal Approach
        Time Complexity O(n)
        Space Complexity O(n)
         */
        public static List<Integer> coINDenomination(int[] coins, int amount){
                List<Integer> ans = new ArrayList<>();
                int countCoins = 0;
                for(int i = coins.length-1; i >= 0; i--){
                        if(coins[i] <= amount){
                                while(coins[i] <= amount){
                                        countCoins++;
                                        ans.add(coins[i]);
                                        amount -= coins[i];

                                }
                        }
                }
                return ans;
        }
}
