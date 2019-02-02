package com.spark.structstrm.kafkaeg

import org.apache.log4j.Logger
import org.apache.log4j.Level
import com.spark.structstrm.utils.Commons
import org.apache.spark.sql.SparkSession
import java.util.Properties
import com.spark.structstrm.utils.kafkaUtils
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.spark.sql.ForeachWriter
import org.apache.kafka.clients.producer.ProducerRecord

/*
 * Created By		: 	Pavith Gokul R
 * Created Date	: 	02:02:2019	 
 * Description	:		This code is going to act as an event generator which will generate event and send it to Kafka topic.
 * 									Typically this code will act as Kafka Producer.
 */
object EventGenerator extends App with Commons with kafkaUtils{

	private final val logger = Logger.getLogger(EventGenerator.getClass)
			logger.setLevel(Level.INFO)

			val sparkSession: SparkSession = spark

			val inputDataset = sparkSession.read.option("header", true).csv("/home/hadoop-master/workspace/SparkStructuredStreamingWithKafka/input_dataset/occupancy_data.csv")

			val jsonData = inputDataset.toJSON

			jsonData.collect().foreach(a => {

				val prop = new Properties()
				prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaBroker)
				prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keySerializer)
				prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueSerializer)

				val producer = new KafkaProducer[String, String](prop)
				
				val record = new ProducerRecord[String, String](topicName, "Occupancy", a)
						
				try{
				  producer.send(record)
				}catch{
				  case e: Exception => e.printStackTrace()
				}finally{
				  producer.close()
				}
						
			})
	
			sparkSession.stop()

}