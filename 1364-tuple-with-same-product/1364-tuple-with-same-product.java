class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int res=nums[i]*nums[j];
                map.put(res,map.getOrDefault(res,0)+1);
            }
        }
        int count=0;
        for(Map.Entry<Integer,Integer> it:map.entrySet()){
            int n=it.getValue();
            count+=n*(n-1)*4;
        }
        return count;
    }
}