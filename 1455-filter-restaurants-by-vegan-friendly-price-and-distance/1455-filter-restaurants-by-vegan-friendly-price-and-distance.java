class Restaurant implements Comparable<Restaurant>{
    int id;
    int rating;
    Restaurant(int _id,int _rating){
        id=_id;
        rating=_rating;
    }
    @Override
    public int compareTo(Restaurant b){
        if(this.rating==b.rating){
            return b.id-this.id;
        }
        return b.rating-this.rating;
    }
}
class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        PriorityQueue<Restaurant> pq=new PriorityQueue<>();
        for(int[] restaurant:restaurants){
            int isVeganFriendly=restaurant[2];
            int distance=restaurant[4];
            int price=restaurant[3];
            if((veganFriendly==1&&isVeganFriendly==0)||distance>maxDistance||price>maxPrice){
                continue;
            }
            pq.add(new Restaurant(restaurant[0],restaurant[1]));
        }
        List<Integer> ans=new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll().id);
        }
        return ans;
    }
}