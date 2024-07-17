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
    public TreeNode solve(TreeNode root,HashSet<Integer> set,List<TreeNode> ans){
        if(root==null){
            return null;
        }
        root.left=solve(root.left,set,ans);
        root.right=solve(root.right,set,ans);
        if(set.contains(root.val)){
            if(root.left!=null){
                ans.add(root.left);
            }
            if(root.right!=null){
                ans.add(root.right);
            }
            return null;
        }
        else{
            return root;
        }
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        for(int it:to_delete){
            set.add(it);
        }
        solve(root,set,ans);
        if(!set.contains(root.val)){
            ans.add(root);
        }
        return ans;
    }
}