

public class ShipCapacity {
    /*
    Brute Force Approach
     */
    public int shipCapacity(int[] weights, int capacity){
        int minLeft = Arrays.stream(weights).max().getAsInt();
        int maxRight = Arrays.stream(weights).sum();

        for(int cap = minLeft; cap <= maxRight; cap++){
            int totalCapacity = dDays(weights, cap);
            if(totalCapacity <= capacity){
                return cap;
            }
        }
        return maxRight;
    }
    private int dDays(int[] nums, int cap){
        int day = 1;
        int load = 0;
        for(int num : nums){
            if(load + num > cap){
                day++;
                load = num;
            }
            else{
                load += num;
            }
        }
        return day;
    }
    /*
    Optimal Approach
     */

    public int ship_Capacity(int[] weight, int capacity){
        int day = 1;
        int currLoad = 0;

        for(int num : weight){
            if(currLoad + num > capacity){
                day++;
                currLoad = num;
            }
            else{
                currLoad += num;
            }
        }
        return day;
    }
    public int shipDayCapacity(int[] arr, int day){
        int left = Arrays.stream(arr).max().getAsInt();
        int right = Arrays.stream(arr).sum();

        while(left < right){
            int mid = left + (right - left) / 2;
            int needed = ship_Capacity(arr, mid);
            if(needed <= day){
                right = mid;
            }
            else{
                left = mid +1;;
            }
        }
        return left;
    }
    public static void main(String[] args){
        int[] weights = {5,4,5,2,3,4,5,6};
        // Days to ship
        int d = 5;
        ShipCapacity sol = new ShipCapacity();
        System.out.println(sol.shipCapacity(weights, d));

    }
}

