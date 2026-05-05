public class MaxWhiteTiles {

        public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
            Arrays.sort(tiles, (a, b) -> a[0] - b[0]);

            int n = tiles.length;
            int left = 0;
            int cover = 0;
            int maxCover = 0;

            for (int right = 0; right < n; right++) {
                // Add full tile coverage
                cover += tiles[right][1] - tiles[right][0] + 1;

                // Shrink window if exceeds carpet
                while (tiles[right][1] - tiles[left][0] + 1 > carpetLen) {
                    cover -= tiles[left][1] - tiles[left][0] + 1;
                    left++;
                }

                // Current carpet end
                int carpetEnd = tiles[left][0] + carpetLen - 1;

                int partial = 0;

                // If partial overlap exists
                if (carpetEnd < tiles[right][1]) {
                    partial = tiles[right][1] - carpetEnd;
                }

                maxCover = Math.max(maxCover, cover - partial);
            }

            return maxCover;
        }
    }
