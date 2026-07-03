class ThreeSumMulti {
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        long ans = 0;
        int MOD = 1_000_000_007;

        for (int i = 0; i < n; i++) {
            int t = target - arr[i];
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[left] + arr[right];

                if (sum < t) {
                    left++;
                } else if (sum > t) {
                    right--;
                } else {
                    // arr[left] + arr[right] == t

                    if (arr[left] != arr[right]) {
                        int leftCount = 1;
                        int rightCount = 1;

                        while (left + 1 < right && arr[left] == arr[left + 1]) {
                            leftCount++;
                            left++;
                        }

                        while (right - 1 > left && arr[right] == arr[right - 1]) {
                            rightCount++;
                            right--;
                        }

                        ans += (long) leftCount * rightCount;
                        ans %= MOD;

                        left++;
                        right--;
                    } else {
                        // all numbers between left and right are same
                        int count = right - left + 1;
                        ans += (long) count * (count - 1) / 2;
                        ans %= MOD;
                        break;
                    }
                }
            }
        }

        return (int) (ans % MOD);
    }
}