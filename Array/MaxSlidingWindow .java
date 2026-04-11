

public class MaxSlidingWindow {
    static class Pair implements Comparable<Pair>{
        int value;
        int index;

        public Pair(int val, int idx){
            this.value = val;
            this.index = idx;
        }
        @Override
        public int compareTo(Pair p2){
            //Sort object in Ascending Order
            //return  this.value - p2.value;

            //Sort object in descending order
            return p2.value - this.value;
        }
    }
    public static void main(String[] args){ // n(nlogk)
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[]  res = new int[arr.length-k+1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i = 0; i < k; i++){
            pq.add(new Pair(arr[i], i));
        }

        res[0] = pq.peek().value;

        for(int i = k; i < arr.length; i++){
            while(pq.size() > 0 && pq.peek().index <= i - k){
                pq.remove();
            }
            pq.add(new Pair(arr[i], i));
            res[i-k+1] = pq.peek().value;
        }

        for(int i = 0; i < res.length; i++){
            System.out.print(res[i] + " ");
        }
    }
}

