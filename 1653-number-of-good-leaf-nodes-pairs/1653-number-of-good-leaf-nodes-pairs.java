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
    int count=0;
    public List<Integer> solve(TreeNode root,int d){
        if(root==null){
            return new ArrayList<>(0);
        }
        if(root.left==null&&root.right==null){
            List<Integer> leaf=new ArrayList<>(1);
            leaf.add(1);
            return leaf;
        }
        List<Integer> l=solve(root.left,d);
        List<Integer> r=solve(root.right,d);
        for(int a:l){
            for(int b:r){
                if((a+b)<=d){
                    count++;
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int a:l){
            if(a+1<d){
                ans.add(a+1);
            }
        }
        for(int b:r){
            if(b+1<d){
                ans.add(b+1);
            }
        }
        return ans;
    }
    public int countPairs(TreeNode root, int distance) {
        solve(root,distance);
        return count;
    }
}