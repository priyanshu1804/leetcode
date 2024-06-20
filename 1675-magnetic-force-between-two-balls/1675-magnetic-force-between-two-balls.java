class Solution {
    public boolean helper(int mid,int[] position,int m){
        int prev=position[0];
        int count=1;
        for(int i=1;i<position.length&&count<m;i++){
            int curr=position[i];
            if(curr-prev>=mid){
                count++;
                prev=curr;
            }
        }
        return count==m;
    }
    public int maxDistance(int[] position, int m) {
        int ans=0;
        int n=position.length;
        Arrays.sort(position);
        int left=1;
        int right=(int)Math.ceil(position[n-1]/(m-1.0));
        while(left<=right){
            int mid=left+(right-left)/2;
            if(helper(mid,position,m)){
                ans=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return ans;
    }
}