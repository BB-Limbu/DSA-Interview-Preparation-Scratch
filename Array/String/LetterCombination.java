

public class LetterCombination {
    private final String[] letters;
    public  LetterCombination(){
        letters = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    }
    // Recursive helper function to generate combinations
    private void helper(String digits, List<String> ans, int idx, String curr){
        if(idx == digits.length()){
            ans.add(curr);
            return;
        }
        // Get characters corresponding to the current digit
        String str = letters[digits.charAt(idx) - '0'];

        for(int i = 0; i < str.length(); i++){
            helper(digits,ans, idx+1, curr+str.charAt(i));
        }
    }
    public List<String> letterCombination(String digits){
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0){
            return ans;
        }
        helper(digits, ans,0, " ");
        return ans;
    }
}

