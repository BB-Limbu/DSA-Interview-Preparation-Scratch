

public class KmostDistinct {

    public static int atMostKDistinct(String s, int k){
        int left = 0, res = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);

            while(freqMap.size() > k){
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                if(freqMap.get(leftChar) == 0){
                    freqMap.remove(leftChar);
                }
                left++;
            }
            res += (right - left + 1);
        }
        return res;

    }
    public static int countSubstrings(String s, int k) {
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }
}
