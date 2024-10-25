class Solution {
    public List<String> removeSubfolders(String[] folder){
        Set<String> set=new HashSet<>(Arrays.asList(folder));
        List<String> result=new ArrayList<>();
        for (String it:folder){
            boolean flag=false;
            String str=it;
            while(!str.isEmpty()){
                int pos=str.lastIndexOf('/');
                if(pos==-1){
                    break;
                }
                str=str.substring(0,pos);
                if(set.contains(str)){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                result.add(it);
            }
        }
        return result;
    }
}