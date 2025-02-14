class ProductOfNumbers {
    ArrayList<Integer> st;
    int prev;
    public ProductOfNumbers() {
        st=new ArrayList<>();
        prev=1;
    }
    public void add(int num) {
        if(num==0){
            st=new ArrayList<>();
            prev=1;
        }else{
            prev=prev*num;
            st.add(prev);
        }
    }
    
    public int getProduct(int k) {
        int x=st.size();
        if(k == x){
            return st.get(x-1);
        }
        else if(k > x){
            return 0;
        }
        return (st.get(x-1))/st.get(st.size()-1-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */