package com.evodat.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;

import com.evodat.model.Carpark;
import com.evodat.model.Floor;
import com.evodat.service.CarparkManager;

public class GetFreeCarparkPlacesCron {

	private static Logger log = Logger
			.getLogger(GetFreeCarparkPlacesCron.class);
	private static String serviceUrl = "http://88.198.201.139:8080/monitors-adac-service/adac";

	protected CarparkManager carparkManager;

	@Scheduled(cron = "*/30 * * * * ?")
	public void getFreeCarparkPlaces() {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(serviceUrl);

		HttpResponse response;
		try {
			response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			InputStream content = entity.getContent();

			StringWriter writer = new StringWriter();
			IOUtils.copy(content, writer, "utf-8");
			String resp = writer.toString();
			int placesLeft = Integer.valueOf(resp);
			Carpark carparkCristal = carparkManager.get(Carpark.Cristal);
			List<Floor> floors = carparkCristal.getFloors();
			int placesTotal = 0;
			for (Floor floor : floors) {
				placesTotal += floor.getPlaces();
			}
			carparkCristal.setPlacesOccupied(placesTotal - placesLeft);
			carparkManager.save(carparkCristal);
			log.info(resp);

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setCarparkManager(CarparkManager carparkManager) {
		this.carparkManager = carparkManager;
	}

}
