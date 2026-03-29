package String;
import java.util.*;
public class AddOperator {
    public  List<String> addOperator(String num, int target){
        List<String> res = new ArrayList<>();
        dfs(num, target,0,0,0, " ", res);
        return res;
    }
    private static void  dfs(String num, int target, int start, long curr_value,long last_operand, String expression, List<String> res){
        if(start == num.length()){
            if(curr_value == target){
                res.add(expression);
            }
            return;
        }
        for(int i = start; i < num.length(); i++){
            //Skip leading zero in numbers
            if(i > start && num.charAt(start) == '0'){
                return;
            }
            String curr_num = num.substring(start, i+1);
            long curr_num_val = Long.parseLong(curr_num);

            if(start == 0){
                dfs(num, target, i+1,curr_num_val, curr_num_val, curr_num,res);
            }else{
                dfs(num, target, i+ 1, curr_value + curr_num_val, curr_num_val, expression + "+" + curr_num, res);
                dfs(num, target, i+1, curr_value - curr_num_val, -curr_num_val, expression + "-"+curr_num, res);
                dfs(num, target, i+1, curr_value-last_operand +last_operand*curr_num_val,last_operand * curr_num_val, expression+ "*" + curr_num, res);
            }

        }

    }
}

