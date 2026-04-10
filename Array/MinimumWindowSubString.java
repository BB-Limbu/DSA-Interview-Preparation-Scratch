

public class MinimumWindowSubString {
    public static String minWindow(String s, String t){
        int[] tCount = new int[256];

        for (char ch : t.toCharArray()) {
            tCount[ch]++;
        }

        int left = 0, right = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);

            // include character
            if (tCount[ch] > 0) {
                count++;
            }
            tCount[ch]--;

            // shrink window
            while (count == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                tCount[leftChar]++;

                if (tCount[leftChar] > 0) {
                    count--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}

