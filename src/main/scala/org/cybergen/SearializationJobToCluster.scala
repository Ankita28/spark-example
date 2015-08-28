package org.cybergen

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Class org.cybergen.SubmitJobToCluster
 * Created by vishnu667 on 5/8/15.
 */
class SearializationJobToCluster(iterations:Int) extends Serializable{



  val boolArray = (0 to iterations).map(math.random*_>0)

  override def toString():String = boolArray.head.toString

  def submitJob(sampleClass: SampleClass,sc:SparkContext): Unit = {
    //create an rdd from a collection


    val rdd = sc.parallelize((0 to iterations).map(i => {
      (i, new SampleClass(0,i),boolArray.head)
    }))

    // Printing the rdd Type
    println(rdd)

    // Printing the Elements
    rdd.collect().foreach(println)

    println("Application Exited Gracefully")
  }
}
