

public class MinimizePowerCities {

    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;

        long[] power = new long[n];

        // Initial sliding window power
        long window = 0;

        for (int i = 0; i <= r && i < n; i++) {
            window += stations[i];
        }

        power[0] = window;

        for (int i = 1; i < n; i++) {

            int remove = i - r - 1;
            int add = i + r;

            if (remove >= 0) window -= stations[remove];
            if (add < n) window += stations[add];

            power[i] = window;
        }

        long low = 0;
        long high = (long)1e18;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (canAchieve(power, r, k, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    private boolean canAchieve(long[] power, int r, int k, long target) {

        int n = power.length;

        long[] diff = new long[n + 1];

        long extra = 0;
        long used = 0;

        for (int i = 0; i < n; i++) {

            extra += diff[i];

            long current = power[i] + extra;

            if (current < target) {

                long need = target - current;

                used += need;

                if (used > k) return false;

                extra += need;

                int end = Math.min(n, i + 2 * r + 1);

                diff[end] -= need;
            }
        }

        return true;
    }
}

