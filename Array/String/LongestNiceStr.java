


public class LongestNiceStr {
    /*
    Q. Longest Nice Substring
    Optimal Approach
    Time Complexity O(n) + O(n)
    Space Complexity O(n)
     */
    public static String longestNiceString(String s){

        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            set.add(s.charAt(i));
        }

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(set.contains(Character.toUpperCase(ch)) && set.contains(Character.toLowerCase(ch))){
                continue;
            }
            String leftChar = longestNiceString(s.substring(0,i));
            String rightChar = longestNiceString(s.substring(i+1));

            return leftChar.length() >= rightChar.length() ? leftChar : rightChar;
        }
        return s;
    }

}

