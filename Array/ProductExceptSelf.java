public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        ans[0] = 1;

        for(int l = 1; l < n; l++){
            ans[l] = ans[l-1] * arr[l-1];
        }

        int rightProduct = 1;
        for(int r = n-1; r >= 0; r--){
            ans[r] = ans[r] * rightProduct;
            rightProduct *= ans[r];
        }
        return ans;
    }
    public static void main(String[] args){
        int[] arr ={1,2,3,4};

        int[] ans = productExceptSelf(arr);
        for(int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }
}
