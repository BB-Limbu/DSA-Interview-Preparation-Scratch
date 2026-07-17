

public class QuerySegmentTree {

    static int tree[];

    public static void treeInit(int n){
        tree = new int[4*n];
    }

    public static int buildST(int[] arr, int idx, int start, int end){
        if(start == end){
            tree[idx] = arr[start];
            return tree[idx];
        }
        int mid = (start + end) / 2;
        buildST(arr, 2*idx+1, start, mid);
        buildST(arr, 2*idx+2, mid +1, end);
        tree[idx]  = tree[2*idx+1] + tree[2*idx+2];

        return tree[idx];
    }
    public static  int getSumUtil(int i, int si, int sj, int qi, int qj){
        if(qj <= si || qi >= sj){
            return 0;
        }
        else if(si >= qi && sj  <= qj){
            return tree[i];
        }
        else{
            int mid = (si + sj) / 2;
            int left = getSumUtil(2*i+1, si, mid, qi, qj);
            int right = getSumUtil(2*i+2, mid+1, sj,qi, qj);

            return left + right;
        }
    }


    public static int getSum(int[] arr, int qi, int qj){
        int n = arr.length;
        return getSumUtil(0,0,n-1,qi,qj);
    }

    public static void updateUtil(int i, int si, int sj, int idx, int diff){
        if(idx > sj || idx < si){
            return;
        }
        tree[i] += diff;
        if( si != sj){ //non -leaf
            int mid = (si+sj)/2;
            updateUtil(2*i+1, si, mid, idx, diff); //left
            updateUtil(2*i+2, mid+1, sj, idx, diff);//right

        }
    }

    public static void update(int arr[], int idx, int newVal){
        int n = arr.length;
        int diff = newVal - arr[idx];
        arr[idx] = newVal;

        updateUtil(0,0,n-1,idx, diff); //Segment tree update
    }

}

