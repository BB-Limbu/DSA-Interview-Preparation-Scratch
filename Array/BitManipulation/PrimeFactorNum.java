public class PrimeFactorNum {
    /*
    Q. Print prime factor of a number
    Time complexity O(n + n sqrt n)
    Space Complexity O(n)
     */
    public static List<Integer> primeFactor(int n){
        List<Integer> list = new ArrayList<>();

        for(int i = 2; i <= n; i++){
            if(n % i == 0 && isPrime(i)){
                list.add(i);
            }
        }
        return list;
    }
    public static boolean isPrime(int n){
        if(n <= 1) return false;

        for(int i = 2; i * i <= n; i++){
            if(n % i == 0 ){
                return false;
            }
        }
        return true;
    }
    /*
    Better Approach
    Time Complexity O(n + sqrt n)
    Space Complexity O(n)
     */
    public static List<Integer> primeFactors(int n){
        List<Integer> list1 = new ArrayList<>();
        for(int i = 1; i < Math.sqrt(n); i++){
            if(n % i == 0){
                if (isPrime(i)){
                    list1.add(i);
                }
                if(n /i == i){
                    if(isPrime(n/i)){
                        list1.add(n/i);
                    }
                }
            }
        }
        return list1;
    }

    public static  List<Integer> primeFac(int n){
        List<Integer> res = new ArrayList<>();

        for(int i = 2; i < Math.sqrt(n); i++){
            if(n % i == 0){
                res.add(i);
            }
            while(n % i  == 0){
                n = n / i;

            }
        }
        if(n != 1){
            res.add(n);
        }
        return res;
    }

}
