package com.soosoo.soosoo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
public class SoosooApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SoosooApplication.class, args);

		Properties configs = new Properties();
		configs.put("bootstrap.servers", "localhost:9092");
		configs.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		configs.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(configs);
		ProducerRecord record = new ProducerRecord<String,String>("click_log" , "login");
		producer.send(record);
		producer.close();

	}

}
