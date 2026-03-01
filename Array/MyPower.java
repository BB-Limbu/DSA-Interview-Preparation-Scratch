

public class MyPower {
    public static double myPower(double x, int n){
        if(n == 0){
            return 1;
        }
        long pow  = n;
        if(pow < 0){
            x = 1/ x;
            pow = -pow;
        }
        double res =  1;
        double  currentProduct = x;
        while(pow > 0){
            if(pow % 2 == 1){
                res = res * currentProduct;
            }
            currentProduct *= currentProduct;
            pow /= 2;
        }
        return res;
    }
}

