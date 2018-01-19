package com.evodat.webapp.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

public class Anpr extends javax.servlet.http.HttpServlet {

	
	private static final long serialVersionUID = 5405249395568008747L;
	private static Logger logger = Logger.getLogger(Anpr.class);
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		String string = IOUtils.toString(request.getReader());
		logger.info(string);
	}
	
}
