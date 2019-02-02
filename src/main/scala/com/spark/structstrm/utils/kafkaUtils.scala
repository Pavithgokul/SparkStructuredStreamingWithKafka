package com.spark.structstrm.utils

import com.typesafe.config.ConfigFactory

trait kafkaUtils {
  
  val kafkaConfig = ConfigFactory.load()
  
  val KafkaBroker = kafkaConfig.getString("kafka.bootstrap.server")
  val keySerializer = kafkaConfig.getString("kafka.serializers")
  val valueSerializer = kafkaConfig.getString("kafka.serializers")
  val topicName = kafkaConfig.getString("kafka.topic.name")
  
}