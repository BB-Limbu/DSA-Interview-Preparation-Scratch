public class MaxVisiblePoints {

        public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
            int same = 0;
            List<Double> angles = new ArrayList<>();

            int posx = location.get(0);
            int posy = location.get(1);

            // Step 1: Convert to angles
            for (List<Integer> p : points) {
                int x = p.get(0), y = p.get(1);

                if (x == posx && y == posy) {
                    same++;
                } else {
                    double theta = Math.atan2(y - posy, x - posx);
                    angles.add(Math.toDegrees(theta));
                }
            }

            // Step 2: Sort
            Collections.sort(angles);

            // Step 3: Duplicate list (circular handling)
            int n = angles.size();
            List<Double> extended = new ArrayList<>(angles);
            for (double a : angles) {
                extended.add(a + 360);
            }

            // Step 4: Sliding window
            int maxVisible = 0;
            int left = 0;

            for (int right = 0; right < extended.size(); right++) {
                while (extended.get(right) - extended.get(left) > angle) {
                    left++;
                }
                maxVisible = Math.max(maxVisible, right - left + 1);
            }

            return maxVisible + same;
        }
}
