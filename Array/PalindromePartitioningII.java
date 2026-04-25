public class PalindromePartitioningII {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];
        int[] cuts = new int[n];

        for (int i = 0; i < n; i++) {
            cuts[i] = i; // maximum cuts
        }

        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {

                if (s.charAt(start) == s.charAt(end) &&
                        (end - start <= 1 || pal[start + 1][end - 1])) {

                    pal[start][end] = true;

                    if (start == 0) {
                        cuts[end] = 0;
                    } else {
                        cuts[end] = Math.min(cuts[end], cuts[start - 1] + 1);
                    }
                }
            }
        }

        return cuts[n - 1];
    }
}
