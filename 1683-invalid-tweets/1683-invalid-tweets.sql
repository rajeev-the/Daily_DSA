# Write your MySQL query statement below
Select tweet_id 
from Tweets
WHERE LENGTH(Tweets.content) > 15;