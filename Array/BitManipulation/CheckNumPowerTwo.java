package BitManipulation;
public class CheckNumPowerTwo {
    /*
    Time Complexity O(n)
    Space Complexity O(1)
     */
    public static boolean checkNumPowTwo(int n){
        if((n & n-1) == 0){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        int n = 9;
        System.out.println(checkNumPowTwo(n));
    }
}
