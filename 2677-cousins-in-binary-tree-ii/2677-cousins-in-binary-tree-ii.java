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
    HashMap<Integer,Integer> map=new HashMap<>();
    public void dfs(TreeNode root,int depth){
        if(root==null){
            return;
        }
        map.put(depth,map.getOrDefault(depth,0)+root.val);
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }
    public void dfs1(TreeNode root,int depth,int sibling){
        if(root==null){
            return;
        }
        root.val=map.get(depth)-sibling;
        sibling=(root.left==null?0:root.left.val)+(root.right==null?0:root.right.val);
        dfs1(root.left,depth+1,sibling);
        dfs1(root.right,depth+1,sibling);
    }
    public TreeNode replaceValueInTree(TreeNode root) {
        if(root==null){
            return null;
        }
        dfs(root,0);
        dfs1(root,0,root.val);
        return root;
    }
}