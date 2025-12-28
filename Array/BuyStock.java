public class BuyStock {
    public int buySellStocks(int[] prices){
        if(prices == null || prices.length <= 1) return 0;

        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] rest = new int[n];

        buy[0] = -prices[0];
        sell[0] = 0;
        rest[0] = 0;

        for(int i = 0; i < n; i++){
            buy[i] = Math.max(buy[i-1] , sell[i-1] - rest[i]);
            sell[i] = Math.max(buy[i-1], sell[i-1] + rest[i]);
            rest[i] = Math.max(rest[i-1], sell[i-1]);
        }
        return Math.max(sell[n-1], rest[n-1]);
    }
}
