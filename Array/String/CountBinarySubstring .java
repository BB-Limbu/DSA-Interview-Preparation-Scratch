im

class CountBinarySubstring {
    public static  int countBinarySubStr(String s){
        int res = 0, prev = 0, count = 1;

        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                count++;
            }
            else{
                prev = count;
                count = 1;
            }
            if(count <= prev){
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args){
        String s = "00110011";
        System.out.println(countBinarySubStr(s));
    }
}

