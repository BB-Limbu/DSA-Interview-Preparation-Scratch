


public class MagneticForce2Balls {
    public static int maxDistance(int[] position, int m){
        Arrays.sort(position);
        int n = position.length;
        int low = 1;
        int high = position[n-1] - position[0];
        int ans = 0;
        for(int gap = low; gap <= high; gap++){
            if(isPosition(position, m, gap)){
                ans =  gap;
            }
            else{
                break;
            }
        }
        return ans;
    }

    private static boolean isPosition(int[] position, int m, int gap){
        int last = position[0];
        int count = 1;

        for(int i = 1; i < position.length; i++){
            if(position[i] - last >= gap){
                count++;
                last = position[i]; // update current position
            }
            if(count >= m) {
                return true;
            }
        }

        return false;
    }

    public static int maxDistTwoBalls(int[] position, int m){
        Arrays.sort(position);
        int low = 1;
        int high = position[position.length-1]  - position[0];
        int ans = 0;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPositions(position, m, mid)){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }

    public static boolean isPositions(int[] position, int m, int mid){
        int last = position[0];
        int count = 1;
        for(int i = 1; i < position.length; i++){
            if(position[i] - last >= mid){
                count++;
                last = position[i]; // update with current position
            }
            if(count >= m){
                return true;
            }
        }
        return false;
    }
}

