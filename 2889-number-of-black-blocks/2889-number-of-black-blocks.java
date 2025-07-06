class Solution {
    public void solve(StringBuilder sb,int x,int y,HashMap<String,Integer> map){
        sb.setLength(0);
        sb.append(x).append(',').append(y);
        String key=sb.toString();
        map.put(key,map.getOrDefault(key,0)+1);
    }
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        HashMap<String,Integer> map=new HashMap<>();
        StringBuilder sb=new StringBuilder();
        for(int[] it:coordinates){
            int x=it[0];
            int y=it[1];
            if(x+1<m&&y+1<n){
                solve(sb,x,y,map);
            }
            if(x+1<m&&y-1>=0){
                solve(sb,x,y-1,map);
            }
            if(x-1>=0&&y+1<n){
                solve(sb,x-1,y,map);
            }
            if(x-1>=0&&y-1>=0){
                solve(sb,x-1,y-1,map);
            }
        }
        long[] ans=new long[5];
        for(int it:map.values()){
            ans[it]++;
        }
        ans[0]=(long)(m-1)*(n-1)-map.size();
        return ans;
    }
}