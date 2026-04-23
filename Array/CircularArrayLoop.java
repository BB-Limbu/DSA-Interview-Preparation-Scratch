public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) continue;

            int slow = i, fast = i;
            boolean forward = nums[i] > 0;

            while(true) {
                slow = nextIndex(nums, slow, forward);
                if(slow == -1) break;

                fast = nextIndex(nums, fast, forward);
                if(fast == -1) break;

                fast = nextIndex(nums, fast, forward);
                if(fast == -1) break;

                if(slow == fast) return true;
            }

            // Mark visited path as 0
            int index = i;
            while(nums[index] != 0 && (nums[index] > 0) == forward) {
                int next = ((index + nums[index]) % n + n) % n;
                nums[index] = 0;
                index = next;
            }
        }

        return false;
    }
    private int nextIndex(int[] nums, int current, boolean forward) {
        boolean direction = nums[current] > 0;

        if(direction != forward) return -1;

        int n = nums.length;
        int next = ((current + nums[current]) % n + n) % n;

        if(next == current) return -1;

        return next;
    }
}
