package com.evodat.webapp.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author joris
 * 
 */
public class SignalServlet extends HttpServlet {

	private static final long serialVersionUID = 1289746574872761079L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		int remainTime = SignalValue.getInstance().getRemainTime();
		PrintWriter out = resp.getWriter();
		out.print(remainTime);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPut(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String parameter = req.getParameter("remainTime");
		System.out.println("remainTime" + parameter);
		int remainTime = Integer.valueOf(parameter);
		SignalValue.getInstance().setRemainTime(remainTime);
		remainTime = SignalValue.getInstance().getRemainTime();
		PrintWriter out = resp.getWriter();
		out.print(remainTime);
	}

}
