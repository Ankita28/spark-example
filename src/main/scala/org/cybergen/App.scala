package org.cybergen

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Sample Example Class
 * which Finds the total word count
 * and the number of times each word occurs
 */
object App {
  def main(args: Array[String]): Unit = {
    println("Starting Application")
    // Setting spark Conf with local Configuration
    val conf = new SparkConf().setMaster("local").setAppName("wordCount Example")

    // initializing the sparkContext
    val sc = new SparkContext(conf)

    // loading
    val data = sc.textFile("src/resources/README.md")

    // Splitting
    val words = data.flatMap(_.split(" "))

    val wordCounts = words.map(x => (x, 1)).reduceByKey(_ + _).sortBy(x => x._2)

    println(wordCounts.count())

    wordCounts.foreach(x => println(x._1 + " count " + x._2))


    println("Application Exited Gracefully")
  }
}
