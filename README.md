# kafka Producer - Consumer

##### 1. download kafka: 
https://kafka.apache.org/downloads


##### 2. start zookeeper 
    $ cd <where unzip kafka>
    $ bin/zookeeper-server-start.sh config/zookeeper.properties

##### 3. start kafka:
    $ bin/kafka-server-start.sh config/server.properties

##### 4. start 2 producers (kafka_producer1 (port 8081)), kafka_producer2 (port 8082) modules) and consumer (kafka_consumer (port 8083) module) applications

##### 5. To check which messages your will send:
         $ cd <where unzip kafka>
         $ bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic Topic1
         
and for Topic2:

         $ cd <where unzip kafka>
         $ bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic Topic2
When your will send messages, check them in these terminals. 
        
##### 6. send messages from 
###### 6.1 kafka_producer1 to the topic "Topic1" (from Postman, for example):

    {
        "field1": "field1",
        "field2": "field2 This message sent by kafka producer1 to the Topic1"
    }

Endpoint: POST http://localhost:8081/api/kafka
This message will be added to the topic "Topic1"

###### 6.2 kafka_producer1 to the topic "Topic2":
    {
        "title": "Produce message.",
        "description": "This message was sending by kafka producer1 to the Topic2"
    }
 
 Endpoint: POST http://localhost:8081/api/kafka/v2
 This message will be added to the topic "Topic2"
    
###### 6.3 kafka_producer2 to the topic "Topic1":

    {
        "field1": "field1",
        "field2": "field2 This message sent by kafka producer2 to the Topic1"
    }
   
   endpoint: http://localhost:8082/api/kafka
   This message will be added to the topic "Topic1"
   
###### 6.4 kafka_producer2 to the topic "Topic2":
    {
        "title": "Produce message.",
        "description": "This message was sending by kafka producer2 to the Topic2"
    }
 
 Endpoint: POST http://localhost:8082/api/kafka/v2
 This message will be added to the topic "Topic2"

###### 7. In kafka_consumer application logs your can see that kafka consume all messages.