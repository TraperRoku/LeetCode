import java.util.*;

class Twitter {
Map<Integer, List<int[]>> userTweets;
Map<Integer, Set> userFollows;
int time;
    public Twitter() {
    userFollows = new HashMap<>();
    userTweets = new HashMap<>();
    time = 0;

    }

    public void postTweet(int userId, int tweetId) {
         final int[] tweet = new int[] {tweetId, time};
         userTweets.putIfAbsent(userId, new ArrayList<>());
        userTweets.get(userId).add(tweet);
        time++;
    }


    public List<Integer> getNewsFeed(int userId) {
    final Set<Integer> followers = userFollows.getOrDefault(userId,new HashSet<>());
    followers.add(userId);

   final Queue<int []> queue = new PriorityQueue<>((a,b)->a[1] - b[1]);
    for(final int user : followers){
        final List<int[]> allTweets = userTweets.getOrDefault(user,new ArrayList<>());
        for(final int[] tweet: allTweets){
            queue.add(tweet);
        
        if(queue.size() > 10){
            queue.remove();
        }
}
    }
    List<Integer> result = new ArrayList<>();
    while (!queue.isEmpty()){
        result.add(0,queue.remove()[0]);
    }
    return result;

    }

    public void follow(int followerId, int followeeId) {
    userFollows.putIfAbsent(followerId,new HashSet<>());
    userFollows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
    if(userFollows.containsKey(followerId) && userFollows.get(followerId).contains(followeeId)){
        userFollows.get(followerId).remove(followeeId);
    }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */