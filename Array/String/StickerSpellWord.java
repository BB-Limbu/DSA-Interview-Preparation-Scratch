package String;

public class StickerSpellWord {

        public int minStickers(String[] stickers, String target) {
            int n = stickers.length;

            // Store frequency of characters for each sticker
            int[][] stickerCount = new int[n][26];

            for (int i = 0; i < n; i++) {
                for (char c : stickers[i].toCharArray()) {
                    stickerCount[i][c - 'a']++;
                }
            }

            Map<String, Integer> memo = new HashMap<>();
            memo.put("", 0);

            int ans = dfs(memo, stickerCount, target);

            return ans;
        }

        private int dfs(Map<String, Integer> memo, int[][] stickers, String target) {

            if (memo.containsKey(target)) {
                return memo.get(target);
            }

            // Count target characters
            int[] targetCount = new int[26];
            for (char c : target.toCharArray()) {
                targetCount[c - 'a']++;
            }

            int min = Integer.MAX_VALUE;

            // Try every sticker
            for (int[] sticker : stickers) {

                // Optimization:
                // Skip sticker if it doesn't contain first char of target
                if (sticker[target.charAt(0) - 'a'] == 0) {
                    continue;
                }

                StringBuilder remaining = new StringBuilder();

                // Build remaining target after using sticker
                for (int i = 0; i < 26; i++) {
                    if (targetCount[i] > 0) {

                        int left = targetCount[i] - sticker[i];

                        for (int j = 0; j < Math.max(0, left); j++) {
                            remaining.append((char) ('a' + i));
                        }
                    }
                }

                String rest = remaining.toString();

                int temp = dfs(memo, stickers, rest);

                if (temp != -1) {
                    min = Math.min(min, 1 + temp);
                }
            }

            int result = (min == Integer.MAX_VALUE) ? -1 : min;

            memo.put(target, result);

            return result;
        }
    }
