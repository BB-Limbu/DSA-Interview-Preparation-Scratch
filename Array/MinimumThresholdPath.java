public class MinimumThresholdPath {
        private int[] head, to, weight, next;
        private int n, source, target, k;
        public int minimumThreshold(int n, int[][] edges, int source, int target, int k) {
            if(source == target) return 0;

            this.n = n;
            this.source = source;
            this.target = target;
            this.k = k;
            int m = edges.length;
            this.head = new int[n];
            this.to = new int[m << 1];
            this.weight = new int[m << 1];
            this.next = new int[m << 1];
            Arrays.fill(head, -1);
            for(int i = 0; i < m; i++) {
                int a = edges[i][0], b = edges[i][1], c = edges[i][2];
                to[i << 1] = b;
                next[i << 1] = head[a];
                head[a] = i << 1;

                to[i << 1 | 1] = a;
                next[i << 1 | 1] = head[b];
                head[b] = i << 1 | 1;

                weight[i << 1] = weight[i << 1 | 1] = c;
            }

            if(!check(Integer.MAX_VALUE)) return -1;
            if(k == m) return 0;

            int left = 0, right = 0;
            for(int[] edge : edges) {
                if(edge[2] > right) right = edge[2];
            }

            //binary search on the answer
            while(left < right) {
                int mid = left + right >>> 1;
                if(check(mid)) right = mid;
                else left = mid + 1;
            }
            return left;
        }

        private boolean check(int threshold) {
            //0-1 BFS
            int[] dist = new int[n];
            Arrays.fill(dist, k + 1);
            dist[source] = 0;

            ArrayDeque<Integer> queue = new ArrayDeque<>(n);
            queue.add(source);

            while(!queue.isEmpty()) {
                int current = queue.poll();
                if(current == target) return true;


                int currentDist = dist[current];

                for(int i = head[current]; i != -1; i = next[i]) {
                    int node = to[i];
                    int newWeight = weight[i] > threshold ? 1 : 0;
                    int newDist = newWeight + currentDist;

                    if(newDist < dist[node]) {
                        dist[node] = newDist;
                        if(newWeight == 0) queue.addFirst(node);
                        else queue.addLast(node);
                    }
                }
            }
            return false;
        }
    }
