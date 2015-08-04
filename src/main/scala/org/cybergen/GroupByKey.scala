package org.cybergen

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Sample Example Class
 * GroupByKey Example
 */
object GroupByKey {
  def main(args: Array[String]): Unit = {

    println("Starting Application")

    // Setting spark Conf with local Configuration
    val conf = new SparkConf().setMaster("local").setAppName("wordCount Example")

    // initializing the sparkContext
    val sc = new SparkContext(conf)

    // loading the data and spliting them as
    val data = sc.textFile("src/resources/samplePointsForGroupOperations").map(v => {
      val tmp = v.split(",")
      (tmp(0).toInt, tmp(1).toInt)
    })

    // Printing the Grouped Elements
    data.groupByKey().foreach(println)

    println("Application Exited Gracefully")
  }
}
