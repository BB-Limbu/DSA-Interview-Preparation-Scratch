public class DigitalFreqScore {
    public static int digitalFreqScore(int n){
        int arr[] = new int[n];
        int idx = n;

        while(idx != 0){
            arr[idx % 10]++;
            idx /= 10;
        }
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += i * arr[i];
        }
        return sum;
    }
    public static void main(String[] args){
        int n = 122;
        System.out.println(digitalFreqScore(n));
    }
}
