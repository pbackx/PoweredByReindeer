package com.vaadinengine;

import com.vaadin.Application;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

public class MainApplication extends Application {

	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		Window mainWindow = new Window("Vaadin-Engine");
		mainWindow.addComponent(new Label("Hello world!"));
		setMainWindow(mainWindow);
	}
	
}
