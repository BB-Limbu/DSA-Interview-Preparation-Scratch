

public class MaxMinSegmentTree {
    static int tree[];
    public static void  init(int n){
        tree = new int[4*n];
    }

    public static void buildST(int[] arr, int i, int si, int sj){
        if(si == sj){
            tree[i] = arr[si];
            return;
        }
        int mid = (si + sj) / 2;
        buildST(arr, 2*i+1, si, mid );
        buildST(arr, 2*i+2, mid+1, sj);

        tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
    }

}
