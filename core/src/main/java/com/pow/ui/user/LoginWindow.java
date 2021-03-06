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
package com.pow.ui.user;

import com.vaadin.ui.Window;
import com.pow.MainApplication;
import com.pow.ui.user.LoginForm.LoggedinEvent;
import com.pow.ui.user.LoginForm.LoggedinListener;

public class LoginWindow extends Window implements LoggedinListener {
	
	private static final long serialVersionUID = 1991434747781442359L;

	private LoginForm form;
	
	public LoginWindow(final MainApplication application) {
		super(application.getMessage("LoginWindow.caption"));
		setWidth(30, UNITS_EM);
		setHeight(25, UNITS_EM);

		form = new LoginForm(application);
		form.addListener(this);
		addComponent(form);
	}

	@Override
	public void loggedin(LoggedinEvent event) {
		getApplication().getMainWindow().removeWindow(this);
	}
	
	public void addListener(LoggedinListener listener) {
		form.addListener(listener);
	}
}
