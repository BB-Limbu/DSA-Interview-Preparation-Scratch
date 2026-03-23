

public class LargestKthOddNum {
    public static int kthOdd(int[] range, int k){
        if(k <= 0){
            return 0;
        }
        int L = range[0];
        int R = range[1];

        if((R&1) > 0){
            int count = (int) Math.ceil((R-L+1)/2);
            if( k > count){
                return 0;
            }else{
                return (R-2*k+2);
            }
        }else{
            int count = (R-L+1) /2;
            if(k > count){
                return 0;
            }else{
                return(R-2 *k+1);
            }
        }
    }
}

