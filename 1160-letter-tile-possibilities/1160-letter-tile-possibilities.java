class Solution {
    public int numTilePossibilities(String tiles) {
        List<String> list=new ArrayList<>();
        fun(0,list,"",tiles);
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<list.size();i++){
            String str=list.get(i);
            char arr[]=str.toCharArray();
            perm(0,arr,set);
        }
        return set.size();
    }
    public void swap(char arr[],int start,int end){
        char temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
    }
    public void perm(int index,char arr[],HashSet<String> set){
        if(index==arr.length){
            StringBuilder sb=new StringBuilder();
            for(char ch:arr) sb.append(ch);
            set.add(sb.toString());
            return;
        }
        for(int i=index;i<arr.length;i++){
            swap(arr,i,index);
            perm(index+1,arr,set);
            swap(arr,i,index);
        }
    }
    public void fun(int index,List<String> list,String str,String tiles){
        if(index==tiles.length()) {
            if(str.length()==0) return;
            list.add(new String(str));
            return ;
        }
        str+=tiles.charAt(index);
        fun(index+1,list,str,tiles);
        str=str.substring(0,str.length()-1);
        fun(index+1,list,str,tiles);
    }
}