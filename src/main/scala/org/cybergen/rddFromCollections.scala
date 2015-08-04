package org.cybergen

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Sample Example Class
 * creating an rdd From Collections Example
 */
object rddFromCollections {
  def main(args: Array[String]): Unit = {

    println("Starting Application")

    // Setting spark Conf with local Configuration
    val conf = new SparkConf().setMaster("local").setAppName("wordCount Example")

    // initializing the sparkContext
    val sc = new SparkContext(conf)

    //create an rdd from a collection

    val rdd = sc.parallelize((0 to 100).map( i=>(i,math.random%1000)))

    // Printing the rdd Type
    println(rdd)

    // Printing the Elements
    rdd.foreach(println)

    println("Application Exited Gracefully")
  }
}
