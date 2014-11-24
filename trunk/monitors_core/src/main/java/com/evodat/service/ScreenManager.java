package com.evodat.service;

import java.util.List;

import com.evodat.model.Screen;

public interface ScreenManager extends GenericManager<Screen, Long> {

	Screen getScreen(String screenId);

	Screen saveScreen(Screen screen);

	void removeScreen(String screenId);

	List<Screen> getScreens();

}
