class Solution {
    public static int countDistinctIntegers(int[] nums) {
    	int n=nums.length;
    	HashSet<Integer> set=new HashSet<Integer>();
    	for(int i=0;i<n;i++){
    		set.add(nums[i]);
        	StringBuilder sb=new StringBuilder();
    		sb.append(String.valueOf(nums[i]));
    		sb.reverse();
            int num=Integer.parseInt(sb.toString());
    		set.add(num);
		}
    	return set.size();
    }
}