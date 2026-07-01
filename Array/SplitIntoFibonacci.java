

public class SplitIntoFibonacci {
    public static List<Integer> splitIntoFibonacci(String num){
        List<Integer> ans = new ArrayList<>();
        backtracking(num, 0, ans);
        return ans;
    }

    public static boolean backtracking(String s, int idx, List<Integer> ans){
        if(idx == s.length()){
            return ans.size() >= 3;
        }
        long curr = 0;
        for(int i =idx; i < s.length(); i++){
            if(i > idx && s.charAt(idx) == '0'){
                break;
            }
            curr = curr * 10 +s.charAt(i) - '0';

            if(curr > Integer.MAX_VALUE){
                break;
            }

            int size = ans.size();
            if(size >= 2){
                long sum = (long) ans.get(size -1) + ans.get(size-2);
                if(curr < sum){
                    continue;
                }
                else{
                    break;
                }
            }
            ans.add((int) curr);
            if(backtracking(s, i+1, ans)){
                return true;
            }
            ans.remove(ans.size()-1);
        }
        return false;
    }
}
