class Solution {
    public boolean solve(TreeNode root){
        if(root==null){
            return true;
        }
        if(root.left!=null&&root.left.val!=root.val) {
            return false;
        }
        if(root.right!=null&&root.right.val!=root.val){
            return false;
        }
        return solve(root.left)&&solve(root.right);
    }
    public boolean isUnivalTree(TreeNode root) {
        return solve(root);
    }
}