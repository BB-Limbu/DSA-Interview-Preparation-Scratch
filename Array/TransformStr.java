class TransformStr {
    public boolean[] transformStr(String s, String[] strs) {
        int n = s.length();
        int[] zero = new int[n+1];
        for(int i = 0; i < n; i++){
            zero[i+1] = zero[i] + (s.charAt(i) == '0' ? 1 : 0);

        }
        int totalZero = zero[n];
        int m =strs.length;
        boolean[] ans = new boolean[m];

        for(int idx =0; idx < m; idx++){
            String q = strs[idx];
            int x = 0, qmark = 0;
            for(int i = 0; i < n; i++){
                char ch = q.charAt(i);
                if(ch == '0'){
                    x++;
                }
                else if(ch =='?'){
                    qmark++;
                }
            }
            int needed = totalZero - x;
            if(needed < 0 || needed > qmark){
                ans[idx] = false;
                continue;
            }
            boolean valid = true;
            int zeros = 0, assigned = 0;
            for(int i = 0; i < n; i++){
                char ch = q.charAt(i);
                boolean isZero;

                if(ch =='0'){
                    isZero = true;
                }
                else if(ch == '1'){
                    isZero =false;
                }
                else{
                    isZero =assigned < needed;
                    if(isZero){
                        assigned++;
                    }
                }
                if(isZero) zeros++;
                if(zeros < zero[i+1]){
                    valid = false;
                    break;
                }
            }
            ans[idx] = valid;

        }
        return ans;
    }
}