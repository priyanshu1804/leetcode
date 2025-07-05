class Solution {
    public int[] occurrencesOfElement(int[] nums,int[] queries,int x){
        List<Integer> occ=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==x){
                occ.add(i);
            }
        }
        int[] ans=new int[queries.length];
        for (int i=0;i<queries.length;i++){
            int q=queries[i];
            if(q>0&&q<=occ.size()){
                ans[i]=occ.get(q-1);
            }else{
                ans[i]=-1;
            }
        }
        return ans;
    }
}
