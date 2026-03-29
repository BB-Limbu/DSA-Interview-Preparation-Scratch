import java.util.*;


public class CheckAnagrams {
    public static boolean Check_Anagrams(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        for(int i = 0; i < str1.length(); i++){
            if(charArray2[i] != charArray2[i]){
                return false;
            }
        }
        return true;
    }

    /*
    Optimal solution
    Time Complexity O(n)
    Space Complexity O(1)
     */

    public static boolean checkAnagram(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }

        int[] freq = new int[26];

        for(int i = 0; i < str1.length(); i++){
            freq[str1.charAt(i) - 'A']++;
        }
        for(int i = 0; i < str2.length(); i++){
            freq[str2.charAt(i) - 'A']--;
        }

        for(int i = 0; i < 26; i++){
            if(freq[i] != 0){
                return  false;
            }
        }
        return true;
    }
}

