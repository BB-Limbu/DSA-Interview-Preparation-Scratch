

public class CountSetBit {
    /*
    Time complexity O(n)
    Space Complexity O(1)
     */
    public static int countSetBits(int n){
        int count = 0;
        while(n > 0){
            count += n & 1;
            n = n >> 1;
//            if(n == 1){
//                count += 1;
//            }
        }
        return count;
    }
    public static int countSetBit(int n){
        int count = 0;
        while(n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
    public static void main(String[] args){
        int n = 15;
        System.out.println("The Set bits of " + n + " is : " + countSetBit(n));
    }
}

