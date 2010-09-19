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
package com.pow.i18n;

import java.io.Serializable;
import java.util.ListResourceBundle;

public class PowBundle_en extends ListResourceBundle implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected Object[][] getContents() {
		return contents;
	}
	
    static final Object[][] contents = {
    	{"MainWindow.title","Vaadin-Engine, putting the Vaadin in AppEngine"},
    	{"MainWindow.loggedin","Login successful"},
    	
    	{"LoginFunction.caption", "Login"},
    	{"LogoutFunction.caption", "Logout"},
    	{"AdminFunction.caption", "Sample admin function"},
    	
    	{"LoginWindow.caption", "Login"},
    	{"LoginFormFieldFactory.email", "E-mail"},
    	{"LoginFormFieldFactory.password", "Password"},
    	{"LoginForm.loginButton.caption", "Login"},
    	{"LoginForm.description", "Please enter the login and password with which you registered."},
		{"LoginForm.BadCredentialsException", "Your email and/or password are incorrect."},
		{"LoginForm.DisabledException","Your account is currently disabled."},
    };
    
}
