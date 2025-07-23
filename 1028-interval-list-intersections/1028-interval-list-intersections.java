class pair{
    int first;
    int second;
    public pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<pair> adj=new ArrayList<>();
        int i=0;
        int j=0;
        int n=firstList.length;
        int m=secondList.length;
        while(i<n&&j<m){
            int start=Math.max(firstList[i][0],secondList[j][0]);
            int end=Math.min(firstList[i][1],secondList[j][1]);
            if(start<=end){
                adj.add(new pair(start,end));
            }
            if(firstList[i][1]<secondList[j][1]){
                i++;
            }else{
                j++;
            }
        }
        int[][] ans=new int[adj.size()][2];
        for(i=0;i<adj.size();i++){
            ans[i][0]=adj.get(i).first;
            ans[i][1]=adj.get(i).second;
        }
        return ans;
    }
}