class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance=new int[n][n];
        int length=edges.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                distance[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<length;i++){
            int citya=edges[i][0];
            int cityb=edges[i][1];
            int weight=edges[i][2];
            distance[citya][cityb]=weight;
            distance[cityb][citya]=weight;
        }
        for(int i=0;i<n;i++){
            distance[i][i]=0;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(distance[j][i]==Integer.MAX_VALUE||distance[i][k]==Integer.MAX_VALUE){
                        continue;
                    }
                    distance[j][k]=Math.min(distance[j][k],distance[j][i]+distance[i][k]);
                }
            }
        }
        int min=n;
        int mincity=-1;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(distance[i][j]<=distanceThreshold){
                    count++;
                }
            }
            if(count<=min){
                min=count;
                mincity=i;
            }
        }
        return mincity;
    }
}