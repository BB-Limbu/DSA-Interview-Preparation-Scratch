public class Sorting_algo {
//Selection Sort Algorithm base on swap method

    public  static void selectionSort(int arr[], int n){
        for(int i = 0; i <= n - 2; i++){
            int min = i;

            for(int j = i; j <= n - 1; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    //Bubble sort Algo

    public static void bubbleSort(int arr[], int n){
        for(int i = n - 1; i >= 1; i--){
            int didswap = 0;
            for(int j = 0; j <= i -1; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    didswap++;
                }

            }
            if(didswap == 0){
                break;
            }
            System.out.println("runs");
        }
    }

    //Insertion Sort Algo

    public static void insertionSotrt(int arr[], int n){
        for(int i = 0; i <= n -1; i++){
            int j = i;
            while(j > 0 && arr[j - 1] > arr[j]){
                int temp = arr[j -1];
                arr[j -1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }
    public static void  main(String args[]){
        int nums[] = {6,5,8,7,3,1};

        insertionSotrt(nums, nums.length);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
