class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] vis=new boolean[1000001];
        Arrays.fill(vis,true);
        vis[0]=false;
        vis[1]=false;
        for(int i=2;i*i<1000001;i++){
            if(vis[i]){
                for(int j=i*i;j<1000001;j+=i){
                    vis[j]=false;
                }
            }
        }
        int diff=Integer.MAX_VALUE;
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(vis[i]){
                ans.add(i);
            }
        }
        int i=-1;
        int j=-1;
        for(int k=1;k<ans.size();k++){
            if(ans.get(k)-ans.get(k-1)<diff){
                i=ans.get(k-1);
                j=ans.get(k);
                diff=ans.get(k)-ans.get(k-1);
            }
        }
        return new int[]{i,j};
    }
}
