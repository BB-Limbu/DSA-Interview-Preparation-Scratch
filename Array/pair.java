
class pair{
    double distance;
    int index;

    pair(double distance, int index){
        this.distance = distance;
        this.index = index;
    }
}

class gas_Station {
    /*
    Brute Force Approach
    Time Complexity O(k*n) + O(n)
    Space Complexity O(n)
     */
    public static double minMaxDistance(int[] arr, int k){
        int n = arr.length;
        int[] howMany = new int[n -1];

        for(int gasStation = 1; gasStation <= k; gasStation++){
            double maxSection = -1;
            int maxIdx = -1;


            //Find the segment with the maximum distance

            for(int i = 0; i < n - 1; i++){
                double diff = arr[i + 1]  - arr[i];
                double sectionLen = diff / (howMany[i] + 1.0);

                if(sectionLen > maxSection){
                    maxSection = sectionLen;
                    maxIdx = i;
                }
            }
            howMany[maxIdx]++;
        }

        double maxAns = -1;
        for(int i = 0; i < n -1; i++){
            double diff = arr[i + 1] - arr[i];
            double sectionLen = diff / (howMany[i] + 1.0);
            maxAns = Math.max(maxAns, sectionLen);
        }
        return maxAns;
    }

    /*
    Better Approach
    Time Complexity O(nlogn + klogn)
    Space Complexity O(n-1)+O(n-1)
     */


    public double minMax_Distance(int[] arr, int k){
        int n = arr.length;
        int[] howMany = new int[n -1];

        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.distance, a.distance));

        for(int i = 0; i < n - 1; i++){
            pq.add(new pair(arr[i+1] - arr[i], i));
        }

        for(int gasStation = 1; gasStation <= k; gasStation++){
            pair top = pq.poll();
            int idx = top.index;
            howMany[idx]++;

            double totalDist = arr[idx + 1] - arr[idx];
            double newDist = totalDist / (howMany[idx] + 1);
            pq.add(new pair(newDist, idx));
        }
        return pq.peek().distance;
    }

    /*
    optimal Approach
    Time Complexity O(n*log(Len)) + O(n)
    Space Complexity O(1)
     */

    public int gasStationRequired(int[] arr, double dist){
        int n = arr.length;
        int count = 0;

        for(int i = 1; i < n; i++){
            int numBtw = (int) ((arr[i] - arr[i-1]) / dist);
            if((arr[i] - arr[i -1]) == (dist * numBtw)){
                numBtw--;
            }
            count += numBtw;
        }
        return count;
    }

    public double minimiseMaxDist(int[] arr, int k){
        int n = arr.length-1;
        double low = 0, high = 0;

        for(int i = 0; i < n; i++){
            high = Math.max(high, arr[i + 1] - arr[i]);
        }

        double diff = 1e-6;

        while(high - low > diff){
            double mid = (low + high) / 2.0;
            int count = gasStationRequired(arr, mid);

            if(count  > k){
                low = mid;
            }else{
                high = mid;
            }
        }
        return high;
    }
}
