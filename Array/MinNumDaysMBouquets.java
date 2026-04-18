


public class MinNumDaysMBouquets {
    /*
    Q.Min number of days to make m bouquets
    Brute Force
    Time Complexity O(n^2)
    Space Complexity o(1)
     */
    public static int minDaysBouquets(int[] bloomDay, int m, int k){
        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();

        for(int day = low; day <= high; day++){
            if(isPossible(bloomDay,m,k,day)){
                return day;
            }
        }
        return -1;
    }
    public static boolean isPossible(int[] bloomDay, int m, int k, int days){
        int count = 0, bouquets = 0;
        for(int i = 0; i < bloomDay.length; i++){
            if(bloomDay[i] <= days){
                count++;
                if(count == k){
                    bouquets++;
                    count = 0;
                }
                else{
                    count = 0;
                }
            }
        }
        return bouquets >= m;
    }
    /*
    Optimal Approach
    Time Complexity O(log2n)
    Space Complexity O(1)
     */

    public static int minDays(int[] bloomDay, int m, int k){
        int n = bloomDay.length;
        if((long) m * k > n){
            return -1;
        }
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for(int bloom : bloomDay){
            low = Math.min(low, bloom);
            high = Math.max(high, bloom);
        }
        int ans = 0;
        while(low <= high){
            int day = low + ( high - low) / 2;
            if(isPossibles(bloomDay, m,k, day)){
                ans = day;
                high = day - 1;
            }
            else{
                low = day + 1;
            }
        }
        return low; // or ans --> low is opposite polarity
    }

    public static boolean isPossibles(int[] bloomDay, int m, int k, int day){
        int count = 0, bouquets = 0;

        for(int i = 0 ; i < bloomDay.length; i++){
            if(bloomDay[i] <= day){
                count++;

                if(count == k){
                    bouquets++;
                    count = 0;
                }
                count = 0;
            }
        }
        return bouquets >= m;
    }
}
