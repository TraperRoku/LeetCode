import java.util.*;

class Twitter {
Map<Integer, List<int[]>> userToTweets;
Map<Integer, Set> userToFollowers;
int time;
    public Twitter() {
        userToTweets = new HashMap<>();
        userToFollowers = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        final int[] tweet = new int[] {tweetId, time};
        userToTweets.putIfAbsent(userId, new ArrayList<>());
        userToTweets.get(userId).add(tweet);
        time++;
    }

    public List<Integer> getNewsFeed(int userId) {
     
        final Set<Integer> followers = userToFollowers.getOrDefault(userId, new HashSet<>());
   
        followers.add(userId);


        final Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (final int user: followers) {
            final List<int[]> allTweets = userToTweets.getOrDefault(user, new ArrayList<>());
  
            for (final int[] t: allTweets) {
                pq.add(t);
                if (pq.size() > 10) {
                    pq.remove();
                }
            }
        }

        final List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(0, pq.remove()[0]);
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        userToFollowers.putIfAbsent(followerId, new HashSet<>());
        userToFollowers.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (userToFollowers.containsKey(followerId) && userToFollowers.get(followerId).contains(followeeId)) {
            userToFollowers.get(followerId).remove(followeeId);
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