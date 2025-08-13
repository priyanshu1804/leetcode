class Solution {
    int mod=1000000007;
    public int countPairs(int[] arr){
        Map<Integer,Integer> map=new HashMap<>();
        int n=arr.length;
        long ans=0;
        for(int it:arr){
            int count=1;
            for(int i=0;i<22;i++){
                if(map.containsKey(count-it)){
                    ans+=map.get(count-it);
                    ans%=mod;
                }
                count*=2;
            }
            map.put(it,map.getOrDefault(it,0)+1);
        }
        return (int)ans;
    }
}