import java.util.*;

public class FizzBuzz {
    public static List<String> fizzBuzz(int n){
        List<String> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(i % 3 == 0 && i % 5 == 0){
                ans.add("FizzBuzz");
            }
            else if(i % 3 == 0){
                ans.add("Fizz");
            }
            else if(i % 5 == 0){
                ans.add("Buzz");
            }
            else{
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int n = 3;
        List<String> ans = fizzBuzz(n);
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }
    }
}
