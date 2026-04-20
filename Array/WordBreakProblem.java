

public class WordBreakProblem {
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;

        public Node(){
            for(int i = 0; i < children.length; i++){
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void inserts(String words){ // TC --> O(L)
        Node curr = root;
        for(int level = 0; level < words.length(); level++){
            int idx = words.charAt(level) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    public static boolean searchs(String word){ //TC --> O(L)
        Node temp = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(temp.children[idx] == null){
                return false;
            }
            temp = temp.children[idx];
        }
        return temp.eow == true;
    }
    public static boolean wordBreak(String words){ //TC --> O(L)
        if(words.length() == 0){
            return true;
        }
        for(int i = 1; i <= words.length(); i++){
            if(searchs(words.substring(0, i)) &&
                    wordBreak(words.substring(i))){
                return true;
            }
        }
        return false;
    }

}

