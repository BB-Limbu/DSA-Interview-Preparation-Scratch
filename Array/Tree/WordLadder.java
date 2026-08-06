

public class WordLadder {
        public static List<List<String>> ladderLength(String beginWord, String endWord, List<String> wordsList){

            List<List<String>> ans = new ArrayList<>();
            Map<String, Set<String>> reverse = new HashMap<>();
            Set<String> wordSet = new HashSet<>(wordsList);
            wordSet.remove(beginWord);
            Queue<String> q = new LinkedList<>();
            q.offer(beginWord);
            Set<String> nextLevel = new HashSet<>();
            boolean findEnd = false;

            while(!q.isEmpty()){
                String word = q.poll();
                for(String next : wordSet){
                    if(isLadder(word, next)){
                        Set<String> reverseLadder = reverse.computeIfAbsent(next, k -> new HashSet<>());
                        reverseLadder.add(word);
                        if(endWord.equals(next)){
                            findEnd = true;
                        }
                        nextLevel.add(next);
                    }
                }

                if(q.isEmpty()){
                    if(findEnd){
                        break;
                    }
                    q.addAll(nextLevel);
                    wordSet.removeAll(nextLevel);
                    nextLevel.clear();
                }
            }

            if(!findEnd){
                return ans;
            }
            Set<String> path = new LinkedHashSet<>();
            path.add(endWord);
            findPath(endWord, beginWord, reverse, ans, path);
            return ans;
        }

        public static void findPath(String endWord, String beginWord, Map<String,
                Set<String>> graph, List<List<String>> ans, Set<String> path){
            Set<String>  next = graph.get(endWord);
            if(next == null){
                return;
            }

            for(String word : next){
                path.add(word);
                if(beginWord.equals(word)){
                    List<String> shortestPath = new ArrayList<>(path);
                    Collections.reverse(shortestPath);
                    ans.add(shortestPath);

                }
                else{
                    findPath(word, beginWord, graph,ans,path);
                }
                path.remove(word);
            }
        }

        public static boolean isLadder(String s, String t){
            if(s.length() != t.length()){
                return false;
            }
            int diffCount = 0;
            int n = s.length();
            for(int i = 0; i < n; i++){
                if(s.charAt(i) != t.charAt(i)){
                    diffCount++;
                }
                if(diffCount > 1){
                    return false;
                }
            }
            return diffCount == 1;
        }
        public static void main(String[] args){
            String  beginWord = "hit", endWord = "cog";
            List<String> wordList = Arrays.asList(
                    "hot", "dot", "dog", "lot", "log", "cog"
            );

            List<List<String>> ans = ladderLength(beginWord,endWord,wordList);
            for(int i = 0; i < ans.size(); i++){
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
        }

}
