package Twitter;

import java.util.*;

public class Twitter {
    private Map<Integer, Tweet> users;
    private Map<Integer, Set<Integer>> followers;
    private static int tweet_num = 0;
    private static TreeMap<Integer, Integer> tMap;

    public Twitter() {
        followers = new HashMap<>();
        users = new HashMap<>();
        tMap = new TreeMap<>(Collections.reverseOrder());
    }

    public void postTweet(int userId, int tweetId) {
        tweet_num++;
        if (users.containsKey(userId)) {
            Tweet oldHead = users.get(userId);
            Tweet newHead = new Tweet(tweetId, tweet_num);
            newHead.next = oldHead;
            users.put(userId, newHead);
        } else {
            users.put(userId, new Tweet(tweetId, tweet_num));
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        tMap.clear();

        if (users.containsKey(userId)) {
            Tweet theT = users.get(userId);
            for (int i=0; i<10; i++) {
                if (theT != null){
                    tMap.put(theT.tweet_num, theT.id);
                    theT = theT.next;
                }
            }
        }

        Set<Integer> followingList = followers.get(userId);
        if (followingList != null && followingList.size() > 0) {
            for (Integer followingId : followingList) {
                Tweet tweet = users.get(followingId);
                for(int i=0; i<10; ++i){
                    if (tweet != null) {
                        tMap.put(tweet.tweet_num, tweet.id);
                        tweet = tweet.next;
                    }
                }
            }
        }

        System.out.println(tMap);

        List<Integer> res = new ArrayList<>(10);
        int count = 0;
        for (int id: tMap.values()){
            res.add(id);
            count++;
            if(count==10) break;
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }

        Set<Integer> followingList = followers.get(followerId);
        if (followingList == null) {
            Set<Integer> init = new HashSet<>();
            init.add(followeeId);
            followers.put(followerId, init);
        } else {
            if (followingList.contains(followeeId)) {
                return;
            }
            followingList.add(followeeId);
        }
    }


    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }

        Set<Integer> followingList = followers.get(followerId);

        if (followingList == null) {
            return;
        }
        followingList.remove(followeeId);
    }


    private class Tweet {
        private int id;
        private int tweet_num;
        private Tweet next;

        public Tweet(int id, int tweet_num) {
            this.id = id;
            this.tweet_num = tweet_num;
        }
    }

    public static void main(String[] args) {

        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        List<Integer> res1 = twitter.getNewsFeed(1);
        System.out.println(res1);

        twitter.follow(2, 1);

        List<Integer> res2 = twitter.getNewsFeed(2);
        System.out.println(res2);

        twitter.unfollow(2, 1);

        List<Integer> res3 = twitter.getNewsFeed(2);
        System.out.println(res3);
    }
}

