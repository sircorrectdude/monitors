package com.evodat.adac;

import java.io.IOException;
import java.net.URL;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.soap.Constants;
import org.apache.soap.rpc.Call;
import org.apache.soap.rpc.Parameter;
import org.apache.soap.rpc.Response;

public class ADACServlet extends HttpServlet {

	private static final long serialVersionUID = 2210893804287737186L;
	private static Logger log = Logger.getLogger(ADACServlet.class);

	String sServiceUrl = "http://routenplaner.adac.de/webservice/ParkInfoServiceV2.asmx";
	String sServiceUri = ""; // must match HelloWorld.xml
	String sMethodName = "getDynamicData";

	@Override
	protected void service(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws ServletException,
			IOException {

		super.service(httpServletRequest, httpServletResponse);
		log.info("request..");
		Response resp;
		try {
			Vector<Parameter> params = new Vector<Parameter>();
			params.addElement(new Parameter("Kunde", String.class,
					"Best Western Hotel", null));
			params.addElement(new Parameter("Passwort", String.class,
					"BestJun17", null));
			Call call = new Call();
			call.setTargetObjectURI(sServiceUri);
			call.setMethodName(sMethodName);
			call.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
			call.setParams(params);
			resp = call.invoke(new URL(sServiceUrl), sServiceUri);

			Parameter result = resp.getReturnValue();
			String greeting = (String) result.getValue();
			log.info(greeting);

		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println("Error while calling '" + sMethodName + "':");
			System.err.println(ex.getMessage());
			return;
		}
	}
}
