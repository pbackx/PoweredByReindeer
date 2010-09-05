package com.vaadinengine;

import com.vaadin.Application;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

public class MainApplication extends Application {

	@Override
	public void init() {
		Window mainWindow = new Window("Vaadin-Engine, putting the Vaadin in AppEngine");
		Label label = new Label("Hello world!");
		mainWindow.addComponent(label);
		setMainWindow(mainWindow);
	}

}
