import java.util.*;

public class DivisorNumber {
    /*
    Q. Divisor of a number
    Time Complexity O(n)
    Space Complexity  O(1)
     */
    public static List<Integer> divisorNum(int n){
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                res.add(i);
            }
        }
        return res;
    }
    /*
    Optimal Approach
    Time Complexity
    Space Complexity
     */

    public static List<Integer> divisorNumber(int n){
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 1; i *i <= n; i++){
            if(n % i == 0){
                ans.add(i);
            }
            if(n/i != i){
                ans.add(n/i);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}

