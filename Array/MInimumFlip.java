public class MInimumFlip {

        public int minFlips(String s) {
            final int INF = 1_000_000_000;

            // state for subsequence "011": 0,1,2,3(=forbidden)
            // state for subsequence "110": 0,1,2,3(=forbidden)
            int[][] dp = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) dp[i][j] = INF;
            }
            dp[0][0] = 0;

            for (char ch : s.toCharArray()) {
                int[][] ndp = new int[3][3];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) ndp[i][j] = INF;
                }

                for (int a = 0; a < 3; a++) {
                    for (int b = 0; b < 3; b++) {
                        if (dp[a][b] == INF) continue;

                        for (int bit = 0; bit <= 1; bit++) {
                            int cost = (ch - '0' == bit) ? 0 : 1;

                            int na = next011(a, bit);
                            int nb = next110(b, bit);

                            if (na < 3 && nb < 3) {
                                ndp[na][nb] = Math.min(ndp[na][nb], dp[a][b] + cost);
                            }
                        }
                    }
                }

                dp = ndp;
            }

            int ans = INF;
            for (int a = 0; a < 3; a++) {
                for (int b = 0; b < 3; b++) {
                    ans = Math.min(ans, dp[a][b]);
                }
            }
            return ans;
        }

        // Transition for subsequence "011"
        private int next011(int state, int bit) {
            if (state == 0) {
                return (bit == 0) ? 1 : 0;
            } else if (state == 1) {
                return (bit == 1) ? 2 : 1;
            } else { // state == 2
                return (bit == 1) ? 3 : 2;
            }
        }

        // Transition for subsequence "110"
        private int next110(int state, int bit) {
            if (state == 0) {
                return (bit == 1) ? 1 : 0;
            } else if (state == 1) {
                return (bit == 1) ? 2 : 1;
            } else { // state == 2
                return (bit == 0) ? 3 : 2;
            }
        }
    }
