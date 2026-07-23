public class LongestZigZag {
    int ans = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root, true, 0);
        dfs(root, false, 0);
        return ans;
    }

    private void dfs(TreeNode node, boolean cameFromRight, int length) {
        if (node == null) return;

        ans = Math.max(ans, length);

        if (cameFromRight) {
            // Continue by going left
            dfs(node.left, false, length + 1);

            // Restart by going right
            dfs(node.right, true, 1);
        } else {
            // Continue by going right
            dfs(node.right, true, length + 1);

            // Restart by going left
            dfs(node.left, false, 1);
        }
    }
}