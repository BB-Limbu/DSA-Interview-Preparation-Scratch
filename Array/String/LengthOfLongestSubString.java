

public class LengthOfLongestSubString {
    /*
    Q.Longest Sub String without repeating character
    Brute Force
    Time Complexity O(n^2)
    Space Complexity O(n)
     */
    public static int longestSubStr(String s){
        int n = s.length();
        int maxLen = 0;

        for(int i = 0; i < n; i++){
            HashSet<Character> set = new HashSet<>();
            for(int j = i; j < n; j++){

                if(set.contains(s.charAt(j)))
                    break;
                set.add(s.charAt(j));
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }

        return maxLen;
    }
    /*
    Optimal Approach
    Time Complexity O(n) + O(n)
    Space Complexity O(n)
     */
    public static int longestSubString(String s){
        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            while(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }
    public static void main(String[] args){
        String str = "bbb";
        System.out.println(longestSubString(str));
        System.out.println(longestSubStr(str));
    }
}

