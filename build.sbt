name := "SparkStructuredStreamingWithKafka"

version := "1.0"

scalaVersion := "2.11.8"

// https://mvnrepository.com/artifact/org.apache.spark/spark-core
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.3.0"

// https://mvnrepository.com/artifact/org.apache.spark/spark-sql
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.3.0"

// https://mvnrepository.com/artifact/mysql/mysql-connector-java
libraryDependencies += "mysql" % "mysql-connector-java" % "6.0.6"


// https://mvnrepository.com/artifact/org.apache.spark/spark-streaming
//libraryDependencies += "org.apache.spark" %% "spark-streaming" % "1.6.0" % "provided"

// https://mvnrepository.com/artifact/org.apache.spark/spark-hive
//libraryDependencies += "org.apache.spark" %% "spark-hive" % "1.6.0" % "provided"

// https://mvnrepository.com/artifact/org.apache.spark/spark-streaming-kafka
//libraryDependencies += "org.apache.spark" %% "spark-streaming-kafka" % "1.6.0"

// https://mvnrepository.com/artifact/com.typesafe/config
//libraryDependencies += "com.typesafe" % "config" % "1.2.1"

// https://mvnrepository.com/artifact/com.datastax.cassandra/cassandra-driver-core
//libraryDependencies += "com.datastax.cassandra" % "cassandra-driver-core" % "3.6.0"

// https://mvnrepository.com/artifact/com.datastax.spark/spark-cassandra-connector
//libraryDependencies += "com.datastax.spark" %% "spark-cassandra-connector" % "1.6.0"

// https://mvnrepository.com/artifact/org.apache.spark/spark-sql-kafka-0-10
libraryDependencies += "org.apache.spark" %% "spark-sql-kafka-0-10" % "2.3.1" % "provided"





