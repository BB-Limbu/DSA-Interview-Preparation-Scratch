public class ArrayPairs {
        public static boolean canArrange(int[] arrs, int k){
            int[] rem = new int[k];

            for(int arr : arrs){
                int r = ((arr % k) + k) % k;
                rem[r]++;
            }

            if(rem[0] % 2 != 0){
                return false;
            }

            for(int i = 1; i < k; i++){
                if(rem[i] != rem[k-1]){
                    return false;
                }
            }
            return true;
        }
        public static void main(String[] args){
            int[] arr = {1,2,3,4,5,10,6,7,8,9};
            int k = 5;
            System.out.println(canArrange(arr, k));

        }
    }


