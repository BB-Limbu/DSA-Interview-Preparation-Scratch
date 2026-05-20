package String;

public class RansomNote {
    public static boolean canConstruct(String str1, String str2){
        int[] count = new int[26];

        for(char ch : str2.toCharArray()){
            count[ch - 'a']++;
        }
        for(char ch : str1.toCharArray()){
            if(count[ch - 'a'] == 0){
                return false;
            }
            count[ch - 'a']--;
        }
        return true;
    }
}
