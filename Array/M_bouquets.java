

public class M_bouquets {
    /*Brute force Approach
     Time Complexity O(min - max + 1) *n
    Space Complexity O(1)
     */
    public boolean ispossible(int[] bloomDays, int days, int m, int k){
        int count = 0;
        int bouquets = 0;

        for(int bloom : bloomDays){
            if(bloom <= days){
                count++;
                if(count == k){
                    bouquets++;
                    count = 0;
                }
            }
            else{
                count = 0;
            }
        }
        return bouquets >= m;
    }
    public int minDays(int[] bloomDays, int m, int k){
        long totalFlowers = (long) m * k;
        if(totalFlowers > bloomDays.length)
            return -1;

        int min = Arrays.stream(bloomDays).min().getAsInt();
        int max = Arrays.stream(bloomDays).max().getAsInt();

        for(int day = min; day <= max; day++){
            if(ispossible(bloomDays, day, m , k)){
                return day;
            }
        }
        return -1;
    }

    /*
    Optimal Approch
     */
    public boolean isPossible(int[] bloomDay, int day, int m, int k){
        int count = 0;
        int bouquets = 0;

        for(int bloom : bloomDay){
            if(bloom <= day){
                count++;
                if(count == k){
                    bouquets++;
                    count = 0;
                }
            }
            else{
                count = 0;
            }
        }
        return bouquets >= m;
    }

    public int minDay1(int[] bloomDay, int m, int k){
        long totalFlower = (long) m * k;
        if(totalFlower >  bloomDay.length)
            return -1;
        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;

        for(int bloom : bloomDay){
            minDay = Math.min(minDay, bloom);
            maxDay = Math.max(maxDay, bloom);
        }
        int low = minDay, high = maxDay, res = -1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(isPossible(bloomDay, mid, m, k)){
                res = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] bloomDays = {7, 7, 7, 7, 13, 11, 12, 7};
        int k = 3;
        int m = 2;

        M_bouquets garden = new M_bouquets();
        int result = garden.minDay1(bloomDays, k,m);

        if (result == -1)
            System.out.println("We cannot make m bouquets.");
        else
            System.out.println("We can make bouquets on day -> " + result);
    }
}

