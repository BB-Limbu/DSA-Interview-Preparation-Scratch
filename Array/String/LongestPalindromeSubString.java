package String;


public class LongestPalindromeSubString {
    /*
    Q.Longest palindromic Substring
    Brute force Approach
    Time Complexity O(n^2)
    SPACE Complexity O(1)
     */
    public static String longestPalindromeSubString(String s){
        if(s == null || s.length() == 0){
            return "";
        }
        int n = s.length();
        String ans = "";

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(isPalindrome(s,i,j)){
                    if(j - i + 1 >= ans.length()){
                        ans = s.substring(i, j  +1);
                    }
                }
            }
        }
        return ans;
    }
    public static boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    /*
    Optimal Approach
    Time Complexity O(n)
    Space Complexity O(1)
     */
    public static String longestPalindromeSubStr(String s){
        if(s == null || s.length() == 0){
            return "";
        }

        int left = 0;
        int right = 0;

        for(int i = 0; i < s.length(); i++) {
            int odd = expandCentre(s, i, i);
            int even = expandCentre(s, i, i + 1);
            int maxLen = Math.max(odd, even);

            if(maxLen > right - left){
                left = i -(maxLen -1) / 2;
                right = i + maxLen /2;
            }
        }
        return s.substring(left, right+1);
    }
    public static int expandCentre(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left -1;
    }

}

