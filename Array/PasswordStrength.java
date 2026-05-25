public class PasswordStrength {
    public static int passwordStrength(String password){
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        boolean[] digits = new boolean[10];
        boolean[] specialChar = new boolean[4];

        int sum = 0;

        for(char ch : password.toCharArray()){
            if(ch >= 'a' && ch <= 'z'){
                int idx = ch-'a';

                if(!lower[idx]){
                    lower[idx] = true;
                    sum++;
                }
            }

            else if(ch >= 'A' && ch <= 'Z'){
                int idx = ch - 'A';

                if(!upper[idx]){
                    upper[idx] = true;
                    sum += 2;
                }
            }
            else if(ch >= 0 && ch <= 9){
                int idx = ch - '0';

                if(!digits[idx])
                    digits[idx] = true;
                sum  += 3;
            }
            else{
                int idx = -1;
                if (ch == '!') idx = 0;
                else if (ch == '@') idx = 1;
                else if (ch == '#') idx = 2;
                else if (ch == '$') idx = 3;

                if (idx != -1 && !specialChar[idx]) {
                    specialChar[idx] = true;
                    sum += 5;
                }

            }
        }
        return sum;
    }
}
