package String;

public class LongestAlmostPalindrome {
    public static int almostLongetPalindrome(String s){
        int n = s.length();
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++){
            maxLen = Math.max(maxLen, expand(s, i , i));
            maxLen = Math.max(maxLen, expand(s, i, i+1));
        }
        return maxLen;
    }

    private static int expand(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        int len1 = checkPalindrome(s, left+1, right);
        int len2 = checkPalindrome(s, left, right-1);

        return Math.max(len1, len2);
    }
    private static int checkPalindrome(String s, int l, int r){
        while( l >= 0 && r < s.length() && s.charAt(l) == s.charAt(2)){
            l--;
            r++;
        }
        return r-l-1;
    }
    public static void main(String[] args){

    }
}

