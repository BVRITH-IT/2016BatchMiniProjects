import re
import tweepy
from tweepy import OAuthHandler
from textblob import TextBlob
import matplotlib.pyplot as plt
import pandas as pd
from wordcloud import WordCloud
from wordcloud import STOPWORDS
from flask import *
from flask import session
app = Flask(__name__)
tweets={}

class TwitterClient(object):
    def __init__(self):
        consumer_key = ''
        consumer_secret = ''
        access_token = ''
        access_token_secret = ''
        try:
            self.auth = OAuthHandler(consumer_key, consumer_secret)
            self.auth.set_access_token(access_token, access_token_secret)
            self.api = tweepy.API(self.auth)
        except:
            print("Error: Authentication Failed")
    def clean_tweet(self, tweet):
        return ' '.join(re.sub("(@[A-Za-z0-9]+)|([^0-9A-Za-z \t]) |(\w+:\/\/\S+)", " ", tweet).split())
    def get_tweet_sentiment(self, tweet):
        analysis = TextBlob(self.clean_tweet(tweet))
        if analysis.sentiment.polarity > 0:
            return 'positive'
        elif analysis.sentiment.polarity == 0:
            return 'neutral'
        else:
            return 'negative'
    def get_tweets(self, query, count):
        tweets = []
        try:
            fetched_tweets = self.api.search(q = query, count = count, lang = 'en')
            for tweet in fetched_tweets:
                parsed_tweet = {}
                parsed_tweet['text'] = tweet.text
                parsed_tweet['sentiment'] = self.get_tweet_sentiment(tweet.text)
                if tweet.retweet_count > 0:
                    if parsed_tweet not in tweets:
                        tweets.append(parsed_tweet)
                else:
                    tweets.append(parsed_tweet)
            return tweets
        except tweepy.TweepError as e:
            print("Error : " + str(e))

def visualize(p,hash):
    s = ['Positive', 'Negative', 'Neutral']
    piec = pd.Series(p, index=s, name="Sentimental Analysis")
    fig, ax = plt.subplots()
    piec.plot.pie(fontsize=14, autopct='%.2f', figsize=(6, 6));
    fig.savefig('static/'+hash+'.png')

def wordCloudGen(tweets,hash):
    comment_words = ' '
    stopwords = set(STOPWORDS)
    for val in tweets:
        val = str(val['text'])
        tokens = val.split()
        for i in range(len(tokens)):
            tokens[i] = tokens[i].lower()
        for words in tokens:
            comment_words = comment_words + words + ' '
    wordcloud = WordCloud(width=800, height=800,
                          background_color='white',
                          stopwords=stopwords,
                          max_words=100,
                          min_font_size=10).generate(comment_words)
    fig, ax = plt.subplots()
    plt.figure(figsize=(8, 8), facecolor=None)
    plt.imshow(wordcloud)
    plt.axis("off")
    plt.tight_layout(pad=0)
    wordcloud.to_file('static/word/'+hash+".png")

@app.route('/')
def main():
    app.config["CACHE_TYPE"] = "null"
    return render_template('home.html')

@app.route("/project", methods = ['POST', 'GET'])
def project():
    api = TwitterClient()
    percent = []
    if request.method == 'POST':
        email = request.form['email']
    tweets = api.get_tweets(query = email , count = 25)
    ptweets = [tweet for tweet in tweets if tweet['sentiment'] == 'positive']
    nettweets = [tweet for tweet in tweets if tweet['sentiment'] == 'neutral']
    nums = 0
    percents = []
    str_data = "Positive = "
    data = (100*len(ptweets)/len(tweets))
    percents.append(data)
    nums+=data
    percent.append(str_data+str("{0:.2f}".format(data))+"%")
    ntweets = [tweet for tweet in tweets if tweet['sentiment'] == 'negative']
    str_data = "Negative = "
    data = (100*len(ntweets)/len(tweets))
    percents.append(data)
    nums+=data
    percent.append(str_data + str("{0:.2f}".format(data))+"%")
    str_data = "Neutral = "
    data1 = 100 - nums
    percent.append(str_data+str("{0:.2f}".format(data1))+"%")
    print(percent)
    percents.append(data1)
    visualize(percents,email)
    wordCloudGen(tweets,email)
    return render_template('dest.html', percent = percent, hash=email+".png", name=email+"'s" , tweets = tweets)

if __name__ == "__main__":
    app.run(debug=True)
    main()
