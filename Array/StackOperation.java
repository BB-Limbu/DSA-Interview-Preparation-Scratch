import java.util.*;

public class StackOperation{
    public List<String> StackOperation(int[] target, int n) {
        List<String> ops = new ArrayList<>();

        int ptr = 0; // pointer in target

        for (int i = 1; i <= n && ptr < target.length; i++) {

            // If current stream number matches target element
            if (i == target[ptr]) {
                ops.add("Push");
                ptr++; // move to next target element
            }
            else {
                // not part of target -> push & pop
                ops.add("Push");
                ops.add("Pop");
            }
        }
        return ops;
    }
}