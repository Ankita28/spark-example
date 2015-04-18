package org.cybergen

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by vishnu on 17/4/15.
 */
object KNNQuery {
  def main(args: Array[String]) :Unit = {
    val conf = new SparkConf().setAppName("Nearest neighbour")
      .setMaster("spark://cyborg:7077")
      .setJars(Array("/home/vishnu/projects/spark-example/target/spark-example-1.0-SNAPSHOT-driver.jar"))

    val sc = new SparkContext(conf)

    val data = sc.textFile("/opt/spark/current/data/mllib/kmeans_data.txt")

  }
}
