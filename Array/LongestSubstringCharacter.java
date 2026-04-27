

public class LongestSubstringCharacter {
    /*
    Longest Substring Without Repeating Characters
    Brute Force Approach
    Time Complexity O(n^2)
    Space Complexity O(1)
     */
    public static int longestSubStrinCharacter(String s){
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int maxLen  = 0;
        for(int i = 0; i < n; i++){
            maxLen = s.charAt(i);
            for(int j = i; j < n; j++){
                maxLen = Math.max(maxLen, j-i + 1);
            }
        }
        return maxLen;
    }

    /*
    Optimal Approach
    Time Complexity O(n)
    Space Complexity O(n)
     */

    public static int longestSubStrCharacter(String s){
        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;

        for(int right = 0; right < s.length(); right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left+1);
        }
        return maxLen;
    }
}

