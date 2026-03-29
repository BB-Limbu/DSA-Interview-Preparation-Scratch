
package String;
import java.util.*;
public class CharacterByFrequency {
    public static String frequencySorting(String s){
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char ch : s.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        List<Character>[] bucket = new List[s.length() - 1];

        for(char ch : freqMap.keySet()){
            int freq = freqMap.get(ch);

            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(ch);
        }
        StringBuilder res = new StringBuilder();
        for(int i = bucket.length -1; i >= 0; i--){
            if(bucket[i] != null){
                for(char ch : bucket[i]){
                    for(int j = 0; j < i; j++){
                        res.append(ch);
                    }
                }
            }
        }
        return res.toString();
    }
    public static void main(String[] args){

    }
}
