class Solution {
    public long solve(ArrayList<Integer> pre,ArrayList<Integer> suff){
        int n1=pre.size();
        int n2=suff.size();
        long result=0;
        int i=0;
        int j=0;
        while(i<n1&&j<n2){
            if(pre.get(i)<suff.get(j)){
                result+=(n2-j);
                i++;
            }else{
                j++;
            }
        }
        return result;
    }
    public long incremovableSubarrayCount(int[] nums) {
        int n=nums.length;
        if(n==1){
            return 1;
        }
        int i=0;
        int j=n-1;
        ArrayList<Integer> pre=new ArrayList<>();
        ArrayList<Integer> suff=new ArrayList<>();
        while(i+1<n&&nums[i]<nums[i+1]){
            pre.add(nums[i]);
            i++;
        }
        pre.add(nums[i]);
        while(j-1>=0&&nums[j]>nums[j-1]){
            suff.add(nums[j]);
            j--;
        }
        suff.add(nums[j]);
        Collections.reverse(suff);
        if(j<i){
            return (1L*n*(n+1)*1L)/2L;
        }
        long ans=0;
        ans+=pre.size();
        ans+=suff.size();
        ans+=solve(pre,suff);
        ans++;
        return ans;
    }
}