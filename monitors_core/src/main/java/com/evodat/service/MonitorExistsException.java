package com.evodat.service;

public class MonitorExistsException extends Exception {
	private static final long serialVersionUID = 7072899026463501965L;

	public MonitorExistsException(final String message) {
		super(message);
	}
}
