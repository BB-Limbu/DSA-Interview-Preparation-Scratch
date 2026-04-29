

public class LongestDuplicateSubstring {

    public static String longestDupSubstring(String s) {
        int left = 1, right = s.length() - 1;
        String ans = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String dup = search(s, mid);

            if (!dup.equals("")) {
                ans = dup;       // found duplicate of length mid
                left = mid + 1;  // try longer
            } else {
                right = mid - 1; // try shorter
            }
        }

        return ans;
    }

    private static String search(String s, int len) {
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i <= s.length() - len; i++) {
            String sub = s.substring(i, i + len);

            if (seen.contains(sub)) {
                return sub;
            }

            seen.add(sub);
        }

        return "";
    }
}
