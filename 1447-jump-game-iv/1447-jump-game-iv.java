class Solution {
    public int minJumps(int[] arr) {
        int n=arr.length;
        int ans=0;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                List<Integer> temp=new ArrayList<>();
                temp.add(i);
                map.put(arr[i],temp);
            }else{
                List<Integer> temp=map.get(arr[i]);
                temp.add(i);
                map.put(arr[i],temp);
            }
        }
        boolean[] vis=new boolean[n];
        vis[0]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curr=q.poll();
                if(curr==n-1){
                    return ans;
                }
                List<Integer> temp=map.get(arr[curr]);
                temp.add(curr+1);
                temp.add(curr-1);
                for(int it:temp){
                    if(it>0&&it<n&&!vis[it]){
                        vis[it]=true;
                        q.add(it);
                    }
                }
                temp.clear();
            }
            ans++;
        }
        return -1;
    }
}