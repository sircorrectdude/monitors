package com.evodat.adac;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ADACServlet extends HttpServlet {

	private static final long serialVersionUID = 2210893804287737186L;
	private static Logger log = Logger.getLogger(ADACServlet.class);

	String endpointURL = "http://routenplaner.adac.de/webservice/ParkInfoServiceV2.asmx";
	String sServiceUri = "http://ADAC.ITP.WebServices/getDynamicData";
	String sMethodName = "getDynamicData";

	@Override
	protected void service(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws ServletException,
			IOException {

		super.service(httpServletRequest, httpServletResponse);
		log.info("request..");
		/*
		 * Response resp; try { Vector<Parameter> params = new
		 * Vector<Parameter>(); params.addElement(new Parameter("Kunde",
		 * String.class, "Best Western Hotel", null)); params.addElement(new
		 * Parameter("Passwort", String.class, "BestJun17", null)); Call call =
		 * new Call(); call.setTargetObjectURI(sServiceUri);
		 * call.setMethodName(sMethodName);
		 * call.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
		 * call.setParams(params); resp = call.invoke(new URL(sServiceUrl),
		 * sServiceUri);
		 * 
		 * Parameter result = resp.getReturnValue(); String greeting = (String)
		 * result.getValue(); log.info(greeting);
		 * 
		 * } catch (Exception ex) { ex.printStackTrace();
		 * System.err.println("Error while calling '" + sMethodName + "':");
		 * System.err.println(ex.getMessage()); return; }
		 */
		/*
		 * Service service = new Service(); Call call; try { call = (Call)
		 * service.createCall();
		 * 
		 * call.setTargetEndpointAddress(new java.net.URL(endpointURL));
		 * call.setOperationName(new QName("getDynamicData", "sMethodName"));
		 * call.addParameter("mesg", XMLType.XSD_STRING, ParameterMode.IN);
		 * call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);
		 * call.setSOAPActionURI(sServiceUri); String reply = (String)
		 * call.invoke(new Object[] { null });
		 * 
		 * System.out.println("Reply: " + reply); } catch (ServiceException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 */

		URL u = new URL(endpointURL);
		URLConnection uc = u.openConnection();
		HttpURLConnection connection = (HttpURLConnection) uc;

		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("SOAPAction", sServiceUri);

		OutputStream out = connection.getOutputStream();
		Writer wout = new OutputStreamWriter(out);

		wout.write("<?xml version='1.0' encoding='utf-8'?>\r\n");
		wout.write("<soap12:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:soap12='http://www.w3.org/2003/05/soap-envelope'>");
		wout.write("<soap12:Body>");
		wout.write("<getDynamicData xmlns='http://ADAC.ITP.WebServices/'>");
		wout.write("<Kunde>Best Western Hotel</Kunde>");
		wout.write("<Passwort>BestJun17</Passwort>");
		wout.write("</getDynamicData");
		wout.write("</soap12:Body>");
		wout.write("</soap12:Envelope>");

		wout.flush();
		wout.close();

		InputStream in = connection.getInputStream();
		int c;
		while ((c = in.read()) != -1)
			System.out.write(c);
		in.close();

	}
}
