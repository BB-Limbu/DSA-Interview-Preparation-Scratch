

public class AggressiveCows {
    /*
    Brute Force Approch
    Time Complexity O(n log n) + O(n )
    Space Complexity O(1)
     */
    public boolean canPlace(int[] stalls, int cows, int dist){
        int count = 1;
        int lastPos = stalls[0];

        for(int i = 1; i < stalls.length; i++){
            if(stalls[i] - lastPos >= dist){
                count++;
                lastPos = stalls[i];
            }
            if(count >= cows)
                return true;
        }
        return false;
    }
    public int aggrissiveCows(int[] stalls, int cows){
        Arrays.sort(stalls);
        int maxDist = stalls[stalls.length - 1] - stalls[0];
        int ans = 0;

        for(int dist = 1; dist <= maxDist;dist++){
            if(canPlace(stalls,cows,dist)){
                ans = dist;
            }
        }
        return ans;
    }
    /*
    Optimal Approach
    Time Complexity
    SpaceComplexity
     */

    private boolean canweplace(int[] stalls, int cows, int d){
        int count = 1;
        int lastPos = stalls[0];

        for(int i = 0; i < stalls.length; i++){
            if(stalls[i] - lastPos >= d){
                count++;
                lastPos = stalls[i];
            }
            if(count >= cows){
                return true;
            }
        }
        return false;
    }
    public int aggrissive_Cows(int[] stalls, int cows){
        Arrays.sort(stalls);
        int low = 1, high = stalls[stalls.length - 1] -  stalls[0];
        int ans = 0;

        while(low <= high){
            int mid = (low + high) / 2;
            if(canweplace(stalls, mid, cows)){
                ans = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }

        }
        return ans;
    }
    public static void main(String[] args){
        int[] stalls = {1,2,8,4,9};
        int cows = 3;

        AggressiveCows opt = new AggressiveCows();
        int ans = opt.aggrissive_Cows(stalls, cows);
        System.out.print("Aggrissive Cows : " + ans);
    }
}

