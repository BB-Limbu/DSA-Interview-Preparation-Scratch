public class MyCalendar {
    private TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();

    }

    public static boolean book(int startTime, int endTime) {
        Integer prev = calendar.floorKey(startTime);
        Integer next = calendar.ceilingKey(startTime);

        if (prev != null && calendar.get(prev) > startTime) {
            return false;
        }

        if (next != null && next < endTime) {
            return false;
        }

        calendar.put(startTime, endTime);
        return true;
    }
}

