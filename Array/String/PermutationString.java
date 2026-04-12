

public class PermutationString {

    public static boolean permutationString(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[] s1Count = new int[26];

        for(char ch : s1.toCharArray()){
            s1Count[ch - 'a']++;
        }

        for(int i = 0; i < m-n; i++){
            int[] s2Count = new int[26];

            for(int j = i; j < i + n; j++) {
                s2Count[s2.charAt(j) - 'a']++;
            }
            if(matchs(s1Count, s2Count)){
                return true;
            }
        }
        return false;
    }

    public static boolean matchs(int[] s1, int[] s2){
        for(int i = 0; i < 26; i++){
            if(s1[i] != s2[i]){
                return false;
            }
        }
        return true;
    }

    public static boolean permutationStr(String s1, String s2){
        if(s1.length() > s2.length()){
            return false;
        }
        int[] s1Count = new int[256];
        int[] s2Count = new int[256];

        for(char ch : s1.toCharArray()){
            s1Count[ch - 'a']++;
        }

        for(int i = 0; i < s2.length(); i++){
            s2Count[s2.charAt(i) - 'a']++;

            if(i >= s1.length()){
                s2Count[s2.charAt(i - s1.length()) - 'a']--;
            }

            if(match(s1Count, s2Count)){
                return true;
            }
        }
        return false;
    }

    private static boolean match(int[] a,int[]b){
        for(int i = 0; i < 26; i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }

}

