class FindSumPairs {
    int[] n1;
    int[] n2;
    Map<Integer,Integer> map=new HashMap<>();
    public FindSumPairs(int[] nums1,int[] nums2){
        n1=nums1;
        n2=nums2;
        for(int x:n2){
            map.put(x,map.getOrDefault(x,0)+1);
        }
    }
    public void add(int i,int v){
        map.put(n2[i],map.get(n2[i])-1);
        n2[i]+=v;
        map.put(n2[i],map.getOrDefault(n2[i],0)+1);
    }
    public int count(int t){
        int c=0;
        for(int x:n1){
            c+=map.getOrDefault(t-x,0);
        }
        return c;
    }
}