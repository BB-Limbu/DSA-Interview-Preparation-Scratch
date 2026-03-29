import java.util.*;
public class GenerateParenthesis {
    /*
    Brute Force
    Time Complexity O(2^(2n) * n)
    Space Complexity O(n)
     */
    public static boolean isValid(String s){
        int count = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                count++;
            }
            else{
                count--;
            }
            if(count < 0){
                return false;
            }
        }
        return count == 0;
    }
    public static void generateAll(String curr, int n, List<String> res){
        if(curr.length() == 2*n) {
            if (isValid(curr)) {
                res.add(curr);
            }
            return;
        }
        generateAll(curr + "(", n, res);
        generateAll(curr + ")", n, res);
    }
    public static List<String> generateParenthesis(int n){
        List<String> res = new ArrayList<>();
        generateAll("", n, res);
        return res;
    }
    /*
    Optimal Solution
    Time Complexity O(2^n)
    SPACE Complexity O(n)
     */
    public static void backtrack(String str, int open, int close, int n, List<String> res){
        if(str.length() == 2*n){
            res.add(str);
            return;
        }
        if(open < n){
            backtrack(str + "(", open+1, close, n,res);
        }
        if(close < open){
            backtrack(str + ")",open, close+1, n, res);
        }
    }
    public List<String> generate_Parenthesis(int n){
        List<String>  res = new ArrayList<>();
        backtrack("", 0, 0, n,res);
        return res;
    }
}

