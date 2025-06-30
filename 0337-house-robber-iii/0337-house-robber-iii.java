class Solution {
    public int dfs(TreeNode root,Map<TreeNode,Integer> dp){
        if(root==null){
            return 0;
        }
        if(dp.containsKey(root)){
            return dp.get(root);
        }
        int rob=root.val;
        if(root.left!=null){
            rob+=dfs(root.left.left,dp);
            rob+=dfs(root.left.right,dp);
        }
        if(root.right!=null){
            rob+=dfs(root.right.left,dp);
            rob+=dfs(root.right.right,dp);
        }
        int notrob=dfs(root.left,dp)+dfs(root.right,dp);
        int ans=Math.max(rob,notrob);
        dp.put(root,ans);
        return ans;
    }
    public int rob(TreeNode root) {
        Map<TreeNode,Integer> dp=new HashMap<>();
        return dfs(root,dp);
    }
}