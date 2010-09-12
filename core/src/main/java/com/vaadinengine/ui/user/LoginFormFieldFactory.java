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
package com.vaadinengine.ui.user;

import com.vaadin.data.Item;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormFieldFactory;
import com.vaadin.ui.TextField;
import com.vaadinengine.MainApplication;

public class LoginFormFieldFactory implements FormFieldFactory {

	private static final long serialVersionUID = 1L;
	
	private MainApplication app;
	
	public LoginFormFieldFactory(MainApplication app) {
		super();
		this.app = app;
	}

	@Override
	public Field createField(Item item, Object propertyId, Component uiContext) {
		String pid = (String)propertyId;
		if(pid.equals("password")) {
			TextField passwordField = new TextField(app.getMessage("LoginFormFieldFactory.password"));
			passwordField.setSecret(true);
			return passwordField;
		} else if (pid.equals("email")){
			return new TextField(app.getMessage("LoginFormFieldFactory.email"));
		}
		return null;
	}

}
