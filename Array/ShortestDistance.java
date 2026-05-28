public class ShortestDistance {
    public static int[] shortDist(String s, char c){
        int n = s.length();
        int[] ans = new int[n];
        int prev = -n;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == c){
               prev = i;
            }
            ans[i] = i - prev;
        }

         prev = 2 * n;

        for(int i = n-1; i >= 0; i--){
            if(s.charAt(i) == c){
                prev = i;
            }
            ans[i] = Math.max(ans[i], i-prev);
        }
        return ans;
    }
}
