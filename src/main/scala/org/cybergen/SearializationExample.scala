package org.cybergen

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Class org.cybergen.SearializationExample
 * Created by vishnu667 on 5/8/15.
 */
object SearializationExample {
  def main(args: Array[String]) {
    val sample = new SampleClass(100,1000)

    // Setting up spark conf
    val conf = new SparkConf()
      .setMaster("local")
      .setAppName("SearializationJobToCluster Example")
//      .setJars(Seq("target/spark-example-1.0-SNAPSHOT-driver.jar"))

    // initializing the sparkContext
    val sc = new SparkContext(conf)

    val obj = new SearializationJobToCluster(100)

    obj.submitJob(sample,sc)
  }
}
