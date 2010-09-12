/*
 *    Copyright 2010 Peter Backx, streamhead.com
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *    
 *    http://www.apache.org/licenses/LICENSE-2.0
 *    
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.vaadinengine;

import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.vaadin.Application;
import com.vaadinengine.ui.MainWindow;
import com.vaadinengine.ui.user.LoginForm.LoggedinEvent;
import com.vaadinengine.ui.user.LoginForm.LoggedinListener;
import com.vaadinengine.ui.user.function.Functions;

@Configurable
public class MainApplication extends Application implements LoggedinListener {

	private static final long serialVersionUID = 1L;

	private MainWindow mainWindow;
	
	@Autowired
	private Functions userFunctions;
	
	/**
	 * Sadly it is difficult, if not impossible to use Springs i18n support. 
	 * Many of the messagesources are not serializable and certainly not the
	 * application context (which usually comes with the message source if you
	 * use MessageSourceAware beans.
	 */
	private ResourceBundle i18n;
	
	@Override
	public void init() {
		i18n = ResourceBundle.getBundle("com.vaadinengine.i18n.VaadinEngineBundle", getLocale());
		
		mainWindow = new MainWindow(this);
		setMainWindow(mainWindow);
	}

	@Override
	public void loggedin(LoggedinEvent event) {
		setUser(event.getUser());
		mainWindow.loggedin(event);
	}

	public String getMessage(String key) {
		return i18n.getString(key);
	}
	
	public Functions getUserFunctions() {
		return userFunctions;
	}

}
