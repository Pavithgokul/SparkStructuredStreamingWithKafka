package com.spark.structstrm.utils

import com.typesafe.config.{Config, ConfigFactory}
import org.apache.spark.sql.SparkSession

trait Commons {
  
  val config = ConfigFactory.load()
  
  val hostName = config.getString("host")
  val appName = config.getString("application.name")
  val sparkMaster = config.getString("application.master")
  
  println("Please find the host Name : " + hostName)
  
  
  def spark: SparkSession = {
  
    SparkSession.builder()
                .appName(appName)
                .master(sparkMaster)
                .getOrCreate()
    
  }
  
}