public class SortVowelFreq {
    public String sortVowels(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> firstPos = new HashMap<>();
        List<Integer> vowelPositions = new ArrayList<>();


        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                vowelPositions.add(i);
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
                firstPos.putIfAbsent(ch, i);
            }
        }


        List<Character> vowels = new ArrayList<>(freq.keySet());
        vowels.sort((a, b) -> {
            if (!freq.get(a).equals(freq.get(b))) {
                return freq.get(b) - freq.get(a); // descending frequency
            }
            return firstPos.get(a) - firstPos.get(b); // earlier occurrence first
        });


        List<Character> sortedVowels = new ArrayList<>();
        for (char v : vowels) {
            for (int i = 0; i < freq.get(v); i++) {
                sortedVowels.add(v);
            }
        }


        char[] chars = s.toCharArray();
        for (int i = 0; i < vowelPositions.size(); i++) {
            chars[vowelPositions.get(i)] = sortedVowels.get(i);
        }

        return new String(chars);
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
