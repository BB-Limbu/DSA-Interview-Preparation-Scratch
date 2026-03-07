package String;

public class PowerSet {
    /*
    Approach-1
    Time Complexity O(n*2^n)
    Space Complexity O(n*n^2)
     */
    public static  List<String>  powerSet(String str){
        int n = str.length();
        //total Sequence
        int total = 1 << n;
        List<String> subsequence = new ArrayList<>();
        // Iterate over all bit masks from 0 to 2^n - 1
        for(int bitMask  = 0; bitMask < total; bitMask++){
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < n; i++){
                if((bitMask & (1 << i)) != 0){
                    sb.append(str.charAt(i));
                }
            }
            subsequence.add(sb.toString());

        }
        return subsequence;
    }
    public static void table(int n){
        for(int i = 0; i < 10; i++){
            int val = i * 2;
            System.out.println(val);
        }
    }
    /*
    Approach 2
    Time Complexity O(n*2^n)
    Space Complexity O(n)
     */
    public static void helper(String str, int idx, StringBuilder sb, List<String> res){
        if(idx == str.length()){
            res.add(sb.toString());
            return;
        }
        helper(str, idx+1, sb, res);
        sb.append(str.charAt(idx));
        helper(str, idx+1, sb, res);
        sb.deleteCharAt(sb.length()-1);
    }
    public static List<String> getSubsequences(String str){
        //List top store all Subsequence
        List<String> result = new ArrayList<>();
        //StringBuilder to store current subsequence

        StringBuilder sb = new StringBuilder();
        helper(str, 0, sb, result);
        return result;

    }

}

