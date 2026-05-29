package String;

public class ReverseStringPrefix {
    public static String reverseStrPrefix(String s, int k){
        if(k > s.length()){
            return "Invalid";
        }
        String firstHalf = s.substring(0, k);
        String lastHalf = s.substring(k);

        String reverse = new StringBuilder(firstHalf).reverse().toString();
        return reverse + lastHalf;
    }
}

