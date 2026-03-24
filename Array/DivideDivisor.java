

public class DivideDivisor {
    public static long divide(int dividend, int divisor){
        if(dividend ==  divisor){
            return 1;
        }
        boolean sign = true;
        if(dividend >= 0 && divisor < 0){
            sign = false;
        }
        else if(dividend <= 0 && divisor > 0){
            sign = false;
        }
        long n = Math.abs(dividend);
        long d = Math.abs(divisor);
        long quotient = 0;

        while(n >= d){
            int count = 0;
            while(n >= (d << (count+1))){
                count += 1;
            }
            quotient +=  1<<count;
            n -= (d << count);
        }
        if(quotient == (1L << 31) && sign){
            return sign ? Integer.MAX_VALUE :Integer.MIN_VALUE;
        }
        return sign ? quotient : -quotient;
    }
}
