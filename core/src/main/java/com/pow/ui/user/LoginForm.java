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

import java.io.Serializable;
import java.lang.reflect.Method;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;

import com.vaadin.data.util.BeanItem;
import com.vaadin.terminal.UserError;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.pow.MainApplication;
import com.pow.domain.user.User;

public class LoginForm extends Form implements ClickListener {

	private static final long serialVersionUID = 1L;

	private MainApplication app;
	private Button loginButton;
	private HorizontalLayout buttonBar = new HorizontalLayout();

	private User user = new User();
	public LoginForm(MainApplication application)
	{
		this.app = application;
		
		setDescription(application.getMessage("LoginForm.description"));
		
		getFooter().addComponent(buttonBar);
		loginButton = new Button(application.getMessage("LoginForm.loginButton.caption"), (ClickListener)this);
		buttonBar.addComponent(loginButton);
		
		setFormFieldFactory(new LoginFormFieldFactory(application));

		BeanItem<User> userItem = new BeanItem<User>(user);
		setItemDataSource(userItem);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		if(!isValid())
			return;

		Button button = event.getButton();
		if(button == loginButton) {
			try {
				user.authenticate();
				fireLoggedin(user);
			} catch (BadCredentialsException e) {
				setComponentError(new UserError(app.getMessage("LoginForm.BadCredentialsException")));
			} catch (DisabledException e) {
				setComponentError(new UserError(app.getMessage("LoginForm.DisabledException")));
			}
		} 
	}


	// below is all about events & handling them
	
	private static final Method LOGGEDIN_METHOD;
	static {
		try {
			LOGGEDIN_METHOD = LoggedinListener.class.getDeclaredMethod("loggedin", new Class[] { LoggedinEvent.class });
		} catch (NoSuchMethodException e) {
			// This should never happen
            throw new java.lang.RuntimeException(
                    "Internal error finding methods in Button");
        }
	}
	
	public class LoggedinEvent extends Component.Event {
		private static final long serialVersionUID = 1L;
		private User user;
		public LoggedinEvent(Component source, User user) {
			super(source);
			this.user = user;
		}
		public User getUser() {
			return user;
		}
	}
	
	public interface LoggedinListener extends Serializable {
		public void loggedin(LoggedinEvent event);
	}
	
	public void addListener(LoggedinListener listener) {
		addListener(LoggedinEvent.class, listener, LOGGEDIN_METHOD);
	}
	
	public void removeListener(LoggedinListener listener) {
		removeListener(LoggedinEvent.class, listener, LOGGEDIN_METHOD);
	}
	
	protected void fireLoggedin(User user) {
		fireEvent(new LoggedinEvent(this, user));
	}
}
