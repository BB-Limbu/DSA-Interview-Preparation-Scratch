class CountDominantNodes {
    int count = 0;
    public int countDominantNodes(TreeNode root) {
        dfs(root);
        return count;
    }
    private int dfs(TreeNode node){
        if(node == null){
            return Integer.MIN_VALUE;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        int max = Math.max(node.val, Math.max(left,right));

        if(max == node.val){
            count++;
        }
        return max;
    }
}