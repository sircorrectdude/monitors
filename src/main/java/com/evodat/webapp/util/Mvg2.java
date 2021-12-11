package com.evodat.webapp.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.Date;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
public class Mvg2 extends TrafficInfo {


	private String transportTypes;
	public String station;

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}
	public List<TrafficInfo> getObjects() {

		SSLContext sslContext = null;
		try {
			sslContext = SSLContext.getInstance("SSL");
			// Create a new X509TrustManager
			sslContext.init(null, getTrustManager(), null);
		} catch (NoSuchAlgorithmException | KeyManagementException e) {

		}
		HostnameVerifier allHostsValid = new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};
		final Client client = ClientBuilder.newBuilder().hostnameVerifier(allHostsValid)
				.sslContext(sslContext).build();

		WebTarget target = client.target("https://www.mvg.de").path("/api/fahrinfong/departure");
		Response response = target.queryParam("stationGlobalId", station).queryParam("transportTypes", transportTypes).request().get();
		String string = response.readEntity(String.class);
		Object obj = JSONValue.parse(string);
		JSONArray jSONArray = (JSONArray) obj;
		List<TrafficInfo> list = new ArrayList<>();
		for(int i = 0;i<jSONArray.size(); i++){
			JSONObject result = (JSONObject) jSONArray.get(i);
			TrafficInfo trafficInfo= new TrafficInfo();
			trafficInfo.setTime(new Date((Long) result.get("plannedDepartureTime")));
			trafficInfo.setTarget((String) result.get("destination"));
			trafficInfo.setTrain((String) result.get("label"));
			list.add(trafficInfo);
		}
		return list;

	}

	public void setTransportTypes(String transportTypes) {
		this.transportTypes = transportTypes;
	}

	private TrustManager[] getTrustManager() {
		return new TrustManager[]{
				new X509TrustManager() {
					@Override
					public X509Certificate[] getAcceptedIssuers() {
						return null;
					}

					@Override
					public void checkServerTrusted(X509Certificate[] chain, String authType)
							throws CertificateException {
					}

					@Override
					public void checkClientTrusted(X509Certificate[] chain, String authType)
							throws CertificateException {
					}
				}
		};
	}
}
