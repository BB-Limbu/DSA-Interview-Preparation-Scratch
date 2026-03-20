
public class knapsack {
    public static int knap(int[] weight, int[] val, int capacity){

        double[][] ratio = new double[val.length][1];

        for(int i = 0; i < val.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        int finalVal = 0;
        for(int i = ratio.length-1; i >= 0; i--){
            int idx = (int) ratio[i][0];
            if(capacity >= weight[idx]){
                finalVal += val[idx];
                capacity -= weight[idx];
            }
            else{
                finalVal += (ratio[i][1] * weight[idx]);
                capacity = 0;
                break;
            }
        }
        return finalVal;
    }
}

