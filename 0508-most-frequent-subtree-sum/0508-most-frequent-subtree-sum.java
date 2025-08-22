class Solution {
    int max=0;
    public int solve(TreeNode root,HashMap<Integer,Integer> map){
        if(root==null){
            return 0;
        }
        int sum=root.val+solve(root.left,map)+solve(root.right,map);
        map.put(sum,map.getOrDefault(sum,0)+1);
        max=Math.max(max,map.getOrDefault(sum,0));
        return sum;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer,Integer> map=new HashMap<>();
        solve(root,map);
        List<Integer> ans=new ArrayList<>();
        for(int it:map.keySet()){
            if(map.getOrDefault(it,0)==max){
                ans.add(it);
            }
        }
        int[] ans1=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            ans1[i]=ans.get(i);
        }
        return ans1;
    }
}