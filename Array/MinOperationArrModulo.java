

public class MinOperationArrModulo {
    public static int minOperation(int[] arr, int k){
        int[] evenCost = new int[k];
        int[] oddCost = new int[k];

        for(int i = 0; i < arr.length; i++){
            int rem = arr[i] % k;
            for(int j = 0; j < k; j++){
                int diff = Math.abs(rem - j);
                int cost = Math.min(diff, k-diff);
                if(i % 2 == 0){
                    evenCost[j] += cost;
                }
                else{
                    oddCost[j] += cost;
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++){
            for(int j = 0; j < k; j++){
                if(i != j){
                    ans = Math.max(ans, evenCost[i] + oddCost[j]);
                }
            }
        }
        return ans;
    }
}

