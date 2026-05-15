public class PalindromeSubsequence {
        public int maxProduct(String s) {
            int n = s.length();
            int total = 1 << n;

            int[] palLen = new int[total];
            for (int mask = 1; mask < total; mask++) {

                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) != 0) {
                        sb.append(s.charAt(i));
                    }
                }

                if (isPalindrome(sb)) {
                    palLen[mask] = sb.length();
                }
            }

            int ans = 0;
            for (int m1 = 1; m1 < total; m1++) {

                if (palLen[m1] == 0) continue;

                for (int m2 = m1 + 1; m2 < total; m2++) {

                    if (palLen[m2] == 0) continue;

                    // disjoint subsequences
                    if ((m1 & m2) == 0) {

                        ans = Math.max(ans,
                                palLen[m1] * palLen[m2]);
                    }
                }
            }

            return ans;
        }

        private boolean isPalindrome(CharSequence s) {

            int l = 0;
            int r = s.length() - 1;

            while (l < r) {

                if (s.charAt(l) != s.charAt(r)) {
                    return false;
                }

                l++;
                r--;
            }

            return true;
        }
}
