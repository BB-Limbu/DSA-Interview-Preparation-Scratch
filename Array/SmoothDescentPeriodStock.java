

public class SmoothDescentPeriodStock {
    /*
    Q. Number of Smooth Descent Periods of a Stock
     */
    public static long getDescentPeriod(int[] prices){
        long ans = 1, count = 1;
        for(int i = 1; i < prices.length;i++){
            if(prices[i] == prices[i-1] - 1){
                count++;
            }else{
                count = 1;
            }
            ans += count;
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums = {3,2,1,4};
        System.out.println(getDescentPeriod(nums));
    }
}

