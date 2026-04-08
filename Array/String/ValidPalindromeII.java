

public class ValidPalindromeII {
    public static boolean isValidPalindrome(String s){
        int left = 0;
        int right = s.length()-1;

        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else{
                return isValid(s,left+1, right) || isValid(s, left, right-1);
            }
        }
        return true;
    }

    public static boolean isValid(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
        }
        return true;
    }
}

