package com.evodat.service;

import java.util.List;

import javax.jws.WebService;

import com.evodat.model.Screen;

@WebService
public interface ScreenService {
	Screen getScreen(String screenId);

	Screen saveScreen(Screen screen);

	void removeScreen(String screenId);

	List<Screen> getScreens();
}
