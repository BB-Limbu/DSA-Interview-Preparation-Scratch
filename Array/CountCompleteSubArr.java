public class CountCompleteSubArr {
        public int countCompleteSubarrays(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) set.add(num);
            int totalDistinct = set.size();

            // Step 2: sliding window
            Map<Integer, Integer> freq = new HashMap<>();
            int left = 0, count = 0;

            for (int right = 0; right < nums.length; right++) {
                freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

                // When window is complete
                while (freq.size() == totalDistinct) {
                    count += nums.length - right;

                    // shrink window
                    freq.put(nums[left], freq.get(nums[left]) - 1);
                    if (freq.get(nums[left]) == 0) {
                        freq.remove(nums[left]);
                    }
                    left++;
                }
            }

            return count;
        }
    }
