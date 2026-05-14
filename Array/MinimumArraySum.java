

public class MinimumArraySum {

    public long minArraySum(int[] nums) {
        TreeMap<Integer, Integer> cnt = new TreeMap<>();
        int M = 0;
        for (int a : nums) {
            cnt.put(a, cnt.getOrDefault(a, 0) + 1);
            M = Math.max(M, a);
        }

        long res = 0;
        for (int a : cnt.keySet()) {
            if (cnt.get(a) > 0) {
                for (int b = a; b <= M; b += a) {
                    if (cnt.containsKey(b) && cnt.get(b) > 0) {
                        res += (long) cnt.get(b) * a;
                        cnt.put(b, 0);
                    }
                }
            }
        }
        return res;
    }
}

