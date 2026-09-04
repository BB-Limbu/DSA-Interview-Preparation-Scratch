
    public class AlienDictionary {
        public static String alienOrder(String[] words){

            Map<Character, List<Character>> graph = new HashMap<>();

            for(String word : words){
                for(char ch  : word.toCharArray()){
                    graph.putIfAbsent(ch,  new ArrayList<>());
                }
            }

            //Build Graph
            for(int i = 0; i < words.length-1; i++){
                String word1 = words[i];
                String word2 = words[i+1];

                int minLen = Math.min(word1.length(), word2.length());
                boolean foundDiff = false;

                for(int j = 0; j < minLen; j++) {
                    char ch1 = word1.charAt(j);
                    char ch2 = word2.charAt(j);

                    if (ch1 != ch2) {
                        graph.get(ch1).add(ch2);
                        foundDiff = true;
                        break;
                    }
                }

                if(!foundDiff && word1.length() > word2.length()){
                    return "";
                }
            }

            // 0 = unvisited
            // 1 = currently visiting
            // 2 = completely visited
            Map<Character, Integer> map = new HashMap<>();
            for(char ch : graph.keySet()){
                map.put(ch, 0);
            }

            StringBuilder sb = new StringBuilder();
            for(char ch : graph.keySet()){
                if(map.get(ch) == 0){
                    if(!dfs(ch, graph,map, sb)){
                        return "";
                    }
                }
            }

            return sb.reverse().toString();
        }

        public static boolean dfs(char node, Map<Character, List<Character>>
                graph, Map<Character, Integer> map, StringBuilder sb){
            map.put(node, 1);
            for(char nbr : graph.get(node)){
                if(map.get(nbr) == 1){
                    return false;
                }

                if(map.get(nbr) == 0){
                    if(!dfs(nbr, graph,map,sb)){
                        return false;
                    }
                }
            }

            map.put(node, 2);
            sb.append(node);
            return true;
        }

        public static void main(String[] args){
            String[] words = {
                    "baa",
                    "abcd",
                    "abca",
                    "cab",
                    "cad"
            };

            System.out.println(alienOrder(words));
        }
    }

