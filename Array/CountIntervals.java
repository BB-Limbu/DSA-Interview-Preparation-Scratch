class CountIntervals {
    private TreeMap<Integer, Integer> intervals;
    private int totalCount;
    public CountIntervals() {
        intervals = new TreeMap<>();
        totalCount = 0;

    }

    public void add(int left, int right) {
        int newLeft = left;
        int newRight = right;
        Integer start = intervals.floorKey(right);

        while (start != null) {

            int end = intervals.get(start);
            if (end < left) break;
            newLeft = Math.min(newLeft, start);
            newRight = Math.max(newRight, end);

            totalCount -= (end - start + 1);

            intervals.remove(start);

            start = intervals.floorKey(newRight);
        }

        intervals.put(newLeft, newRight);
        totalCount += (newRight - newLeft + 1);

    }

    public int count() {
        return totalCount;

    }
}
