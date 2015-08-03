package org.cybergen

import org.apache.spark.{SparkContext, SparkConf}

/**
* Boot Strap Class
*
*/
object App
{
    def main(args: Array[String]):Unit={
        println( "Starting Application" )
        val conf = new SparkConf().setMaster("local").setAppName("wordCount Example")
        val sc = new SparkContext(conf)
        // Load and parse the data
        val data = sc.textFile("src/resources/README.md")

        val words = data.flatMap(_.split(" "))

      val wordCounts = words.map(x => (x, 1)).reduceByKey(_ + _)

      println(wordCounts.count())
      wordCounts.foreach( x => println(x._1 + " count "+x._2))

    }
}
