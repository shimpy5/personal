package com.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * Servlet implementation class ProdServlet
 */
public class ProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Properties kprop = new Properties();
		kprop.put(ProducerConfig.ACKS_CONFIG,"all");
		kprop.put(ProducerConfig.BATCH_SIZE_CONFIG, "16384");
		kprop.put(ProducerConfig.LINGER_MS_CONFIG, "1");
		kprop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		kprop.put(ProducerConfig.RETRIES_CONFIG, "0");
		kprop.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, "1000");
		BufferedReader rdr = request.getReader();
		String line = rdr.readLine();
		KafkaProducer<String,String> kp = new KafkaProducer<>(kprop);
		String topicStr = null;
		while(line != null)
		{
			String keyword = "orgname";
			if(line.startsWith(keyword))
			{
				topicStr = line.substring(keyword.length());
			}
		    line = rdr.readLine();
		    kp.send(new ProducerRecord<String,String>(topicStr, null, line));
		}
		kp.close();
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
