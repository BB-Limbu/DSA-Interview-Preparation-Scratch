

public class PrintDigits {
    static String digits[] = {"zero", "one","two","three","four","five","six","seven","eight", "nine"};

    public static void printDig(int nums){
        if(nums == 0){
            return;
        }
        int lastDigits = nums % 10;
        printDig(nums/10);
        System.out.print(digits[lastDigits]+" ");
    }
    public static void main(String[] args){
        printDig(1992 );
    }
}

