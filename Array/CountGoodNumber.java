
public class CountGoodNumber {
    static final int mod = 1_000_000_007;
    public static int countGoodNumbers(int n, int idx){
        if(idx == n){
            return 1;
        }
        int res = 0;
        if(idx % 2 == 0){
            int[] evenDigit = {0,2,4,6,8};
            for(int digit : evenDigit){
                res = (res + countGoodNumbers(n, idx+1)) % mod;

            }
        }else{
            int[] primeDigit = {1,3,5,7,9};
            for(int digit : primeDigit){
                res = (res + countGoodNumbers(n, idx+1)) % mod;
            }
        }
        return res;
    }
    /*
    Optimal Approach
    Time Complexity O(n^2)
    Space Complexity O (n)
     */
    static final int MOD = 1_000_000_007;
    public static int countGoodNumbers1(long n){
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        long evenPart = power(5, evenCount);
        long oddPart = power(4, oddCount);

        return (int) ((evenPart * oddPart) % MOD);
    }

    private static long power(long base, long exp){
        long res = 1;
        while(exp  > 0){
            if((exp  & 1) == 1){
                res = (res * base) % MOD;
            }
            base =  (base * base) % MOD;
            exp >>= 1;
        }
        return  res;
    }

    /*
    Optimal Approach
    Time Complexity O(n)
    Space Complexity O(1)
     */
    public static int  countGoodNum(long n){
        long countEven1 = (n + 1) /2;
        long countOdd1 = n / 2;

        long evenPart = power(5, countEven1);
        long oddPart = power(4, countOdd1);

        return (int) ((evenPart * oddPart) % MOD);
    }
    private static long power1(long base, long exp){
        long res = 1;
        while(exp > 0){
            if((exp & 1) == 1){
                res = (res * base) % MOD;
            }
            res = (res * res) % MOD;
            exp >>= 1;
        }
        return res;
    }

}

