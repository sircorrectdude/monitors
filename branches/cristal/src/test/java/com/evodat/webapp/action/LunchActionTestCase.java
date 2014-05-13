package com.evodat.webapp.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LunchActionTestCase extends BaseActionTestCase {

	private static final Log logger = LogFactory
			.getLog(LunchActionTestCase.class);

	private LunchAction action;

	public void setLunchAction(LunchAction action) {
		this.action = action;
	}

	public void testExecute() throws Exception {

		String execute = action.execute();
		logger.info("todaysLunch: " + action.getTodaysLunch());
		assertEquals("success", execute);

	}
}
