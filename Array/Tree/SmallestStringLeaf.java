package Tree;

public class SmallestStringLeaf {
        String smallest = null;
        public String smallestFromLeaf(TreeNode root) {
            dfs(root, "");
            return smallest;
        }

        private void dfs(TreeNode node, String path) {

            if (node == null) {
                return;
            }

            // Current character
            char ch = (char) ('a' + node.val);

            // Add at front (leaf -> root)
            String current = ch + path;

            // Leaf node
            if (node.left == null && node.right == null) {

                if (smallest == null || current.compareTo(smallest) < 0) {
                    smallest = current;
                }

                return;
            }

            dfs(node.left, current);
            dfs(node.right, current);
        }
    }

