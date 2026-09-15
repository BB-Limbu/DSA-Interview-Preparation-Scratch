

public class LongestStringChain {
    public static int longestStrChain(String[] words){
        //Time Complexity O(N log N) + O(N × L²) ----->O(N log N + N × L²)
        //Space Complexity O(N + L)



        //Sort word by length
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> map = new HashMap<>();
        int ans = 1;

        for(String word : words){
            // Every word itself forms a chain of length 1
            map.put(word, 1);
            //Try Removing each word
            for(int i = 0; i < word.length(); i++){
                String prev = word.substring(0,i) + word.substring(i + 1);

                if(map.containsKey(prev)){
                    map.put(word, Math.max(map.get(word), map.get(prev)  + 1));
                }
            }
            ans = Math.max(ans, map.get(word));
        }
        return ans;
    }

}

