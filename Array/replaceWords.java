
public class ReplaceWords{
public static String replace_Words(List<String> dictionary, String sentence) {
    Set<String> set = new HashSet<>(dictionary);
    String[] words = sentence.split(" ");
    StringBuilder sb = new StringBuilder();

    for (String word : words) {
        String prefix = "";
        for (int i = 1; i <= word.length(); i++) {
            prefix = word.substring(0, i);
            if (set.contains(prefix))
                break;
        }
        sb.append(set.contains(prefix) ? prefix : word).append(" ");
    }
    return sb.toString().trim();
  }
}
