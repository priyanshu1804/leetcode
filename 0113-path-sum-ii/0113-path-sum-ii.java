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
    public void dfs(TreeNode root,int target,int sum,List<List<Integer>> ans,List<Integer> ds){
        if(root==null){
            return;
        }
        sum+=root.val;
        ds.add(root.val);
        if(root.left==null&&root.right==null&&sum==target){
            ans.add(new ArrayList<>(ds));
        }
        dfs(root.left,target,sum,ans,ds);
        dfs(root.right,target,sum,ans,ds);
        ds.remove(ds.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        dfs(root,targetSum,0,ans,new ArrayList<>());
        return ans;
    }
}