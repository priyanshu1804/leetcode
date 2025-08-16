class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> ds=new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++){
                Node curr=q.remove();
                for(Node it:curr.children){
                    q.add(it);
                }
                ds.add(curr.val);
            }
            ans.add(ds);
        }
        return ans;
    }
}