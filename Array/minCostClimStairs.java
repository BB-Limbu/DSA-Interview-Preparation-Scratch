public class minCostClimStairs {
    public int costClimbingStairs(int[] cost){
        if(cost.length == 1) return cost[0];
        if(cost.length == 2) return Math.min(cost[0], cost[1]);

        int first = cost[0];
        int second = cost[1];
        for(int i = 2; i <= cost.length; i++){
            int curr = Math.min(first, second) + cost[1];
            first = second;
            second  = curr;
        }
        return Math.min(first, second);
    }
}

