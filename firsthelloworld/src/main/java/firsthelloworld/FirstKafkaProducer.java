package firsthelloworld;
import java.util.Properties;

import org.apache.kafka.clients.producer.*;

public class FirstKafkaProducer {
	private final static String Topic ="my-example-topic";
	
	void createProducerAndSendRecord()
	{
		Properties prop = new Properties();
		prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		prop.put(ProducerConfig.RETRIES_CONFIG, "0");
		prop.put(ProducerConfig.LINGER_MS_CONFIG, 1);
		prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		prop.put(ProducerConfig.ACKS_CONFIG, "all");
		Producer prod= new KafkaProducer(prop);
		
		for(int i = 0; i <100; i++)
		{
			prod.send(new ProducerRecord(Topic, 1, null, "I am here"));
		}
		prod.close();
	}

}
