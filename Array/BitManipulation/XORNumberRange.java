package BitManipulation;



public class XORNumberRange {
    /*
    Q.XOR of number in a given range
    Better Approach
    Time Complexity O(n)
    Space Complexity O(1)
     */
    public static int numberRangeXOR(int  l, int r){
        int ans = 0;

        for(int i = l; i < r; i++){
            ans ^= i;
        }
        return ans;
    }
    /*
    optimal Approach
    Time Complexity O(1)
    Space Complexity O(1)
     */

    public static int numRangeXor(int n){
        if(n % 4 == 1) return 1;
        else if(n % 4 == 2) return n +1;
        else if(n % 4 == 3) return 0;
        else return n;
    }
    /*
    Q. Followup question
    Function to find the XOR
    of numbers from L to R
     */

    public static int findRangeXOR(int l, int r){
        return numRangeXor(l-1) ^ numRangeXor(r);
    }
    public static void main(String[] args){
        int l = 3, r = 5;
        System.out.println(findRangeXOR(l,r));
    }
}
