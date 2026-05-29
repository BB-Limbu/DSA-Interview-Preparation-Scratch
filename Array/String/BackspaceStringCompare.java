
public class BackspaceStringCompare {
    public static boolean compare(String s, String t){
        return helper(s).equals(helper(t));
    }

    private static String helper(String str){

        Stack<Character> st = new Stack<>();

        for(char ch : str.toCharArray()){
            if(ch == '#'){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else{
                st.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : st){
            sb.append(ch);
        }
        return sb.toString();
    }
}
