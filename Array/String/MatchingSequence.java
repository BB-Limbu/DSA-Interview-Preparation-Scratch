package String;
import java.util.*;

public class MatchingSequence {
    public int numMatchingSequence(String s, String[] words) {
        HashMap<Character, List<Integer>> map = new HashMap<>();

        // Store indices of each character in s
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.putIfAbsent(ch, new ArrayList<>());
            map.get(ch).add(i);
        }

        int count = 0;

        for(String word : words){
            if(isSubsequence(word, map)){
                count++;
            }
        }

        return count;
    }

    private boolean isSubsequence(String word, HashMap<Character, List<Integer>> map){
        int prevIndex = -1;

        for(char ch : word.toCharArray()){
            if(!map.containsKey(ch)) return false;

            List<Integer> list = map.get(ch);

            int nextIndex = upperBound(list, prevIndex);

            if(nextIndex == -1) return false;

            prevIndex = nextIndex;
        }

        return true;
    }

    private int upperBound(List<Integer> list, int prevIndex) {
        int low = 0, high = list.size() - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) > prevIndex) {
                ans = list.get(mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
