package kafkaprodservlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.kafka.clients.producer.KafkaProducer;

public class KafkaProducerServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException
	{
	   	resp.getWriter().println("Hello World");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	       throws ServletException, IOException
	{
		Properties props = new Properties();
		props.add("bootstrapservers","localhost:9092");
		props.add("acks","all");
		props.add("retries", "0");
		props.add("batch.size", "16384");
		Producer<String, String> prod = new KafkaProducer<>();
		BufferedReader rdr = req.getReader();
		String str = rdr.readLine();
		while( str != null)
		{
			if(str.startsWith("orgname"))
			{
				String kafkaTopic = str.substring(str.lastIndexOf("orgname"), str.length());
				myprod.createProducerAndSend(logMessage);
			}
		}
	}
	
	public void init() throws ServletException {
		System.out.println("Servlet " + this.getServletName() + "has started");
	}

}
