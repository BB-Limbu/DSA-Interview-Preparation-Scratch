package String;

public class MaxStrPartition {
    public static int balancedPartition(String str){
        int n = str.length();
        int left = 0, right = 0;
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(str.charAt(i) == 'R'){
                right++;
            }
            else if(str.charAt(i) == 'L'){
                left++;
            }
            if(right == left){
                ans++;
            }
        }
        return ans;
    }
    /*
    Optimized version
    Time Complexity O(n)
    Space  Complexity O(n)
     */
    public static int balancePartition(String s){
        int bal = 0, ans = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'R'){
                bal++;
            }else{
                bal--;
            }

            if(bal == 0){
                ans++;
            }
        }
        return ans;
    }
}

