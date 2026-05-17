package Tree;

public class SumRoot {
        public int sumNumbers(TreeNode root) {
            return dfs(root, 0);
        }

        private int dfs(TreeNode node, int current) {

            if (node == null) {
                return 0;
            }

            // Build current number
            current = current * 10 + node.val;

            // Leaf node
            if (node.left == null && node.right == null) {
                return current;
            }

            // Sum from left and right subtree
            return dfs(node.left, current) + dfs(node.right, current);

        }
    }

