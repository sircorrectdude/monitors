package com.evodat.webapp.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.evodat.model.LicensePlate;

public class AnprAction extends BaseAction implements ServletRequestAware {
	private static Logger logger = Logger.getLogger(AnprAction.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 5648912307643456149L;
	HttpServletRequest servletRequest = null;

	@Override
	public String execute() throws Exception {

		String string = IOUtils.toString(servletRequest.getReader());
		logger.debug(string);
		LicensePlate licensePlate = new LicensePlate();
		Object obj = JSONValue.parse(string);
		JSONObject jSONObject = (JSONObject) obj;
		Long cameraId = (Long) jSONObject.get("camera_id");
		licensePlate.setCameraId(cameraId.intValue());
		String siteId = (String) jSONObject.get("site_id");
		licensePlate.setSiteId(siteId);
		Long imgHeight = (Long) jSONObject.get("img_height");
		licensePlate.setImgHeight(imgHeight.intValue());
		Long imgWidth = (Long) jSONObject.get("img_width");
		licensePlate.setImgWidth(imgWidth.intValue());
		String uuid = (String) jSONObject.get("uuid");
		licensePlate.setUuid(uuid);
		Date timestamp = new Date((Long) jSONObject.get("epoch_time"));
		licensePlate.setTimestamp(timestamp);

		logger.info(licensePlate);
		
		JSONArray results = (JSONArray) jSONObject.get("results");
		JSONObject result = (JSONObject) results.get(0);
		String plate = (String) result.get("plate");
		Double confidence = (Double) result.get("confidence");
		licensePlate.setPlate(plate);
		licensePlate.setConfidence(confidence);
		
		logger.info(licensePlate);
		
		licensePlateManager.save(licensePlate);

		return NONE;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

}
