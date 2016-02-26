package com.rachel.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class KafkaProducer {
	
	final static String TOPIC = "topic";
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("metadata.broker.list", "192.168.30.189:9092");
		prop.put("serializer.class","kafka.serializer.StringEncoder");
		ProducerConfig prodConfig = new ProducerConfig(prop);
		kafka.javaapi.producer.Producer<String, String> producer = new kafka.javaapi.producer.Producer<String, String>(prodConfig);
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		KeyedMessage<String, String> message =new KeyedMessage<String, String>(TOPIC,"Test message from java program " + dateFormat.format(new Date()));
        producer.send(message);
        producer.close();
	}

}
