public class DecodeWays {
    public int numDecoding(String s){
        if(s == null || s.length() == '0') return 0;

        int prev = 1;
        int prePrev = 1;

        for(int i = 1; i < s.length(); i++){
            int curr = 0;
            if(s.charAt(0) != '0'){
                prev = prePrev;
                prePrev = curr;
            }
            int value = Integer.parseInt(s.substring(i - 1, i + 1));
            if(value >= 10 && value < 26){
                prev = prePrev;
                prePrev = curr;
            }
        }
        return prev;
    }
}
