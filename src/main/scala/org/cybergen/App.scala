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
        import org.apache.spark.mllib.clustering.KMeans
        import org.apache.spark.mllib.linalg.Vectors
        val conf = new SparkConf().setAppName("kmeansScala").setMaster("spark://cyborg:7077")
          .setJars(Array("/home/vishnu/projects/spark-example/target/spark-example-1.0-SNAPSHOT-driver.jar"))
        val sc = new SparkContext(conf)
        // Load and parse the data
        val data = sc.textFile("/opt/spark/current/data/mllib/kmeans_data.txt")
        val parsedData = data.map(s => Vectors.dense(s.split(' ').map(_.toDouble))).cache()

        // Cluster the data into two classes using KMeans
        val numClusters = 2
        val numIterations = 20
        val clusters = KMeans.train(parsedData, numClusters, numIterations)

        // Evaluate clustering by computing Within Set Sum of Squared Errors
        val WSSSE = clusters.computeCost(parsedData)
        println("Within Set Sum of Squared Errors = " + WSSSE)
    }
}
