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
    val tmpData:Seq[RowData] =Seq(new RowData(1,1,1),new RowData(2,2,1),new RowData(3,2,1),new RowData(4,3,2),new RowData(5,2,2),new RowData(6,2,2),new RowData(7,1,2),new RowData(8,3,1),new RowData(9,2,1))
    val dataSeq = sc.parallelize(tmpData,2)

    dataSeq.map(row => {
      dataSeq.map(loopRow => loopRow.x)
    })
  }

}

class RowData(val x:Double,val y:Double,val z:Double,val neighbours:Seq[RowData]=Seq){

}