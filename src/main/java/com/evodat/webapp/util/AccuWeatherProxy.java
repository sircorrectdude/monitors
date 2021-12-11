package com.evodat.webapp.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

public class AccuWeatherProxy extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		 HttpClient httpclient = new DefaultHttpClient();
		 HttpGet httpget = new HttpGet("http://wwwa.accuweather.com/adcbin/forecastfox/weather_data.asp?location="+URLEncoder.encode("EUR|DE|GM002|MUNCHEN", "UTF-8"));
		 HttpResponse response = httpclient.execute(httpget);
		 // Get hold of the response entity
		 HttpEntity entity = response.getEntity();

		 // If the response does not enclose an entity, there is no need
		 // to worry about connection release
		 if (entity != null) {
		     InputStream instream = entity.getContent();
		     try {

		    	 StringWriter writer = new StringWriter();
		    	 IOUtils.copy(instream, writer, "UTF-8");
		    	 String theString = writer.toString();
		    	 System.out.println(theString);
		     } catch (IOException ex) {

		         // In case of an IOException the connection will be released
		         // back to the connection manager automatically
		         throw ex;

		     } catch (RuntimeException ex) {

		         // In case of an unexpected exception you may want to abort
		         // the HTTP request in order to shut down the underlying
		         // connection and release it back to the connection manager.
		         httpget.abort();
		         throw ex;

		     } finally {

		         // Closing the input stream will trigger connection release
		         instream.close();

		     }
		 }
		 
		String s="[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
		  Object obj=JSONValue.parse(s);
		  JSONArray array=(JSONArray)obj;
		  System.out.println("======the 2nd element of array======");
		  System.out.println(array.get(1));
		  System.out.println();

		
	}
	
}
