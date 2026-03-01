public class PrintIncreasingOrder {
    public static void printIncOrder(int n){
        if(n == 1){
            System.out.print(n+" ");
            return;
        }
        printIncOrder(n -1);
        System.out.print(n+" ");
    }
    public static void main(String[] args){
        int n = 10;
        printIncOrder(n);
    }
}