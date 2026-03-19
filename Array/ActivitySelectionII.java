

public class ActivitySelectionII {
    public static List<Integer> maxActivity(int[] start, int[] end){
        int[][] activities = new int[start.length][3];

        for(int i =0 ; i < start.length; i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        List<Integer> list = new ArrayList<>();

        int maxCount = 1;
        list.add(activities[0][0]);
        int lastEnd = activities[0][2];

        for(int i = 1; i < end.length; i++){
            if(activities[i][1] >= lastEnd){
                maxCount++;
                list.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }
        return list;
    }
}

