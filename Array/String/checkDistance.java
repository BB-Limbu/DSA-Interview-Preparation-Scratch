package String;

public class checkDistance {

        public boolean checkDistances(String s, int[] distance) {
            int[] firstIndex = new int[26];

            // initialize with -1
            for (int i = 0; i < 26; i++) {
                firstIndex[i] = -1;
            }

            for (int i = 0; i < s.length(); i++) {

                int ch = s.charAt(i) - 'a';

                // first occurrence
                if (firstIndex[ch] == -1) {
                    firstIndex[ch] = i;
                }

                // second occurrence
                else {

                    int gap = i - firstIndex[ch] - 1;

                    if (gap != distance[ch]) {
                        return false;
                    }
                }
            }

            return true;
        }
}

