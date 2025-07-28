class Solution {
    int max=Integer.MIN_VALUE;
    public void solve(int[][] requests,int[] indegree,int idx,int n,int count){
        if(idx==requests.length){
            for(int it:indegree){
                if(it!=0){
                    return;
                }
            }
            max=Math.max(max,count);
            return;
        }
        int from=requests[idx][0];
        int to=requests[idx][1];
        indegree[from]--;
        indegree[to]++;
        solve(requests,indegree,idx+1,n,count+1);
        indegree[from]++;
        indegree[to]--;
        solve(requests,indegree,idx+1,n,count);
    }
    public int maximumRequests(int n, int[][] requests) {
        int[] indegree=new int[n];
        int count=0;
        solve(requests,indegree,0,n,0);
        return max;
    }
}