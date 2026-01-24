public class Number_pages {
    /*
    Brute Force Approach
    Time Complexity O(n * sum(arr[])-max(arr[]) + 1))
    Space Complexity O(1)
     */
    public static int countStudents(ArrayList<Integer> arr, int pages){
        int n = arr.size();
        int students = 1;
        int pagesStd = 0;

        for(int i = 0; i < n; i++){
            if(pagesStd + arr.get(i) <= pages){
                pagesStd += arr.get(i);
            }else{
                students++;
                pagesStd = arr.get(i);
            }
        }
        return students;
    }
    public static int findPages(ArrayList<Integer> arr, int n, int m){
        if(m > n)
            return -1;

        int lows = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();

        for(int pages = lows; pages <= high; pages++){
            if(countStudents(arr,pages) == m){
                return pages;
            }
        }
        return lows;
    }
    /*
    Optimal Approach
    Time Complexity O(N * log(sum(arr[])-max(arr[])+1)
    Space Complexity O(1)
     */
    public static int countStd(ArrayList<Integer> arr, int pages){
        int std = 1;
        int pagesCount = 0;

        for(int i = 0; i < arr.size(); i++){
            if(pagesCount + arr.get(i) <= pages){
                pagesCount += arr.get(i);
            }else{
                std++;
                pagesCount = arr.get(i);
            }
        }
        return std;
    }

    public static int findPage(ArrayList<Integer> arr, int n, int m){
        if(m > n)
            return -1;

        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();

        while(low <= high){
            int mid = (low + high) / 2;
            if(countStd(arr, mid) > m){
                low = mid + 1;
            }
            else{
                high = mid -1;
            }
        }
        return low;
    }
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(25,46,28,49,24));
        int n =5;
        int m = 4;
        int ans = findPage(arr, n, m);
        System.out.println("The Minimum number of Pages: " + ans);
    }
}

