package org.cybergen;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;


/**
 * Created by vishnu on 4/3/15.
 * sample program
 */
public class Hello {
    public static void main(String[] args) {
        System.out.println("Starting Java Application");
        SparkConf conf = new SparkConf().setAppName("").setMaster("local");

        //sparkContext is being initialized
        JavaSparkContext sc = new JavaSparkContext(conf);

        System.out.println("Within Set Sum of Squared Errors = ");
    }
}
