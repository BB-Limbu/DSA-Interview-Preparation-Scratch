package String;

public class FindAnagramStr {
    /*
    Q.Find Anagram
    Brute Force
    Time Complexity O(n * k)
    Space Complexity O(n)
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int k = p.length();

        for (int i = 0; i <= n - k; i++) {

            int[] count = new int[26];

            // count chars of p
            for (int j = 0; j < k; j++) {
                count[p.charAt(j) - 'a']++;
            }

            // subtract chars of current window
            for (int j = 0; j < k; j++) {
                count[s.charAt(i + j) - 'a']--;
            }

            // check all zero
            boolean isAnagram = true;
            for (int c : count) {
                if (c != 0) {
                    isAnagram = false;
                    break;
                }
            }

            if (isAnagram) {
                ans.add(i);
            }
        }

        return ans;
    }
    public static List<Integer> findAnagram(String s, String p){
        ArrayList<Integer> res = new ArrayList<>();
        if(s.length() < p.length()){
            return  res;
        }
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        //Current frequency character of p
        for(char ch : p.toCharArray()){
            pCount[ch - 'a']++;
        }

        //Sliding window to count frequency character in s
        for(int i = 0; i < s.length(); i++){
            sCount[s.charAt(i) - 'a']++;

            //Remove character that is out of the window
            if(i >= p.length()){ // i = 3 psize = 3 -->
                sCount[s.charAt(i - p.length()) - 'a']--;
            }
            //compare counts
            if(Arrays.equals(pCount, sCount)){
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }

}

