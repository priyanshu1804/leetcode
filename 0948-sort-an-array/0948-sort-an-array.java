class Solution {
    public void merge(int i,int mid,int j,int[] arr){
        ArrayList<Integer> ans=new ArrayList<>();
        int left=i;
        int right=mid+1;
        while(left<=mid&&right<=j){
            if(arr[left]<=arr[right]){
                ans.add(arr[left]);
                left++;
            }else{
                ans.add(arr[right]);
                right++;
            }
        }
        while(left<=mid){
            ans.add(arr[left]);
            left++;
        }
        while(right<=j){
            ans.add(arr[right]);
            right++;
        }
        for(int k=i;k<=j;k++){
            arr[k]=ans.get(k-i);
        }
    }
    public void solve(int i,int j,int[] arr){
        if(i>=j){
            return;
        }
        int mid=(i+j)/2;
        solve(i,mid,arr);
        solve(mid+1,j,arr);
        merge(i,mid,j,arr);
    }
    public int[] sortArray(int[] nums) {
        int i=0;
        int j=nums.length-1;
        solve(i,j,nums);
        return nums;
    }
}