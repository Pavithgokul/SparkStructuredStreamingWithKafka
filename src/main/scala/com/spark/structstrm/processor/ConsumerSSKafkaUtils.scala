package com.spark.structstrm.processor

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.SparkConf
import org.apache.spark.streaming.Seconds


object kafkaConsumer extends App{
val kafkaParams = Map[String, Object](
  "bootstrap.servers" -> "localhost:9092",
  "key.deserializer" -> classOf[StringDeserializer],
  "value.deserializer" -> classOf[StringDeserializer],
  "group.id" -> "Sample_data",
  "auto.offset.reset" -> "latest",
  "enable.auto.commit" -> (false: java.lang.Boolean)
)

val conf = new SparkConf().setAppName("Sample").setMaster("local")
val ssc = new StreamingContext(conf, Seconds(1))


val topics = Array("occupancy_data")
val stream = KafkaUtils.createDirectStream[String, String](ssc, PreferConsistent, Subscribe[String, String](topics, kafkaParams))

val stream_2 = stream.map(record => (record.key, record.value))

stream_2.foreachRDD(rows => {
  rows.foreach(println(_))
})

ssc.start()

ssc.awaitTermination()



}