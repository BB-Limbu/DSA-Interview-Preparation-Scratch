

public class SegmentTree {
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

}