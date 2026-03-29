package String;

import java.util.*;
public class isDuplicateParenthesis {
    /*
    optimal Approach
    Time Complexity O(n)
    Space Complexity O(n)
     */
    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            // closing
            if(ch == ')'){
                int count = 0;
                while(s.pop() != '('){
                    count++;
                }
                if(count < 1){
                    return true;
                }

            }else{
                s.push(ch);
            }
        }
        return false;
    }
}

