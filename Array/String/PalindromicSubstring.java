



public class PalindromicSubstring {
    /*
    Q. Palindromic Sub String
    Time Complexity O(n^2)
    Space Complexity O(1)
     */
    public static int palindromicSubStr(String s){
        int n = s.length();
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int len = j - i + 1;
                if(len == 1){
                    count++;
                }
                else if(isPalindrome(s,i,j)){
                    count++;
                }
            }
        }
        return count;
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
    public static int palindromicSubstring(String s){
        int ans = 0;

        for(int i = 0; i < s.length(); i++){
            ans += isValidPalindrome(s,i,i);
            ans += isValidPalindrome(s, i, i + 1);
        }
        return ans;
    }
    public static int isValidPalindrome(String s, int left, int right){
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return count;
    }
}

