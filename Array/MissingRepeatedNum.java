public class MissingRepeatedNum {
    /*
    Q.Find the repeating and missing number
    Time Complexity O(n^2)
    Space Complexity O(1)
     */
    public static int[] missingRepeatNum(int[] nums){
        int n = nums.length;

        int repNum = -1;
        int misNum = -1;

        for(int i = 1; i <= n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(nums[j] == i){
                    count++;
                }
            }
            if(count == 2){
                repNum = i;
            }
            else if(count == 0){
                misNum = i;
            }
            if(repNum != -1 && misNum != -1){
                break;
            }
        }
        return new int[] {repNum, misNum};
    }
    /*
    Better Approach
    Time Complexity O(2n)
    Space Complexity O(n)
     */

    public static int[] missingRepeatNum1(int[] nums){
        int n = nums.length;

        int[] hash = new int[n  + 1]; //Bydefault 0

        for(int i = 0; i < n; i++){
            hash[nums[i]]++; //index element increment by 1
        }

        int repNum = -1, misNum = -1;

        for(int i = 1; i <= n; i++){
            if(hash[i] == 2){
                repNum = i;
            }
            else if(hash[i] == 0){
                misNum = i;
            }
            if(repNum != -1 && misNum != -1){
                break;
            }
        }
        return new int[] {repNum, misNum};
    }
    /*
    Optimal Approach
    Time Complexity O(n)
    space Complexity O(1)
     */
    public static int[] missingRepeatNum2(int[] nums){
        long n = nums.length;

        long sn = (n * (n + 1)) / 2;
        long s2n = (n * (n + 1) * (2 * n + 1)) / 6;

        long s = 0, s2 = 0;
        for(int i = 0; i < n; i++){
            s += nums[i];
            s2 += (long) nums[i] * (long) nums[i];
        }
        //s -sn = x -y

        long val1 = s - sn;

        //s2 - s2n = x^2 - y^2
        long val2 = s2 - s2n;

        val2 = val2 / val1;

        long x = (val1 + val2) / 2;
        long y = x - val1;

        return new int[] {(int) x, (int) y};

    }
}
