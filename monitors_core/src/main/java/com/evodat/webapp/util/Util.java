package com.evodat.webapp.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

public class Util {

	private static Logger logger = Logger.getLogger(Util.class);

	/**
	 * @param url
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static InputStream getPage(String url)
			throws ClientProtocolException, IOException {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		return getPage(url, httpclient);
	}

	/**
	 * @param url
	 * @param httpclient
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static InputStream getPage(String url, HttpClient httpclient)
			throws ClientProtocolException, IOException {
		HttpGet httpget = new HttpGet(url);
		HttpResponse response = httpclient.execute(httpget);
		int statusCode = response.getStatusLine().getStatusCode();
		// logger.debug(response.getStatusLine() + "Code: " + statusCode);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			return entity.getContent();
		}
		return null;
	}

	/**
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public static String convertStreamToString(InputStream is)
			throws IOException {
		/*
		 * To convert the InputStream to String we use the Reader.read(char[]
		 * buffer) method. We iterate until the Reader return -1 which means
		 * there's no more data to read. We use the StringWriter class to
		 * produce the string.
		 */
		if (is != null) {
			Writer writer = new StringWriter();

			char[] buffer = new char[1024];
			try {
				Reader reader = new BufferedReader(new InputStreamReader(is,
						"UTF-8"));
				int n;
				while ((n = reader.read(buffer)) != -1) {
					writer.write(buffer, 0, n);
				}
			} finally {
				is.close();
			}
			return writer.toString();
		} else {
			return "";
		}
	}

}
