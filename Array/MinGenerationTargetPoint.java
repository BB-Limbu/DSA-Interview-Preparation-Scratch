public class MinGenerationTargetPoint {
    public int minGenerations(int[][] points, int[] target) {
        Set<String> set = new HashSet<>();
        List<int[]> list = new ArrayList<>();
        for (int[] p : points) {
            String str = p[0] + "," + p[1] + "," + p[2];
            set.add(str);
            list.add(p);
            if (p[0] == target[0] && p[1] == target[1] && p[2] == target[2]) {
                return 0;
            }
        }
        int c = 0;
        while (true) {
            c++;
            List<int[]> newList = new ArrayList<>();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    int a[] = list.get(i);
                    int b[] = list.get(j);
                    if (a[0] == b[0] && a[1] == b[1] && a[2] == b[2]) {
                        continue;
                    }
                    int e = (a[0] + b[0]) / 2;
                    int f = (a[1] + b[1]) / 2;
                    int g = (a[2] + b[2]) / 2;
                    String str = e + "," + f + "," + g;
                    if (!set.contains(str)) {
                        set.add(str);
                        int arr[] = new int[]{e, f, g};
                        if (e == target[0] && f == target[1] && g == target[2]) {
                            return c;
                        }
                        newList.add(arr);
                    }
                }
            }
            if (newList.isEmpty()) {
                return -1;
            }
            list.addAll(newList);
        }
    }
}
