class Solution {
    static final int N=100001;
    static List<List<Integer>> graph=new ArrayList<>();
    static int[] sieve=new int[N];
    static boolean sieveBuilt=false;
    static int[] parent;
    static int[] size;
    static void makeDSU(int n){
        parent=new int[n+1];
        size=new int[n + 1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    static int findLeader(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x]=findLeader(parent[x]);
    }
    static void mergeSets(int a,int b){
        a=findLeader(a);
        b=findLeader(b);
        if(a==b){
            return;
        }
        if(size[a]>size[b]){
            int temp=a;
            a=b;
            b=temp;
        }
        size[b]+=size[a];
        parent[a]=b;
    }
    static void buildSieve() {
        if(sieveBuilt){
            return;
        }
        sieveBuilt=true;
        for(int i=2;i<N;i++){
            if(sieve[i]==0){
                sieve[i]=i;
            }
            for(int j=i+i;j<N;j+=i){
                if(sieve[j]==0){
                    sieve[j]=i;
                }
            }
        }
    }
    static boolean isPrime(int x) {
        return sieve[x]==x;
    }
    public static long countPaths(int n,int[][] edges){
        buildSieve();
        for(int i=0;i<=n;i++){
            if(graph.size()<=i){
                graph.add(new ArrayList<>());
            }
            else{
                graph.get(i).clear();
            }
        }
        makeDSU(n);
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            if(!isPrime(u)&&!isPrime(v)){
                mergeSets(u,v);
            }
        }
        long ans=0;
        for(int i=1;i<=n;i++){
            if(!isPrime(i)){
                continue;
            }
            List<Integer> sizes=new ArrayList<>();
            long total=1;
            for(int nei:graph.get(i)){
                if(isPrime(nei)){
                    continue;
                }
                int compSize=size[findLeader(nei)];
                sizes.add(compSize);
                total+=compSize;
            }
            for(int s:sizes){
                total-=s;
                ans+=(long)s*total;
            }
        }
        return ans;
    }
}
