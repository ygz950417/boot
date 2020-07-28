package com.day20;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.Future;

public class _01MyProducerTest {
    public static void main(String[] args) throws Exception{
        Properties prop = new Properties();
        prop.load(_01MyProducerTest.class.getClassLoader().getResourceAsStream("producer.properties"));
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(prop);
        String topic ="kafka-test1";
        ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, "111");
        Future<RecordMetadata> future = producer.send(record);
        RecordMetadata recordMetadata = future.get();
        boolean hasOffset = recordMetadata.hasOffset();
        long offset = recordMetadata.offset();
        boolean hasTimestamp = recordMetadata.hasTimestamp();
        int partition = recordMetadata.partition();
        long timestamp = recordMetadata.timestamp();
        String topic1 = recordMetadata.topic();

        if(hasOffset){
            System.out.println("offer: "+offset);
        }
        if (hasTimestamp){
            System.out.println("timestamp: "+timestamp);
        }
        System.out.println("Topic: "+topic1);
        System.out.println("Partition: "+ partition);
        producer.close();
        //演示git
    }
}
