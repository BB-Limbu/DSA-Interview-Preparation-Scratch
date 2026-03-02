

public class MinimumOR {
    public static int minOR(int[][] grid){
        int res = 0;

        for(int i = 20; i >= 0; --i){
            int binary = i << i;

            int bitMask = res | (binary -1);
            for(int[]  r : grid){
                boolean row_all_bad = true;
                for(int a : r){
                    if((a & bitMask) == a){
                        row_all_bad = false;
                        break;
                    }
                }
                if(row_all_bad){
                    res |= binary;
                    break;
                }
            }
        }
        return  res;
    }
}
