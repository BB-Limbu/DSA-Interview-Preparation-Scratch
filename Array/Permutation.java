class Solution {
    public boolean isDigitorialPermutation(int n) {
        int[] factorial = {1,1,2,6,24,120,720,5040,40320,362880};
        long digitSum = 0;
        int original = n;
        int length = Integer.toString(n).length();
        int[] count = new int[10];

        for(int i = 0; i < length; i++){
            int digit  = n % 10;
            n/= 10;
            count[digit]++;
            digitSum += factorial[digit];
        }

        long target = digitSum;
        int[] targetCount = new int[10];
        int targetLength = 0;

        while(target > 0){
            int digit = (int) (target % 10);
            targetCount[digit]++;
            target /= 10;
            targetLength++;
        }
        if(length != targetLength) return false;

        for(int i = 0; i < 10; i++)
        {
            if(targetCount[i] != count[i]) return false;
        }
        return true;
    }
}