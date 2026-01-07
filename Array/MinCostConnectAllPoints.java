public class MinCostConnectAllPoints {
    public int minCostConnAllPoints(int[][] points){
        int n = points.length;
        PriorityQueue<Point> prtyQueue = new PriorityQueue<>((a, b) -> Integer.compare(a.x, b.x));
        boolean[] inMST = new boolean[n];

        int minCost = 0;
        int pointsConnected = 0;
        while(pointsConnected < n){
            Point current = prtyQueue.poll();
            if(inMST[current.x]){
                continue;
            }
            inMST[current.x] = true;
            minCost += current.x;
            pointsConnected++;

            for(int i = 0; i < n; i++){
                if(inMST[i]){
                    int distance = Math.abs(points[current.x][0] - points[i][0]) + Math.abs(points[current.x][1] - points[i][1]);
                    prtyQueue.offer(new Point(i,distance));
                }
            }
        }
        return minCost;

    }
    static class point{
        int index;
        int distance;

        point(int index, int distance){
            this.index = index;
            this.distance = distance;
        }
    }
}

