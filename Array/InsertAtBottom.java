
import java.util.*;
public class InsertAtBottom {
    public static void insertAtBottom(Stack<Integer> stack, int val) {
        if (stack.empty()) {
            stack.push(val);
            return;
        }
        int value = stack.pop();
        insertAtBottom(stack, val);
        stack.push(value);
    }

    public static void reverseStack(Stack<Integer> stack) {
        if (stack.empty()) {
            return;
        }
        int val = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, val);
    }
}