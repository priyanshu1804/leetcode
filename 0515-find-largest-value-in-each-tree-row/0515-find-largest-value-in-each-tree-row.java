class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int length=q.size();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<length;i++){
                TreeNode node=q.remove();
                max=Math.max(max,node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            ans.add(max);
        }
        return ans;
    }
}