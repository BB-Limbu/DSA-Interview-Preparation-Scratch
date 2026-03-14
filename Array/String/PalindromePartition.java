package String;
public class PalindromePartition {
    public static boolean isPalindrome(int i, int j, String str){
        while(i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static int helper(int idx, int n, String str){
        if(idx == n){
            return 0;
        }
        int minCost = Integer.MAX_VALUE;
        for(int j = idx; j < n; j++){
            if(isPalindrome(idx,j, str)) {
                int cost = 1 + helper(j + 1, n, str);
                minCost = Math.min(minCost, cost);
            }
        }
        return minCost;
    }
    public static int  palindromePartition(String str) {
        int n = str.length();
        return helper(0, n, str)-1;
    }
}

