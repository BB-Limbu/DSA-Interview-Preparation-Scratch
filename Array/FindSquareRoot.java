

public class FindSquareRoot {
    /*
    Brute Force Approach
    Time Complexity o(n)
    Space Complexity O(1)
     */
    public static int findSquareRoot(int n){
        int ans = 1;
        for(int i =1 ; i <= n; i++){
            if(i * i <= n){
                ans = i;
            }
            else
                break;
        }
        return ans;
    }
    /*
    Optimal Approach
    Time Complexity O(log n)
    Space Complexity O(1)
     */
    public static long findSquareRoot1(int n){
        long low = 0, high = n;
        while(low <= high){
            long mid = (low + high) / 2;
            long val = (mid * mid);

            if(val <= n){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return high;
    }
    public static void main(String[] args){
        int n = 28;
        long ans = findSquareRoot(n);
        System.out.println("Square root of "+ n  + " is :" +ans);
    }
}
