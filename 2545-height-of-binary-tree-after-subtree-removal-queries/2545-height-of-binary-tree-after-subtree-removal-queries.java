/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int[] max=new int[100001];
    int current=0;
    public void dfs1(TreeNode root,int height){
        if(root==null){
            return;
        }
        max[root.val]=Math.max(max[root.val],current);
        current=Math.max(height,current);
        dfs1(root.right,height+1);
        dfs1(root.left,height+1);
    }
    public void dfs(TreeNode root,int height){
        if(root==null){
            return;
        }
        max[root.val]=current;
        current=Math.max(height,current);
        dfs(root.left,height+1);
        dfs(root.right,height+1);
    }
    public int[] treeQueries(TreeNode root, int[] queries) {
        dfs(root,0);
        current=0;
        dfs1(root,0);
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            ans[i]=max[queries[i]];
        }
        return ans;
    }
}