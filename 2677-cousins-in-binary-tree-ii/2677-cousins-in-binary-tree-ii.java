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
    public void solve(TreeNode root,int sum){
        if(root==null){
            return;
        }
        map.put(sum,map.getOrDefault(sum,0)+root.val);
        solve(root.left,sum+1);
        solve(root.right,sum+1);
    }
    public void solve1(TreeNode root,int sum,int sum1){
        if(root==null){
            return;
        }
        root.val=map.get(sum)-sum1;
        sum1=(root.left==null?0:root.left.val)+(root.right==null?0:root.right.val);
        solve1(root.left,sum+1,sum1);
        solve1(root.right,sum+1,sum1);
    }
    public TreeNode replaceValueInTree(TreeNode root) {
        if(root==null){
            return null;
        }
        solve(root,0);
        solve1(root,0,root.val);
        return root;
    }
}