
@Service
public class TwitterService {

    private Twitter twitter;

    @Autowired
    public TwitterService() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
          .setOAuthConsumerKey("8TWI9xzoiBsQSRT71uxmgOUb0")
          .setOAuthConsumerSecret("sScqhDIuhk24LpFwvx4XS1hDepGCFApMOF2USzvlDnFQi5ftKP")
          .setOAuthAccessToken("1784845600959107072-FZzebrgCB5Wn48zcUYikV2E2b8PjNl")
          .setOAuthAccessTokenSecret("EL8sZAKS04Mw4tPZZ8w5pTHOsWbtngDrA39xRWpzr0t6x");

        TwitterFactory tf = new TwitterFactory(cb.build());
        this.twitter = tf.getInstance();
    }

    public List<User> searchUsers(String query) throws TwitterException {
        Query twitterQuery = new Query(query);
        QueryResult result = twitter.searchUsers(twitterQuery);
        return result.getUsers();
    }

    public List<Status> getUserTweets(String userId) throws TwitterException {
        return twitter.getUserTimeline(userId).stream().collect(Collectors.toList());
    }
}