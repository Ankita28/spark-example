package org.cybergen

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by vishnu on 16/4/15.
 * A simple nearest neighbour problem
 */
object NearestNeighbour{

  def main() :Unit = {
    val conf = new SparkConf().setAppName("nearest neighbour").setMaster("spark://cyborg:7077")
      .setJars(Array("/home/vishnu/projects/spark-example/target/spark-example-1.0-SNAPSHOT-driver.jar"))
    val sc = new SparkContext(conf)


  }

}

class RowData(val x:Double,val y:Double,val z:Double,val neighbours:Seq[RowData]=Seq) {
}