
public class ConcatArrWithReverse {
    public static int[] concatArrWithReverse(int[] nums){
        int n = nums.length;
        int[] ans = new int[2*n];
        for(int i = 0; i < n; i++){
            ans[i] = nums[i];
        }
        for(int i = 0; i < n; i++){
            ans[n+i] = nums[n-i-1];
        }
        return ans;
    }
    public static void main(String[] args){
        int[] num= {1,2,3};
        int[] res = concatArrWithReverse(num);
        for(int i = 0; i < res.length; i++){
            System.out.print(res[i]+" ");
        }

    }
}

