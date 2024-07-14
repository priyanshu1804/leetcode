class Solution {
    public String getSmallestString(String s) {
        char[] arr=s.toCharArray();
        for(int i=0;i<s.length()-1;i++){
            if(arr[i]-'0'>arr[i+1]-'0'&&(((arr[i]-'0')%2==0&&(arr[i+1]-'0')%2==0)||(arr[i]-'0')%2!=0&&(arr[i+1]-'0')%2!=0)){
                char temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
                i++;
                break;
            }
        }
        String str="";
        for(char ch:arr){
            str+=ch;
        }
        return str;
    }
}