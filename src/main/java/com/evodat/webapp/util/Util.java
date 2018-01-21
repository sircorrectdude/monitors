package com.evodat.webapp.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

public class Util {

	private static Logger logger = Logger.getLogger(Util.class);

	
	public static HttpClient wrapClient(HttpClient base) {
        try {
            SSLContext ctx = SSLContext.getInstance("TLSv1.2");
            X509TrustManager tm = new X509TrustManager() {
 
                public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException {
                }
 
                public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException {
                }
 
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            X509HostnameVerifier verifier = new X509HostnameVerifier() {

				public boolean verify(String host, SSLSession session) {
					// TODO Auto-generated method stub
					return false;
				}

				public void verify(String host, SSLSocket ssl) throws IOException {
					// TODO Auto-generated method stub
					
				}

				public void verify(String host, X509Certificate cert) throws SSLException {
					// TODO Auto-generated method stub
					
				}

				public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {
					// TODO Auto-generated method stub
					
				}
 
            };
            ctx.init(null, new TrustManager[]{tm}, null);
            SSLSocketFactory ssf = new SSLSocketFactory(ctx);
            ssf.setHostnameVerifier(verifier);
            ClientConnectionManager ccm = base.getConnectionManager();
            SchemeRegistry sr = ccm.getSchemeRegistry();
            sr.register(new Scheme("https", ssf, 443));
            return new DefaultHttpClient(ccm, base.getParams());
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
	
	
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
		httpclient = wrapClient(httpclient);
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
