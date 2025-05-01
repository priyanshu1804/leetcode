class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int m=tasks.length;
        int n=workers.length;
        int start=0;
        int end=Math.min(m,n);
        while(start<end){
            int mid=(end-start)/2+start;
            boolean flag=true;
            TreeMap<Integer,Integer> map=new TreeMap<>();
            for(int it:workers){
                map.put(it,map.getOrDefault(it,0)+1);
            }
            int count=pills;
            for(int i=mid;i>=0;i--){
                int it=map.lastKey();
                if(tasks[i]<=it){
                    map.put(it,map.get(it)-1);
                    if(map.get(it)==0){
                        map.remove(it);
                    }
                }else{
                    Integer it1=map.ceilingKey(tasks[i]-strength);
                    if(it1!=null){
                        count--;
                        map.put(it1,map.get(it1)-1);
                        if(map.get(it1)==0){
                            map.remove(it1);
                        }
                    }else{
                        flag=false;
                        break;
                    }
                }
                if(count<0){
                    flag=false;
                    break;
                }
            }
            if(flag){
                start=mid+1;
            }else{
                end=mid;
            }
        }
        return start;
    }
}