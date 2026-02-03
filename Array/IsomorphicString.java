

public class IsomorphicString {
    public  boolean isomorphicString(String str, String str1) {
        if (str.length() != str1.length()) {
            return false;
        }
        int[] m1 = new int[256], m2 = new int[256];
        int n = str.length();

        for (int i = 0; i < n; i++) {
            if (m1[str.charAt(i)] != m2[str1.charAt(i)]) {
                return false;
            }
            m1[str.charAt(i)] = i + 1;
            m2[str1.charAt(i)] = i + 1;

        }
        return true;

    }
}

