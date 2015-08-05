package org.cybergen

import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.mllib.feature.HashingTF
import org.apache.spark.sql.SQLContext

/**
 * Class org.cybergen.ClusteringExample
 * Created by vishnu667 on 5/8/15.
 */
object ClusteringExample {
  def main(args: Array[String]) {
    println("Starting Application")

    // Setting spark Conf

    //Local Configuration

    val conf = new SparkConf()
      .setMaster("local")
      .setAppName("wordCount Example")
    .set("spark.executor.memory","2g")
    .set("spark.driver.memory","2g")


    //Cluster Configuration
//    val conf = new SparkConf().setMaster("spark://cyborg:7077")
//      .setAppName("SubmitJobToCluster Example")
//      .setJars(Seq("target/spark-example-1.0-SNAPSHOT-driver.jar"))

    // initializing the sparkContext
    val sc = new SparkContext(conf)

    val tweets = sc.textFile("src/resources/rawjsontweets/*/*")

    val sqlContext = new SQLContext(sc)

    val tweetTable = sqlContext.read.json(tweets)

    tweetTable.registerTempTable("tweets")

    val tweetText = sqlContext.sql("select text from tweets")



    val numFeatures = 1000
    val tf = new HashingTF(numFeatures)



    def featurize(text: String) = {
      tf.transform(text.sliding(2).toSeq)
    }

    val tweetsfeat = tweetText.map(x => featurize(x.getString(0)))


    tweetsfeat.cache()
    val model = KMeans.train(tweetsfeat, 2, 2)


    val some_tweets = tweetText.map(_.getString(0)).take(100)

    for (i <- 0 until 6) {
      println(s"\nCLUSTER $i:")
      some_tweets.foreach { t =>
        if (model.predict(featurize(t)) == i) {
          println(t)
        }
      }
    }
  }
}
