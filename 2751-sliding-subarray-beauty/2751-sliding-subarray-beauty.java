class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n=nums.length;
        int[] ans=new int[n-k+1];
        int l=0;
        Map<Integer,Integer> map=new TreeMap<>();
        int i=0;
        int j=0;
        while(j<n){
            if(nums[j]<0){
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            }
            if(j-i+1>k){
                if(nums[i]<0){
                    map.put(nums[i],map.getOrDefault(nums[i],0)-1);
                    if(map.get(nums[i])==0){
                        map.remove(nums[i]);
                    }
                }
                i++;
            }
            if(j-i+1==k){
                int count=0;
                boolean flag=false;
                for(Map.Entry<Integer,Integer> it:map.entrySet()){
                    count+=it.getValue();
                    if(count>=x){
                        ans[l++]=it.getKey();
                        flag=true;
                        break;
                    }
                }
                if(!flag){
                    ans[l++]=0;
                }
            }
            j++;
        }
        return ans;
    }
}