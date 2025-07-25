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
    public List<TreeNode> solve(int start,int end){
        List<TreeNode> ans=new ArrayList<>();
        if(start>end){
            ans.add(null);
            return ans;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> left=solve(start,i-1);
            List<TreeNode> right=solve(i+1,end);
            for(TreeNode l:left){
                for (TreeNode r:right){
                    TreeNode current=new TreeNode(i);
                    current.left=l;
                    current.right=r;
                    ans.add(current);
                }
            }
        }
        return ans;
    }
    public List<TreeNode> generateTrees(int n) {
        return n>0?solve(1,n):new ArrayList<>();
    }
}