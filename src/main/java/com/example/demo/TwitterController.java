package com.example.demo;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TwitterController {

    @Autowired
    private TwitterService twitterService;

    @GetMapping("/search-tweet-user")
    public ResponseEntity<?> searchTweetUser(@RequestParam String query) throws TwitterException {
        List<User> users = twitterService.searchUsers(query);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/get-user-tweets")
    public ResponseEntity<?> getUserTweets(@RequestParam String userId) throws TwitterException {
        List<Status> tweets = twitterService.getUserTweets(userId);
        return ResponseEntity.ok(tweets);
    }
}

