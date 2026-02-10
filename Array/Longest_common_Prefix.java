

public class Longest_common_Prefix {
    public static String longestCommonPrefix(String[]  str){
        StringBuilder word = new StringBuilder();

        Arrays.sort(str);

        String first = str[0];
        String last = str[str.length -1];

        for(int i = 0; i < Math.max(first.length(), last.length()); i++){
            if(first.charAt(i) != last.charAt(i)){
                return word.toString();
            }
            word.append(first.charAt(i));
        }
        return word.toString();
    }
}
