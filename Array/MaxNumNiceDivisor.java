public class MaxNumNiceDivisor{

        long MOD = 1_000_000_007;
        public int maxNiceDivisors(int primeFactors) {
            if (primeFactors <= 3)
                return primeFactors;
            if (primeFactors % 3 == 0) {
                return (int) power(3, primeFactors / 3);
            }
            else if (primeFactors % 3 == 1) {
                return (int) ((power(3, (primeFactors / 3) - 1) * 4) % MOD);
            }
            else {
                return (int) ((power(3, primeFactors / 3) * 2) % MOD);
            }
        }
        private long power(long base, long exp) {

            long result = 1;

            while (exp > 0) {
                if ((exp & 1) == 1) {
                    result = (result * base) % MOD;
                }

                base = (base * base) % MOD;

                exp /= 2;
            }

            return result;
        }
}
