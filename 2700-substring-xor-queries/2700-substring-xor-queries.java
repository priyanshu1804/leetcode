class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        Map<Integer,int[]> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                map.putIfAbsent(0,new int[]{i,i});
                continue;
            }
            int nums=0;
            for(int j=i;j<s.length()&&j<i+32;j++){
                nums*=2;
                nums+=(s.charAt(j)-'0');
                map.putIfAbsent(nums,new int[]{i,j});
            }
        }
        int[][] ans=new int[queries.length][2];
        int i=0;
        for(int[] it:queries){
            int val=it[0]^it[1];
            ans[i++]=map.getOrDefault(val,new int[]{-1,-1});
        }
        return ans;
    }
}