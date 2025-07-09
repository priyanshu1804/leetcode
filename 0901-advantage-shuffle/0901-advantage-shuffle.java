class Solution {
    private int solve(int[] nums,int target,int start,int end){
        int low=start;
        int high=end;
        while(low<high){
            int mid=(low+high)/2;
            if(nums[mid]<=target){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return low;
    }
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        int n=nums1.length;
        int[] ans=new int[n];
        Arrays.fill(ans,-1);
        List<int[]> temp=new ArrayList<>();
        for(int i=0;i<n;i++){
            temp.add(new int[]{nums2[i],i});
        }
        temp.sort((a,b)->Integer.compare(a[0],b[0]));
        Set<Integer> set=new HashSet<>();
        int last=0;
        for(int i=0;i<n;i++){
            int curr=temp.get(i)[0];
            int idx=solve(nums1,curr,last,n);
            if(idx<n){
                ans[temp.get(i)[1]]=nums1[idx];
                set.add(idx);
                last=idx+1;
            }
        }
        List<Integer> rem=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!set.contains(i)){
                rem.add(nums1[i]);
            }
        }
        int m=rem.size()-1;
        for(int i=0;i<n;i++){
            if(ans[i]==-1){
                ans[i]=rem.get(m--);
            }
        }
        return ans;
    }
}