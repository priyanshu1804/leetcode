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
    public TreeNode ancestor(TreeNode root,int p,int q){
        if(root==null){
            return null;
        }
        if(root.val==p||root.val==q){
            return root;
        }
        TreeNode lca=ancestor(root.left,p,q);
        TreeNode rca=ancestor(root.right,p,q);
        if(lca!=null&&rca!=null){
            return root;
        }
        else if(lca!=null){
            return lca;
        }else{
            return rca;
        }
    }
    public boolean solve(TreeNode root,int target,ArrayList<Character> ans){
        if(root==null){
            return false;
        }
        if(root.val==target){
            return true;
        }
        ans.add('L');
        if(solve(root.left,target,ans)){
            return true;
        }
        ans.remove(ans.size()-1);
        ans.add('R');
        if(solve(root.right,target,ans)){
            return true;
        }
        ans.remove(ans.size()-1);
        return false;
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode node=ancestor(root,startValue,destValue);
        ArrayList<Character> start=new ArrayList<>();
        ArrayList<Character> end=new ArrayList<>();
        solve(node,startValue,start);
        solve(node,destValue,end);
        String str="";
        for(int i=0;i<start.size();i++){
            str+='U';
        }
        for(int i=0;i<end.size();i++){
            str+=end.get(i);
        }
        return str;
    }
}