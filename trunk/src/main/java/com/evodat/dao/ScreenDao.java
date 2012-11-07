package com.evodat.dao;

import com.evodat.model.Screen;

public interface ScreenDao extends GenericDao<Screen, Long> {
	Screen saveScreen(Screen screen);

}
