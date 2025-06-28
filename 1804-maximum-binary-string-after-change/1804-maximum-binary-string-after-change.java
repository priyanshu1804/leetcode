class Solution {
    public String maximumBinaryString(String binary) {
        int first=-1;
        char[] ch=binary.toCharArray();
        int n=ch.length;
        int count=0;
        for(int i=0;i<n;i++){
            if(ch[i]=='0'){
                if(first==-1){
                    first=i;
                }else{
                    count++;
                }
            }
        }
        if(first==-1){
            return binary;
        }
        Arrays.fill(ch,'1');
        ch[first+count]='0';
        return new String(ch);
    }
}