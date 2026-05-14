
    public class CountValidWords {
        public int[] countWordOccurrences(String[] chunks, String[] queries) {
            StringBuilder sb = new StringBuilder();
            for (String chunk : chunks) {
                sb.append(chunk);
            }

            String s = sb.toString();
            StringBuilder cleaned = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (Character.isLowerCase(c)) {
                    cleaned.append(c);
                }
                else if (c == '-') {
                    boolean joiner =
                            i > 0 &&
                                    i < s.length() - 1 &&
                                    Character.isLowerCase(s.charAt(i - 1)) &&
                                    Character.isLowerCase(s.charAt(i + 1));

                    if (joiner) {
                        cleaned.append('-');
                    } else {
                        cleaned.append(' ');
                    }
                }
                else {
                    cleaned.append(' ');
                }
            }
            Map<String, Integer> freq = new HashMap<>();

            for (String word : cleaned.toString().split("\\s+")) {
                if (!word.isEmpty()) {
                    freq.put(word, freq.getOrDefault(word, 0) + 1);
                }
            }
            int[] ans = new int[queries.length];

            for (int i = 0; i < queries.length; i++) {
                ans[i] = freq.getOrDefault(queries[i], 0);
            }

            return ans;
        }
    }
