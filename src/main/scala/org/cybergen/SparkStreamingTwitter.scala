package org.cybergen

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.streaming.twitter.TwitterUtils
import org.apache.spark.streaming.{StreamingContext, Seconds}

/**
 * Created by vishnu on 03/08/15.
 */
object SparkStreamingTwitter {


  def main(args: Array[String]) {

    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    val apiKey = "**"
    val apiSecret = "**"
    val accessToken = "**"
    val accessTokenSecret = "**"

    System.setProperty("twitter4j.oauth.consumerKey", apiKey)
    System.setProperty("twitter4j.oauth.consumerSecret", apiSecret)
    System.setProperty("twitter4j.oauth.accessToken", accessToken)
    System.setProperty("twitter4j.oauth.accessTokenSecret", accessTokenSecret)

    val sparkConf = new SparkConf()
      .setAppName("Twitter")
      .set("spark.executor.memory", "4g")
      .setMaster("local[4]")
    val sc = new SparkContext(sparkConf)


    // Creating A Spark Streaming Context

    //Create Streaming Context with 10 second batch Interval

    val ssc = new StreamingContext(sc, Seconds(10))


    val tweetStream = TwitterUtils.createStream(ssc, None)


    val tweets = tweetStream.map(_.getText)

    //Create Streaming Context with 10 second batch Interval


    // Filter English Tweets


    //WordCount

    val x = tweets.flatMap(_.split(" ")).map(x => (x,1)).reduceByKey((x,y)=> x + y).transform(_.sortBy(_._2,false))

    x.print()

    ssc.start()


  }
}
