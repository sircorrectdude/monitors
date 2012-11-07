package com.evodat.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evodat.dao.ScreenDao;
import com.evodat.model.Screen;
import com.evodat.service.ScreenManager;
import com.evodat.service.ScreenService;

@Service("screenManager")
@WebService(serviceName = "ScreenService", endpointInterface = "com.evodat.service.ScreenService")
public class ScreenManagerImpl extends GenericManagerImpl<Screen, Long>
		implements ScreenManager, ScreenService {

	private ScreenDao screenDao;

	@Autowired
	public void setScreenDao(ScreenDao screenDao) {
		this.dao = screenDao;
		this.screenDao = screenDao;
	}

	public Screen save(Screen screen) {
		return screenDao.save(screen);
	}

	public Screen getScreen(String screenId) {
		return screenDao.get(new Long(screenId));
	}

	public Screen saveScreen(Screen screen) {
		return screenDao.saveScreen(screen);
	}

	public void removeScreen(String screenId) {
		log.debug("removing screen: " + screenId);
		screenDao.remove(new Long(screenId));

	}

	public List<Screen> getScreens() {
		return screenDao.getAllDistinct();
	}

}
