class EarliestFinishTime {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        long ans = Long.MAX_VALUE;

        ans = Math.min(ans,
                solve(landStartTime, landDuration,
                        waterStartTime, waterDuration)); // land -> water

        ans = Math.min(ans,
                solve(waterStartTime, waterDuration,
                        landStartTime, landDuration));   // water -> land

        return (int) ans;
    }

    private long solve(int[] firstStart, int[] firstDur,
                       int[] secondStart, int[] secondDur) {

        int m = secondStart.length;

        int[][] rides = new int[m][2];
        for (int i = 0; i < m; i++) {
            rides[i][0] = secondStart[i];
            rides[i][1] = secondDur[i];
        }

        Arrays.sort(rides, Comparator.comparingInt(a -> a[0]));

        int[] starts = new int[m];

        long[] prefixMinDur = new long[m];
        long[] suffixMinStartPlusDur = new long[m];

        for (int i = 0; i < m; i++) {
            starts[i] = rides[i][0];
        }

        prefixMinDur[0] = rides[0][1];
        for (int i = 1; i < m; i++) {
            prefixMinDur[i] = Math.min(prefixMinDur[i - 1], rides[i][1]);
        }

        suffixMinStartPlusDur[m - 1] =
                (long) rides[m - 1][0] + rides[m - 1][1];

        for (int i = m - 2; i >= 0; i--) {
            suffixMinStartPlusDur[i] = Math.min(
                    suffixMinStartPlusDur[i + 1],
                    (long) rides[i][0] + rides[i][1]
            );
        }

        long best = Long.MAX_VALUE;

        for (int i = 0; i < firstStart.length; i++) {

            long finishFirst = (long) firstStart[i] + firstDur[i];

            int pos = upperBound(starts, (int) finishFirst);

            // second ride already open when first finishes
            if (pos > 0) {
                best = Math.min(best,
                        finishFirst + prefixMinDur[pos - 1]);
            }

            // need to wait for second ride to open
            if (pos < m) {
                best = Math.min(best,
                        suffixMinStartPlusDur[pos]);
            }
        }

        return best;
    }

    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;

    }
}
