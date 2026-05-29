package StackQueue;
import java.util.*;

public class Infix2PostfixConversion {
    public static int Precedence(char c){
        if(c == '^'){
            return 3;
        }
        else if(c == '/' || c == '*'){
            return 2;
        }
        else if(c == '+' || c == '-'){
            return 1;
        }else{
            return -1;
        }
    }

    public static String infixToPostfix(String s){
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                res.append(ch);
            }

            else if(ch == '('){
                st.push('(');
            }
            else if(ch == ')'){
                while(st.peek() != '('){
                    res.append(st.pop());
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && Precedence(ch) <= Precedence(st.peek())){
                    res.append(st.pop());
                }
                st.push(ch);
            }
        }
        while(!st.empty()){
            res.append(st.pop());
        }
        return res.toString();
    }
}

