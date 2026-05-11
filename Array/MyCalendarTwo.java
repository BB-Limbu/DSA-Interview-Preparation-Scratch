class MyCalendarTwo {
    private List<int[]> bookings;
    private List<int[]> overlaps;

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlaps = new ArrayList<>();

    }

    public boolean book(int startTime, int endTime) {
        for (int[] interval : overlaps) {
            int start = interval[0];
            int end = interval[1];

            if (Math.max(start, startTime) < Math.min(end, endTime)) {
                return false;
            }
        }
        for (int[] interval : bookings) {
            int start = interval[0];
            int end = interval[1];

            int overlapStart = Math.max(start, startTime);
            int overlapEnd = Math.min(end, endTime);

            if (overlapStart < overlapEnd) {
                overlaps.add(new int[]{overlapStart, overlapEnd});
            }
        }
        bookings.add(new int[]{startTime, endTime});
        return true;
    }
}
