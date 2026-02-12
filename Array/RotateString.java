public class RotateString {
    /*
    Brute Force Approach
    Time Complexity O(n^2)
    Space Complexity O(n)
     */
    public boolean rotateString(String s, String goal){
        if(s.length() != goal.length()){
            return false;
        }
        for(int i = 0; i < s.length(); i++){
            String str = s.substring(i) + s.substring(0, i);
            if(str.equals(goal)){
                return true;
            }
        }
        return false;
    }
    /*
    Optimal Approach
    Time Complexity o(1)
    Space ComplexityO(1)

     */
    public boolean rotateString1(String s, String goal){
        if(s.length() != goal.length()){
            return false;
        }
        String doubles = s + s;
        return doubles.contains(goal);
    }
    public static void main(String[] args) {

        RotateString sol = new RotateString();

        String s1 = "rotation";
        String goal1 = "tionrota";
        System.out.println(sol.rotateString1(s1, goal1));
    }
}

