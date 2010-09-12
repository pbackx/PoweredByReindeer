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
package com.vaadinengine.ui.user.function;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.vaadinengine.MainApplication;
import com.vaadinengine.domain.user.User;
import com.vaadinengine.ui.user.LoginWindow;

public class LoginFunction implements Function {

	private static final long serialVersionUID = 1L;

	@Override
	public String getCaptionKey() {
		return "LoginFunction.caption";
	}

	@Override
	public boolean isAvailable(User user) {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication==null || "anonymousUser".equals(authentication.getPrincipal());
	}

	@Override
	public void launch(MainApplication application) {
		final LoginWindow loginWindow = new LoginWindow(application);
		application.getMainWindow().addWindow(loginWindow);
		loginWindow.addListener(application);
	}

}
