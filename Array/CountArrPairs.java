

public class CountArrPairs {
    public long countPairs(int[] nums, int k) {
        long ans = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {

            int g = gcd(num, k);

            // Check previous gcd values
            for (int prevGcd : map.keySet()) {

                if ((1L * g * prevGcd) % k == 0) {
                    ans += map.get(prevGcd);
                }
            }

            map.put(g, map.getOrDefault(g, 0) + 1);
        }

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
