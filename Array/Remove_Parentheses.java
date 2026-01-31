
public class Remove_Parentheses {
    public String removeOuterParentheses(String s){
         /*
    Better Approach
    Time Complexity O(n)
    Space Complexity O(1)
     */
        StringBuilder res = new StringBuilder();
        int level = 0;

        for(char ch : s.toCharArray()){

            if(ch == '('){
                if(level > 0){
                    res.append(ch);
                }
                level++;
            }
            else if(ch == ')'){
                level--;
                if(level > 0){
                    res.append(ch);
                }
            }

        }
        return res.toString();
    }
}
