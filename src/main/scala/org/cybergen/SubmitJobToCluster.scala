package org.cybergen

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Class org.cybergen.SubmitJobToCluster
 * Created by vishnu667 on 5/8/15.
 */
object SubmitJobToCluster {
  def main(args: Array[String]): Unit = {

    println("Starting Application")

    // Setting up spark conf
    val conf = new SparkConf()
      .setMaster("spark://cyborg:7077")
      .setAppName("SubmitJobToCluster Example")
//      .setJars(Seq("target/spark-example-1.0-SNAPSHOT-driver.jar"))

    // initializing the sparkContext
    val sc = new SparkContext(conf)

    //create an rdd from a collection

    val rdd = sc.parallelize((0 to 100).map( i=>(i,math.random%1000)))
    val rdd2 = sc.parallelize((0 to 100).map(i =>rdd.count()))

    // Printing the rdd Type
    println(rdd)

    // Printing the Elements
    rdd.collect().foreach(println)
    rdd2.collect().foreach(println)

    println("Application Exited Gracefully")
  }
}
