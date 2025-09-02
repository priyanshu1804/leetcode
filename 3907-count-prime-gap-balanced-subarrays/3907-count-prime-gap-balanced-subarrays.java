class Solution {
    public static boolean solve(int n){
        if(n<=1){
            return false;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public int primeSubarray(int[] nums, int k) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Deque<Integer> prime=new ArrayDeque<>();
        int n=nums.length;
        int ans=0;
        int i=0;
        int j=0;
        while(j<n){
            if(solve(nums[j])){
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
                prime.add(j);
            }
            while(map.size()>0&&map.lastKey()-map.firstKey()>k){
                if(solve(nums[i])){
                    int freq=map.get(nums[i]);
                    freq--;
                    if(freq==0){
                        map.remove(nums[i]);
                    }else{
                        map.put(nums[i],freq);
                    }
                    prime.poll();
                }
                i++;
            }
            if(prime.size()>=2){
                int first=prime.pollLast();
                int second=prime.peekLast();
                ans+=second-i+1;
                prime.add(first);
            }
            j++;
        }
        return ans;
    }
}