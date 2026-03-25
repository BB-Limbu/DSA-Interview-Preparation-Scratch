

public class DecimalToBinary {
    /*
    Time complexity log2 n
    Space complexity log2 n
     */
    public static String decimalToBinary(int  n){
        String res = " ";
        while(n != 0){
            if(n % 2 == 1)
                res += "1";
            else{
                res += "0";
            }
            n = n /2;
        }
        res = new StringBuilder(res).reverse().toString();
        return res;
    }
    public static void main(String[] args){
        int n = 2;
        String binary = decimalToBinary(n);
        System.out.println("Binary of " + n + " is: " + binary);
    }
}
