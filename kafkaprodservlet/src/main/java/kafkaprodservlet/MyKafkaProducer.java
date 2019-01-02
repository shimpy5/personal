package kafkaprodservlet;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class MyKafkaProducer {
	
	static Producer<String,String> instP = null;
	
	private MyKafkaProducer()
	{
		
	}
	synchronized public Producer<String,String> getInstance()
	{
		if(instP == null)
		{
			Properties props = new Properties();
			props.put("bootstrapservers", "localhost:9092");
			props.put("batch.size", "16384");
			props.put("linger.ms", "1");
			props.put("retries", "1");
			props.put("acks", "all");
			props.put("retries", 0);
			props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		    Producer<String, String> prod = new KafkaProducer<String,String>(props);
			instP = new KafkaProducer<String,String>(props);
		}
		return instP;
	}
	
	void createProducerAndSend(String logMessage)
	{
		
		for(int i=0 ; i < 100 ; i++)
		{
			prod.send(new ProducerRecord<String, String>("my-topic", null, "This is a logline"));
		}
		prod.close();
	}

}
