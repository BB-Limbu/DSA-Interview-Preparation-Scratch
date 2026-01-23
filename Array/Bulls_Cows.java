public class Bulls_Cows {
    /*
    Time Complexity O(n)
    Space Complexity O(1)
     */
    public String bullsCows(String secret, String guess){
        int bulls = 0, cows = 0;
        int[] count = new int[10];
        for(int i = 0; i < secret.length(); i++){
            char c = secret.charAt(i);
            char c1 = guess.charAt(i);

            if(c == c1){
                bulls++;
            }

            else{
                int sd = c - '0';
                int sg = c1 - '0';

                if(count[sd] < 0) cows++;
                if(count [sg] > 0) cows++;

                count[sd]++;
                count[sg]--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
